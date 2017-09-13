package main.java;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TripManager {

    int tripnumber = 0;
    LocalDateTime endtime;
    LocalDate enddate;

    public TripManager(int tripnumber, LocalDateTime endtime, LocalDate enddate) {
        this.tripnumber = tripnumber;
        this.endtime = endtime;
        this.enddate = enddate;
    }

//    public void endTrip(int tripnumber, List<BoatTrip> boatlist) {
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
