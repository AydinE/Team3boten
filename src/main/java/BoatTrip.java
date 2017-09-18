import java.time.LocalDateTime;

//BoatTrip
public class BoatTrip {

    private LocalDateTime startTime;
    private int tripNumber;
    private LocalDateTime endTime;
    private double tripPrice;

    public BoatTrip(LocalDateTime currentTime, int identifier) {
        startTime = currentTime;
        tripNumber = identifier;
    }

    //Getter endTime
    public LocalDateTime getEndTime() {
        return this.endTime;
    }

    //Settter endTime
    public void setEndTime(LocalDateTime dateTime) {
        this.endTime = dateTime;
    }

    // Getter startTime
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    // Setter startTime
    public void setStartTime(LocalDateTime dateTime) {
        this.startTime = dateTime;
    }

    public int getTripNumber() {
        return this.tripNumber;
    }

    public void setTripNumber(int number) {
        this.tripNumber = number;
    }

    public double getTripPrice() {
        return this.tripPrice;
    }

    public void setTripPrice(double price) {
        this.tripPrice = price;
    }

}
