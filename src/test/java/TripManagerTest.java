import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class TripManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private BoatTripManager tripManager;
    private BoatTripPriceCalculator calculator;


    @Before
    public void initialize() {
        tripManager = new BoatTripManager();
        calculator = new BoatTripPriceCalculator();
        System.setOut(new PrintStream(outContent));
    }

    // Userstory 5
    @Test
    public void noTripsTestAverageTime() throws Exception {
        BoatTripManager a = new BoatTripManager(); // Nu kan je bij de tripmanager.
        Assert.assertEquals(0, a.averageTripTime());

    }


    @Test
    public void createTrip() throws Exception {
        assertEquals(0, tripManager.getCompletedTrips().size());
        tripManager.createTrip(BoatTripType.LAKE_TRIP);
        BoatTrip boatTrip = tripManager.getActiveTrips().get(1);
        assertEquals(1, boatTrip.getTripNumber());
        assertEquals(1, tripManager.getActiveTrips().size());
        assertNotEquals(null, boatTrip.getStartTime());
    }

    @Test
    public void endTrip() throws Exception {
        BoatTrip trip = tripManager.createTrip(BoatTripType.LAKE_TRIP);
        assertEquals(null, trip.getEndTime());
        tripManager.endTrip(trip.getTripNumber());
        assertNotEquals(null, trip.getEndTime());
    }

    @Test(expected = BoatTripException.class)
    public void endTripInvalidTripNumber() throws Exception {
        tripManager.createTrip(BoatTripType.LAKE_TRIP);
        tripManager.endTrip(4);
    }

    @Test
    public void getBoatTrips() throws Exception {
        tripManager.createTrip(BoatTripType.LAKE_TRIP);
        assertEquals(1, tripManager.getActiveTrips().size());
        assertEquals(0, tripManager.getCompletedTrips().size());
        tripManager.endTrip(1);
        assertEquals(0, tripManager.getActiveTrips().size());
        assertEquals(1, tripManager.getCompletedTrips().size());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    // Userstory 2
    @Test
    public void endExistingTripTest() throws Exception {
        BoatTripManager t = new BoatTripManager();
        BoatTrip trip = t.createTrip(BoatTripType.LAKE_TRIP);
        t.endTrip(trip.getTripNumber());
    }

    @Test(expected = BoatTripException.class)
    public void endTripWrongNumberTest() throws Exception{
        BoatTripManager t = new BoatTripManager();
        t.endTrip(2);
    }

    @Test
    public void tripsTestAverageTime() throws Exception {
        BoatTripManager a1 = new BoatTripManager();
        a1.createTrip(BoatTripType.LAKE_TRIP);
        a1.createTrip(BoatTripType.LAKE_TRIP);
        a1.endTrip(1);
        a1.endTrip(2);
        // Pas eindtijd aan omdat er anders geen verschil tussen start en eindtijd zit.
        HashMap<Integer, BoatTrip> trips = a1.getCompletedTrips();
        trips.get(1).setEndTime(LocalDateTime.now().minusMinutes(35));
        trips.get(2).setEndTime(LocalDateTime.now().minusMinutes(35));
        Assert.assertNotEquals(0, a1.averageTripTime());
    }

    @Test
    public void endTripPriceCalculatorError() throws Exception {
        Weather weather = calculator.getWeather();
        weather.setApiURL("http://dsfsifusdfufdgdhfigiufdhfg.com");
        weather.updateWeatherData();
        assertEquals("Geen weerinformatie beschikbaar, kijk naar buiten voor actuele weer informatie\r\n", outContent.toString());
    }
}