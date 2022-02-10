package tk.vivas.transport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import tk.vivas.transport.request.*;
import tk.vivas.transport.request.locationInformation.InitialInput;
import tk.vivas.transport.request.locationInformation.LocationInformationRequest;
import tk.vivas.transport.request.locationInformation.Restrictions;
import tk.vivas.transport.request.trip.*;
import tk.vivas.transport.response.trip.LegMarker;
import tk.vivas.transport.response.trip.InterchangeLeg;
import tk.vivas.transport.response.trip.Leg;
import tk.vivas.transport.response.trip.LegAlight;
import tk.vivas.transport.response.trip.LegBoard;
import tk.vivas.transport.response.trip.ServiceDepartureArrival;
import tk.vivas.transport.response.trip.TimedLeg;
import tk.vivas.transport.response.TriasResponse;
import tk.vivas.transport.response.trip.TripLeg;
import tk.vivas.transport.response.trip.TripResult;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * Hello world!
 */
public class App {

    static String API_KEY = "57c5dbbbf1fe4d000100001842c323fa9ff44fbba0b9b925f0c052d1";

    static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) throws IOException, InterruptedException {

        XmlMapper xmlMapper = getXmlMapper();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Select first place: ");
        String firstLocationInformationRequest = createLocationInformationRequest(xmlMapper, scanner.nextLine());

        System.out.println("Select second place: ");
        String secondLocationInformationRequest = createLocationInformationRequest(xmlMapper, scanner.nextLine());

        // System.out.println(firstLocationInformationRequest);

        String firstLocation = getLocation(xmlMapper, firstLocationInformationRequest);
        String secondLocation = getLocation(xmlMapper, secondLocationInformationRequest);

        String data = createTripRequestDocument(xmlMapper, firstLocation, secondLocation);
        // System.out.println(data);

        String response = getFromWeb(data);
        // System.out.println(XmlFormatter.format(response));

        TriasResponse trias = xmlMapper.readValue(response, TriasResponse.class);

        printResult(trias);
    }

    private static String getLocation(XmlMapper mapper,String secondLocationInformationRequest)
            throws IOException, InterruptedException {
        String response = getFromWeb(secondLocationInformationRequest);

        // System.out.println(XmlFormatter.format(response));

        TriasResponse trias = mapper.readValue(response, TriasResponse.class);

        return trias.getServiceDelivery()
                .getDeliveryPayload()
                .getLocationInformationResponse()
                .getLocation()
                .get(0)
                .getLocation()
                .getStopPoint()
                .getStopPointRef();
    }

    private static void printResult(TriasResponse trias) {

        // System.out.println(trias.getServiceDelivery().getResponseTimestamp());
        List<TripResult> tripResultList = trias
                .getServiceDelivery()
                .getDeliveryPayload()
                .getTripResponse()
                .getTripResult();
        if (tripResultList == null) {
            return;
        }
        for (TripResult tripResult : tripResultList) {
            System.out.println("=====================================");
            System.out.println("Dauer:     " + formatDuration(tripResult.getTrip().getDuration()));
            System.out.println("Umsteigen: " + tripResult.getTrip().getInterchanges() + "×");

            List<TripLeg> tripLegList = tripResult
                    .getTrip()
                    .getTripLeg();

            for (TripLeg tripLeg : tripLegList) {
                Class<? extends LegMarker> legType = tripLeg.getLeg().getClass();
                if (legType == TimedLeg.class){
                    System.out.println("–––––––––––––––––––––––––––––––––––––");
                    TimedLeg timedLeg = (TimedLeg) tripLeg.getLeg();
                    LegBoard legBoard = timedLeg.getLegBoard();
                    LegAlight legAlight = timedLeg.getLegAlight();

                    String line = timedLeg.getService().getPublishedLineName().getText();
                    String mode = timedLeg.getService().getMode().getName().getText();
                    String destination = timedLeg.getService().getDestinationText().getText();
                    String journeyRefFull = timedLeg.getService().getJourneyRef();
                    String journeyRef = Iterables.getLast(Splitter.on(":").split(journeyRefFull));

                    System.out.println(mode + " " + line + " [" + journeyRef + "] Richtung " + destination);

                    String stationDeparture = getStationName(legBoard, mode);
                    LocalDateTime timeDeparture = getTime(legBoard.getServiceDeparture());
                    String stationArrival = getStationName(legAlight, mode);
                    LocalDateTime timeArrival = getTime(legAlight.getServiceArrival());

                    printTrip(stationDeparture, timeDeparture, stationArrival, timeArrival);
                }
            }
        }
    }

    private static String formatDuration(Duration duration) {
        long HH = duration.toHours();
        long MM = duration.toMinutesPart();

        String durationFormatted;
        if (HH == 0) {
            durationFormatted = String.format("%02d min", MM);
        } else {
            durationFormatted = String.format("%02d h %02d min", HH, MM);
        }
        return durationFormatted;
    }

    private static XmlMapper getXmlMapper() {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.setTimeZone(TimeZone.getTimeZone("Europe/Zurich"));

        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return xmlMapper;
    }

    private static void printTrip(String stationDeparture, LocalDateTime timeDeparture,
                                  String stationArrival, LocalDateTime timeArrival) {
        System.out.println(timeDeparture.format(FORMATTER) + " " + stationDeparture + " -> " +
                timeArrival.format(FORMATTER) + " " + stationArrival);
    }

    private static String getStationName(Leg leg, String mode) {
        String stationName = leg.getStopPointName().getText();
        String plattform = switch (mode) {
            case "Zug" -> "Gleis";
            case "Schiff" -> "Steg";
            default -> "Kante";
        };
        if (leg.getEstimatedBay() != null) {
            stationName += ", " + plattform + " " + leg.getEstimatedBay().getText();
        } else if (leg.getPlannedBay() != null) {
            stationName += ", " + plattform + " " + leg.getPlannedBay().getText();
        }
        return stationName;
    }

    private static LocalDateTime getTime(ServiceDepartureArrival serviceDepartureArrival) {
        LocalDateTime estimatedTime = serviceDepartureArrival.getEstimatedTime();
        if (estimatedTime == null) {
            return serviceDepartureArrival.getTimetabledTime();
        } else {
            return estimatedTime;
        }
    }

    private static String createLocationInformationRequest(XmlMapper mapper, String locationName)
            throws JsonProcessingException {

        InitialInput initialInput = new InitialInput(locationName);
        Restrictions restrictions = new Restrictions(1);

        RequestPayload requestPayload = new RequestPayload(
                new LocationInformationRequest(initialInput, restrictions));

        TriasRequest trias = new TriasRequest(
                new ServiceRequest(LocalDateTime.now(), "API-Explorer", requestPayload));

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trias);
    }

    private static String createTripRequestDocument(XmlMapper mapper, String originPoint, String destinationPoint)
            throws IOException {

        Origin origin = new Origin(
                new LocationRef(originPoint), LocalDateTime.now().plus(Duration.ofMinutes(20)));
        Destination destination = new Destination(
                new LocationRef(destinationPoint));
        Params params = new Params(10);

        RequestPayload requestPayload = new RequestPayload(
                new TripRequest(origin, destination, params));

        TriasRequest trias = new TriasRequest(
                new ServiceRequest(LocalDateTime.now(), "API-Explorer", requestPayload));

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trias);
    }

    private static String getFromWeb(String data) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.opentransportdata.swiss/trias2020"))
                .POST(BodyPublishers.ofString(data))
                .header("Authorization", API_KEY)
                .header("Content-Type", "application/xml")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        // System.out.println(response.statusCode());
        return response.body();
    }
}
