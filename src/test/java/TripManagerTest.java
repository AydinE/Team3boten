import org.junit.Assert;
import org.junit.Test;

public class TripManagerTest {
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
}
// starten test verwachte resultaat?