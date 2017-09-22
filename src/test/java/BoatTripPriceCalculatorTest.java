import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class BoatTripPriceCalculatorTest {

    private BoatTripPriceCalculator calculator;
    private Weather weather;
    private LocalDateTime over2uur;
    private LocalDateTime now;

    @Before
    public void initialize() {
        calculator = new BoatTripPriceCalculator();
        weather = calculator.getWeather();
        now = LocalDateTime.now();
        over2uur = now.plusHours(2);
    }
    /*
    Senario's and naming of the endTripPriceCalculator devided in Laketrips and RiverTrips:
       Name     Senario
       LakeA  = 26 degrees Celsius and its raining
       LakeB  = 16 degrees Celsius and its raining
       LakeC  = 19 degrees Celsius and its raining
       LakeD  = 26 degrees Celsius and its not raining
       LakeE  = 19 degrees Celsius and its not raining
       LakeF  = 16 degrees Celsius and its not raining

       RiverA = 26 degrees Celsius and its raining
       RiverB = 16 degrees Celsius and its raining
       RiverC = 19 degrees Celsius and its raining
       RiverD = 26 degrees Celsius and its not raining
       RiverE = 19 degrees Celsius and its not raining
       RiverF = 16 degrees Celsius and its not raining
    */

    @Test
    public void endTripPriceCalculatorLakeA() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((14), price, 0);
    }

    @Test
    public void endTripPriceCalculatorLakeB() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((12), price, 0);
    }

    @Test
    public void endTripPriceCalculatorLakeC() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((8), price, 0);
    }

    @Test
    public void endTripPriceCalculatorLakeD() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((16), price, 0);
    }

    @Test
    public void endTripPriceCalculatorLakeE() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((14), price, 0);
    }

    @Test
    public void endTripPriceCalculatorLakeF() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.LAKE_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((10), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverA() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((10.5), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverB() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((9), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverC() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(true);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((6), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverD() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(26));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((12), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverE() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(19));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((10.5), price, 0);
    }

    @Test
    public void endTripPriceCalculatorRiverF() {
        BoatTrip trip = new BoatTrip(1, BoatTripType.RIVER_TRIP, 1);
        trip.start();
        trip.setEndTime(over2uur);
        weather.setRaining(false);
        weather.setTemperature(new BigDecimal(16));
        double price = calculator.calculateTripPrice(trip);
        System.out.println("€ " + price);
        assertEquals((7.5), price, 0);
    }
}
