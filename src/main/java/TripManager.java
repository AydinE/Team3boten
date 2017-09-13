import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();

    public void createTrip() {
        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip); // waarom nog een keer add?
    }

    public void endTrip(int tripnumber) {
        for (int i = 0; i < trips.size(); i++) {
            BoatTrip trip = trips.get(i);
            if (tripnumber == trip.getTripNumber()) {
                LocalDateTime endtime = LocalDateTime.now(); // nieuwe variabele
                trip.setEndTime(endtime);
                System.out.println(endtime);
                return;
            }
        }
        System.out.println("wrong number");

    }
}
