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

}
