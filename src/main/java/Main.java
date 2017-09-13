import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        int identifier = 1;
        BoatTrip boatTrip1 = new BoatTrip(currentTime, identifier);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy  HH:mm");
        String out = currentTime.format(formatter);
        System.out.println(out);
    }
}
