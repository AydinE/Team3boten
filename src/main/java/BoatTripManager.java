import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BoatTripManager {

    private HashMap<Integer, Boat> availableBoats = new HashMap<>();
    private HashMap<Integer, Boat> boatsOnTrip = new HashMap<>();

    private HashMap<Integer, BoatTrip> currentTrips = new HashMap<>();
    private HashMap<Integer, BoatTrip> pastTrips = new HashMap<>();

    public BoatTripManager(){

        availableBoats.put(1, new Boat(1));
        availableBoats.put(2, new Boat(2));
        availableBoats.put(3, new Boat(3));
        availableBoats.put(5, new Boat(5));
        availableBoats.put(6, new Boat(6));
        availableBoats.put(7, new Boat(7));
        availableBoats.put(8, new Boat(8));
        availableBoats.put(9, new Boat(9));
        availableBoats.put(10, new Boat(10));
        availableBoats.put(12, new Boat(12));

    }

    // Start a new boattrip
    public BoatTrip createTrip(BoatTripType tripType) throws NoAvailableBoatsException {
        //Check to see if there are available boats
        if (availableBoats.isEmpty()) {
            throw new NoAvailableBoatsException("No available boats");
        }
      
        BoatTrip boatTrip = new BoatTrip((currentTrips.size() + pastTrips.size() + 1), tripType, availableBoats.get(0).getBoatNumber());
        Boat boat = availableBoats.get(0);
        availableBoats.remove(boat);
        boatsOnTrip.put(boat.getBoatNumber(),boat);
        boatTrip.start();
        currentTrips.put(boatTrip.getTripNumber(), boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return boatTrip;
    }

    // End a boattrip
    public void endTrip(int tripNumber) throws BoatTripException {

        // If there is no trip with the given tripnumber throw exception.
        if (currentTrips.get(tripNumber) == null) throw new BoatTripException();

        BoatTrip trip = currentTrips.get(tripNumber);
        Boat boat = boatsOnTrip.get(trip.getBoatNumber());
        trip.stop(boat);
        boatsOnTrip.remove(boat);
        availableBoats.put(trip.getBoatNumber(), boat);
        currentTrips.remove(trip);
        pastTrips.put(tripNumber, trip);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
        System.out.println("Trip "+ tripNumber + " ended at: " + trip.getEndTime().format(formatter));

    }

    public HashMap<Integer, BoatTrip> getActiveTrips() {
        return currentTrips;
    }

    // Return list of trips
    public HashMap<Integer, BoatTrip> getCompletedTrips() {
        return pastTrips;
    }

    //Average trip time
    public long averageTripTime()throws BoatTripException {

        int completedTrips = 0;
        Duration totalTime = Duration.ZERO;

        if (pastTrips.size() > 0) {
            for (int i = 0; i < pastTrips.size(); i++) {
                BoatTrip trip = pastTrips.get(i);
                if (trip.getEndTime() != null) {
                    totalTime = totalTime.plus(trip.getDuration()); // Hij slaat het hem nu op in variabele totalTime.
                    completedTrips = completedTrips + 1;
                }

            }
            return totalTime.getSeconds() / completedTrips;
        } else {
            return 0;
        }
    }

}




