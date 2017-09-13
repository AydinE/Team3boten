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

//    public static void endTrip(int tripnumber, List<Boat> boatlist) {
//        for (int i = 0; i < boatlist.size(); i++) {
//            if (tripnumber == getTripNumber) {
//                // Op plaats Boattrip moet de verwijzing naar tripnumberclass komen
//                LocalDateTime endtime;
//                //
//            } else {
//
//                System.out.println('wrong number']);
//            }
//        }
//        System.out.println(endtime, enddate);
//    }

}
