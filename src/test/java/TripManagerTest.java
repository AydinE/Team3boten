import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.List;

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
    public void TripsTestAverageTime() throws InterruptedException {
        TripManager a1 = new TripManager();
        a1.createTrip();
        a1.createTrip();
        a1.endTrip(1);
        a1.endTrip(2);
        // Pas eindtijd aan omdat er anders geen verschil tussen start en eindtijd zit.
        List<BoatTrip> trips = a1.getBoatTrips();
        trips.get(0).setEndTime(LocalDateTime.now().minusMinutes(35));
        trips.get(1).setEndTime(LocalDateTime.now().minusMinutes(35));
        Assert.assertNotEquals( 0 , a1.averageTripTime());

    }

}