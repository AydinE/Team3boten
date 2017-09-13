import java.time.LocalDate;
import java.time.LocalDateTime;
//BoatTrip
public class BoatTrip {

    public LocalDateTime startTime;
    public int tripNumber;

    public BoatTrip(LocalDateTime currentTime,int identifier){

        startTime = currentTime;
        tripNumber = identifier;

    }

}
