import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TripManagerTest {

    private TripManager tripManager;

    @Before
    public void initialize() {
        tripManager = new TripManager();
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
    public void endTrip1() throws Exception {
        tripManager.createTrip();
        BoatTrip boatTrip = tripManager.getBoatTrips().get(0);
        assertEquals(null, boatTrip.getEndTime());
        tripManager.endTrip(4);
        assertEquals("wrong number", boatTrip.getEndTime());
    }

    @Test
    public void getBoatTrips() throws Exception {
    }

}