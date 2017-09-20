import java.time.Duration;

public class Boat {

    private int boatNumber;
    private Duration timeSinceLastInspection;

    public Boat(int boatNumber){
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
