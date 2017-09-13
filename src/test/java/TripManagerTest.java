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
        // TODO: Check if error is printed to console
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

}