import java.time.LocalDate;
import java.time.LocalDateTime;
//BoatTrip
public class BoatTrip {

    private LocalDateTime startTime;
    private int tripNumber;

    public BoatTrip(LocalDateTime currentTime,int identifier){

        startTime = currentTime;
        tripNumber = identifier;

    }

    // Getter startTime
    public LocalDateTime getStartTime()
    {
        return this.startTime;
    }
    // Setter startTime
    public void setStartTime(LocalDateTime dateTime)
    {
        this.startTime = dateTime;
    }

    public int getTripNumber()
    {
        return this.tripNumber;
    }
    public void setStartTime(int number)
    {
        this.tripNumber = number;
    }

}
