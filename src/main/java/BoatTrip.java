import java.time.LocalDate;
import java.time.LocalDateTime;

public class BoatTrip {

    public LocalDate startDate;
    public LocalDateTime startTime;
    public int tripNumber;

    public int BoatTrip(LocalDate currentDate, LocalDateTime currentTime,int identifier){

        startDate = currentDate;
        startTime = currentTime;
        tripNumber = identifier;

        return identifier;

    }

}
