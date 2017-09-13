import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();

    public void createTrip() {
        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip);

    }

}