import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//BoatTrip
public class BoatTrip {

    private LocalDateTime startTime;
    private int tripNumber;
    private LocalDateTime endTime;
    private double tripPrice;
    private BoatTripType tripType;

    public BoatTrip(LocalDateTime currentTime, int identifier, BoatTripType tripType) {
        startTime = currentTime;
        tripNumber = identifier;
        this.tripType = tripType;
    }


    public void printTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
        System.out.println();
        System.out.println("Trip type: " + getTripType());
        System.out.println("Trip number: " + getTripNumber());
        System.out.println("Trip start time: " + getStartTime().format(formatter));


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

    // Getter tripNumber
    public int getTripNumber() {
        return this.tripNumber;
    }

    // Setter tripNumber
    public void setTripNumber(int number) {
        this.tripNumber = number;
    }
    // Getter tripPrice
    public double getTripPrice() {
        return this.tripPrice;
    }

    // Setter tripPrice
    public void setTripPrice(double price) {
        this.tripPrice = price;
    }

    //Getter tripType
    public BoatTripType getTripType() {return this.tripType; }

    //Setter tripType
    public void setTripType(BoatTripType tripType) { this.tripType = tripType; }
}
