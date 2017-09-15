import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class BoatTripTest {

    private final LocalDateTime startTime = LocalDateTime.of(2017, 1, 1, 12,15);
    private final LocalDateTime endTime = LocalDateTime.of(2017, 1, 1, 13,30);

    private final int tripNumber = 1;
    private final double tripPrice = 10.5;

    private BoatTrip boatTrip;

    @Before
    public void initialize() {
        boatTrip = new BoatTrip(startTime, tripNumber);
    }

    @Test
    public void getEndTime() throws Exception {
        assertEquals(null, boatTrip.getEndTime());
        boatTrip.setEndTime(endTime);
        assertEquals(endTime, boatTrip.getEndTime());
    }

    @Test
    public void setEndTime() throws Exception {
        boatTrip.setEndTime(endTime);
        assertEquals(endTime, boatTrip.getEndTime());
    }

    @Test
    public void getStartTime() throws Exception {
        assertEquals(startTime, boatTrip.getStartTime());
    }

    @Test
    public void setStartTime() throws Exception {
        boatTrip.setStartTime(startTime);
        assertEquals(startTime, boatTrip.getStartTime());
    }

    @Test
    public void getTripNumber() throws Exception {
        assertEquals(tripNumber, boatTrip.getTripNumber());
    }

    @Test
    public void setTripNumber() throws Exception {
        boatTrip.setTripNumber(tripNumber);
        assertEquals(tripNumber, boatTrip.getTripNumber());
    }

    @Test
    public void getTripPrice() throws Exception {
        assertEquals(0.0d, boatTrip.getTripPrice(), 0);
        boatTrip.setTripPrice(tripPrice);
        assertEquals(tripPrice, boatTrip.getTripPrice(), 0);
    }

}