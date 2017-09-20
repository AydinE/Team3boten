import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//BoatTrip
public class BoatTrip {

    private static final BoatTripPriceCalculator priceCalculator = new BoatTripPriceCalculator();

    private LocalDateTime startTime;
    private int tripNumber;
    private LocalDateTime endTime;
    private double tripPrice;
    private BoatTripType tripType;
    private int boatNumber;

    public BoatTrip(int identifier, BoatTripType tripType, int boatNumber) {
        tripNumber = identifier;
        this.tripType = tripType;
        this.boatNumber = boatNumber;
    }

    public void start() {
        startTime = tripType.getStartTime(LocalDateTime.now());
    }

    public void stop() {
        endTime = LocalDateTime.now();
        priceCalculator.updateWeather();
        tripPrice = priceCalculator.calculateTripPrice(this);
    }

    public Duration getDuration() throws BoatTripException{

        if (endTime.equals(null)) {
            throw new BoatTripException("No endtime known");
        }
        Duration duration = Duration.between(startTime, endTime);
        {
            if (startTime.compareTo(endTime) < 0) ;
            System.out.println("Duration can not be lower then 0 minutes");
        }
    return duration;
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

    // Getter boatNumber
    public int getBoatNumber() {
        return this.boatNumber;
    }

    // Setter tripPrice
    public void setBoatNumber(int boatNumber) {
        this.boatNumber = boatNumber;
    }
}
