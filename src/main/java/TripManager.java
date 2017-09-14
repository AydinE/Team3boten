import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TripManager {

    private List<BoatTrip> trips = new ArrayList<>();

    // Start a new boattrip
    public int createTrip() {

        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return identifier;
    }

    // End a boattrip
    public void endTrip(int tripNumber) {
        for (int i = 0; i < trips.size(); i++) {
            BoatTrip trip = trips.get(i);
            if (tripNumber == trip.getTripNumber()) {
                LocalDateTime endtime = LocalDateTime.now(); // nieuwe variabele
                trip.setEndTime(endtime);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
                System.out.println("Trip "+ tripNumber + " ended at: " + endtime.format(formatter));
                return;
            }
        }
        System.out.println("wrong number");
    }

    // Return list of trips
    public List<BoatTrip> getBoatTrips() {

        return trips;

    }

    public double calculateTripPrice() {
        double basePrice = 5;
        
    }

//    //Average trip time
//    public void averageTripTime() {
//
//        Duration totalTime = Duration.ZERO;
//
//        for (int i = 0; i < trips.size(); i++) {
//            BoatTrip trip = trips.get(i);
//            if (trip.getEndTime(). != null) {
//                Duration d = Duration.between(trip.getStartTime(), trip.getEndTime());
//                System.out.println("Duration was: " + d);
//                totalTime.plus(d);
//
//            }
//
//        }
//        System.out.println(totalTime);

}
