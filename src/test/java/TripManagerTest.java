import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TripManagerTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private TripManager tripManager;



    @Before
    public void initialize() {
        tripManager = new TripManager();
        System.setOut(new PrintStream(outContent));
    }

    // Userstory 5
    @Test
    public void noTripsTestAverageTime() throws InterruptedException {
        TripManager a = new TripManager (); // Nu kan je bij de tripmanager.
        Assert.assertEquals(0,a.averageTripTime());

    }



    @Test
    public void createTrip() throws Exception {
        assertEquals(0, tripManager.getBoatTrips().size());
        tripManager.createTrip();
        BoatTrip boatTrip = tripManager.getBoatTrips().get(0);
        assertEquals(1, boatTrip.getTripNumber());
        assertEquals(1, tripManager.getBoatTrips().size());
        assertNotEquals(null, boatTrip.getStartTime());
    }

    @Test
    public void endTrip() throws Exception {
        tripManager.createTrip();
        BoatTrip boatTrip = tripManager.getBoatTrips().get(0);
        assertEquals(null, boatTrip.getEndTime());
        tripManager.endTrip(1);
        assertNotEquals(null, boatTrip.getEndTime());
    }

    @Test
    public void endTripInvalidTripNumber() throws Exception {
        tripManager.createTrip();
        BoatTrip boatTrip = tripManager.getBoatTrips().get(0);
        tripManager.endTrip(4);
        assertTrue(outContent.toString().equals("wrong number\r\n"));
    }
    @Test
    public void getBoatTrips() throws Exception {
        tripManager.createTrip();
        int boatTripCount = tripManager.getBoatTrips().size();
        assertEquals(1, boatTripCount);
        tripManager.endTrip(1);
        assertEquals(1, boatTripCount);
        tripManager.createTrip();
        tripManager.endTrip(2);
        boatTripCount = tripManager.getBoatTrips().size();
        assertEquals(2, boatTripCount);
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    // Userstory 2
    @Test
    public void endExistingTripTest() {
        TripManager t = new TripManager();
        int identifier = t.createTrip();
        boolean result = t.endTrip(identifier);
        Assert.assertTrue(result); // assert=verwachting
    }
    @Test
    public void endTripWrongNumberTest() {
        TripManager t = new TripManager();
        boolean result = t.endTrip(2);
        Assert.assertFalse(result); // assert=verwachting
    }

    @Test
    public void tripsTestAverageTime() throws InterruptedException {
        TripManager a1 = new TripManager();
        a1.createTrip();
        Thread.sleep(2000);
        a1.createTrip();
        Thread.sleep(2000);
        a1.endTrip(1);
        a1.endTrip(2);
        Assert.assertNotEquals( 0 , a1.averageTripTime());

    }

    @Test
    public void endTripPriceCalculator26rain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println( "€ " + price);
        assertEquals((14), price, 0);
    }
    @Test
    public void endTripPriceCalculator26norain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println("€ " + price);
        assertEquals((16), price, 0);
    }
    @Test
    public void endTripPriceCalculator16rain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println("€ " + price);
        assertEquals((8), price, 0);
    }
    @Test
    public void endTripPriceCalculator19rain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println("€ " + price);
        assertEquals((12), price, 0);
    }
    @Test
    public void endTripPriceCalculator16norain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println("€ " + price);
        assertEquals((10), price, 0);
    }
    @Test
    public void endTripPriceCalculator19norain() {
        BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
        WeatherInfo weather = tripManager.getWeather();
        LocalDateTime now = LocalDateTime.now();
        BoatTrip trip = new BoatTrip(now, 1);
        LocalDateTime over2uur = now.plusHours(2);
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip, weather);
        System.out.println("€ " + price);
        assertEquals((14), price, 0);
    }
}