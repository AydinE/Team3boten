import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<BoatTrip>();
//    private int tripnumber = 0;
//    private LocalDateTime endDate;
//
//    public TripManager(int tripnumber, LocalDateTime endDate) {
//        this.tripnumber = tripnumber;
//        this.endDate = endDate;
//    }

    // Start a new boattrip
    public int createTrip() {

        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip);

        return identifier;

    }

    // End an existing boattrip
    public void endTrip() {



    }

    // Return list of trips
    public List<BoatTrip> getBoatTrips () {

        return trips;

    }

//    public static void endTrip(int tripnumber, List<Boat> boatlist) {
//        for (int i = 0; i < boatlist.size(); i++) {
//            if (tripnumber == //) {
//                // Op plaats Boattrip moet de verwijzing naar tripnumberclass komen
//                LocalDateTime endtime;
//                LocalDate enddate;
//
//            } else {
//
//                System.out.println('wrong number']);
//            }
//        }
//        System.out.println(endtime, enddate);
//    }

}
