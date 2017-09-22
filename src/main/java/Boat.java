import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Boat {

    private int boatNumber;
    private Duration timeSinceLastInspection = Duration.of(0, ChronoUnit.SECONDS);

    public Boat(int boatNumber) {
        this.boatNumber = boatNumber;
    }

    public int getBoatNumber() {
        return this.boatNumber;
    }

    public Duration getTimeSinceLastInspection() {
        return this.timeSinceLastInspection;
    }

    public void setTimeSinceLastInspection(Duration timeSinceLastInspection) {
        this.timeSinceLastInspection = timeSinceLastInspection;
    }

}
