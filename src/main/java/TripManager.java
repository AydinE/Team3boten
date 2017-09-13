
import java.time.LocalDateTime; // Dit zijn imports uit JAVA om te gebruiken. (localdatetime,arraylist,list)
import java.util.ArrayList; // implementatie
import java.util.List;  // aangeven dat je een list wilt

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();

    // Start a new boattrip
    public int createTrip() {

        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip);

        return identifier;
    }
    // End a boattrip
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

    public List<BoatTrip> getBoatTrips() {
        return trips;
    }

}
