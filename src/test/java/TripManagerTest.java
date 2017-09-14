import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TripManagerTest {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private TripManager tripManager;

    @Before
    public void initialize() {
        tripManager = new TripManager();
        System.setOut(new PrintStream(outContent));
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

}