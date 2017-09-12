import java.time.LocalDate;
import java.time.LocalDateTime;
//BoatTrip
public class BoatTrip {

    public LocalDate startDate;
    public LocalDateTime startTime;
    public int tripNumber;

    public BoatTrip(LocalDate currentDate, LocalDateTime currentTime,int identifier){

        startDate = currentDate;
        startTime = currentTime;
        tripNumber = identifier;

    }

}
