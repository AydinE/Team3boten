import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class TripManagerTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private BoatTripManager tripManager;


    @Before
    public void initialize() {
        tripManager = new BoatTripManager();
        System.setOut(new PrintStream(outContent));
    }

    // Userstory 5
    @Test
    public void noTripsTestAverageTime() throws InterruptedException {
        BoatTripManager a = new BoatTripManager(); // Nu kan je bij de tripmanager.
        Assert.assertEquals(0, a.averageTripTime());

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
        BoatTripManager t = new BoatTripManager();
        int identifier = t.createTrip();
        boolean result = t.endTrip(identifier);
        Assert.assertTrue(result); // assert=verwachting
    }

    @Test
    public void endTripWrongNumberTest() {
        BoatTripManager t = new BoatTripManager();
        boolean result = t.endTrip(2);
        Assert.assertFalse(result); // assert=verwachting
    }

    @Test
    public void tripsTestAverageTime() throws InterruptedException {
        BoatTripManager a1 = new BoatTripManager();
        a1.createTrip();
        a1.createTrip();
        a1.endTrip(1);
        a1.endTrip(2);
        // Pas eindtijd aan omdat er anders geen verschil tussen start en eindtijd zit.
        List<BoatTrip> trips = a1.getBoatTrips();
        trips.get(0).setEndTime(LocalDateTime.now().minusMinutes(35));
        trips.get(1).setEndTime(LocalDateTime.now().minusMinutes(35));
        Assert.assertNotEquals(0, a1.averageTripTime());
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
        System.out.println("€ " + price);
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

    @Test
    public void endTripPriceCalculatorError() throws Exception {
        WeatherInfo weather = tripManager.getWeather();
        weather.setApiURL("http://dsfsifusdfufdgdhfigiufdhfg.com");
        weather.updateWeatherData();
        assertEquals("Geen weerinformatie beschikbaar, kijk naar buiten voor actuele weer informatie\r\n", outContent.toString());
    }
}