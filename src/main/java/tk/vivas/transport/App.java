package tk.vivas.transport;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import tk.vivas.transport.tripRequest.*;
import tk.vivas.transport.tripResponse.AbstractLeg;
import tk.vivas.transport.tripResponse.InterchangeLeg;
import tk.vivas.transport.tripResponse.Leg;
import tk.vivas.transport.tripResponse.LegAlight;
import tk.vivas.transport.tripResponse.LegBoard;
import tk.vivas.transport.tripResponse.ServiceDepartureArrival;
import tk.vivas.transport.tripResponse.TimedLeg;
import tk.vivas.transport.tripResponse.TriasTripResponse;
import tk.vivas.transport.tripResponse.TripLeg;
import tk.vivas.transport.tripResponse.TripResult;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
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
import java.util.TimeZone;

/**
 * Hello world!
 */
public class App {

    static String API_KEY = "57c5dbbbf1fe4d000100001842c323fa9ff44fbba0b9b925f0c052d1";

    static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) throws IOException, InterruptedException {

        XmlMapper xmlMapper = getXmlMapper();
        String data = createTripRequestDocument(xmlMapper, 5,
                "8516161", "8589236");
        System.out.println(data);

        String response = getFromWeb(data);
        System.out.println(XmlFormatter.format(response));

        readResponse(xmlMapper, response);
    }

    private static void readResponse(XmlMapper xmlMapper, String response)
            throws IOException {

        TriasTripResponse trias = xmlMapper.readValue(response, TriasTripResponse.class);

        System.out.println(trias.getServiceDelivery().getResponseTimestamp());
        List<TripResult> tripResultList = trias
                .getServiceDelivery()
                .getDeliveryPayload()
                .getTripResponse()
                .getTripResult();
        for (TripResult tripResult : tripResultList) {
            System.out.println(tripResult.getTrip().getDuration());
            System.out.println(tripResult.getTrip().getInterchanges());

            List<TripLeg> tripLegList = tripResult
                    .getTrip()
                    .getTripLeg();

            for (TripLeg tripLeg : tripLegList) {
                System.out.println("–––––––––––––––––––––––––––––––––––––");
                Class<? extends AbstractLeg> legType = tripLeg.getLeg().getClass();
                if (legType == InterchangeLeg.class) {
                    InterchangeLeg interchangeLeg = (InterchangeLeg) tripLeg.getLeg();
                    System.out.println(interchangeLeg.getInterchangeMode());
                    System.out.println(interchangeLeg.getDuration());

                    LocalDateTime startTime = interchangeLeg.getTimeWindowStart();
                    LocalDateTime endTime = interchangeLeg.getTimeWindowEnd();
                    String startName = interchangeLeg.getLegStart().getLocationName().getText();
                    String endName = interchangeLeg.getLegEnd().getLocationName().getText();

                    printTrip(startName, startTime, endName, endTime);
                } else if (legType == TimedLeg.class){
                    TimedLeg timedLeg = (TimedLeg) tripLeg.getLeg();
                    LegBoard legBoard = timedLeg.getLegBoard();
                    LegAlight legAlight = timedLeg.getLegAlight();

                    String line = timedLeg.getService().getPublishedLineName().getText();
                    String mode = timedLeg.getService().getMode().getName().getText();

                    System.out.println(line + " [" + mode + "]");

                    String stationDeparture = getStationName(legBoard);
                    LocalDateTime timeDeparture = getTime(legBoard.getServiceDeparture());
                    String stationArrival = getStationName(legAlight);
                    LocalDateTime timeArrival = getTime(legAlight.getServiceArrival());

                    printTrip(stationDeparture, timeDeparture, stationArrival, timeArrival);
                }
            }

            System.out.println("=====================================");
        }
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

    private static String getStationName(Leg leg) {
        String stationName = leg.getStopPointName().getText();
        if (leg.getPlannedBay() != null) {
            stationName += ", Plattform " + leg.getPlannedBay().getText();
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

    private static String createTripRequestDocument(XmlMapper mapper, int numberOfResults,
                                                    String originPoint, String destinationPoint) throws IOException {

        Origin origin = new Origin(
                new LocationRef(originPoint), LocalDateTime.now());
        Destination destination = new Destination(
                new LocationRef(destinationPoint));
        Params params = new Params(numberOfResults);

        RequestPayload requestPayload = new RequestPayload(
                new TripRequest(origin, destination, params));

        TriasTripRequest trias = new TriasTripRequest(
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

        System.out.println(response.statusCode());
        return response.body();
    }
}
