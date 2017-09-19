import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BoatTripManager {

    private List<Integer> availableBoats = new ArrayList<>();

    private ArrayList<BoatTrip> currentTrips = new ArrayList<>();
    private ArrayList<BoatTrip> pastTrips = new ArrayList<>();

    public BoatTripManager(){

        availableBoats.add(1);
        availableBoats.add(2);
        availableBoats.add(3);
        availableBoats.add(5);
        availableBoats.add(6);
        availableBoats.add(7);
        availableBoats.add(8);
        availableBoats.add(9);
        availableBoats.add(10);
        availableBoats.add(12);

    }

    // Start a new boattrip
    public BoatTrip createTrip(BoatTripType tripType) {
        //Check to see if there are available boats
        if (availableBoats.isEmpty()) {
            // TODO: Exception
            System.out.println("No available trips");
            return null;
        }

        int identifier = currentTrips.size() + pastTrips.size() + 1;
      
        BoatTrip boatTrip = new BoatTrip(identifier, tripType, availableBoats.get(0));
        boatTrip.start();
        availableBoats.remove(0);
        currentTrips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return boatTrip;
    }

    // End a boattrip
    public boolean endTrip(int tripNumber) {
        for (int i = 0; i < currentTrips.size(); i++) {
            BoatTrip trip = currentTrips.get(i);
            if (tripNumber == trip.getTripNumber()) {
                trip.stop();
                currentTrips.remove(trip);
                pastTrips.add(trip);
                availableBoats.add(trip.getBoatNumber());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
                System.out.println("Trip "+ tripNumber + " ended at: " + trip.getEndTime().format(formatter));
                return true;
            }
        }
        System.out.println("wrong number");
        return false;
    }

    public List<BoatTrip> getActiveTrips() {
        return currentTrips;
    }

    // Return list of trips
    public List<BoatTrip> getCompletedTrips() {
        return pastTrips;
    }

    //Average trip time
    public long averageTripTime() {

        int completedTrips = 0;
        Duration totalTime = Duration.ZERO;

        if (pastTrips.size() > 0) {
            for (int i = 0; i < pastTrips.size(); i++) {
                BoatTrip trip = pastTrips.get(i);
                if (trip.getEndTime() != null) {
                    Duration d = Duration.between(trip.getStartTime(), trip.getEndTime());
                    totalTime = totalTime.plus(d); // Hij slaat het hem nu op in variabele totalTime.
                    completedTrips = completedTrips + 1;
                }

            }
            return totalTime.getSeconds() / completedTrips;
        } else {
            return 0;
        }
    }

}




