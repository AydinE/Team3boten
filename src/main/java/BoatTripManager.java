import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BoatTripManager {

    private List<Boat> availableBoats = new ArrayList<>();
    private List<Boat> boatsOnTrip = new ArrayList<>();

    private ArrayList<BoatTrip> currentTrips = new ArrayList<>();
    private ArrayList<BoatTrip> pastTrips = new ArrayList<>();

    public BoatTripManager(){

        availableBoats.add(new Boat(1));
        availableBoats.add(new Boat(2));
        availableBoats.add(new Boat(3));
        availableBoats.add(new Boat(5));
        availableBoats.add(new Boat(6));
        availableBoats.add(new Boat(7));
        availableBoats.add(new Boat(8));
        availableBoats.add(new Boat(9));
        availableBoats.add(new Boat(10));
        availableBoats.add(new Boat(12));

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
        boatsOnTrip.add(boat);
        boatTrip.start();
        currentTrips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return boatTrip;
    }

    // End a boattrip
    public boolean endTrip(int tripNumber) throws BoatTripException {
        for (int i = 0; i < currentTrips.size(); i++) {
            BoatTrip trip = currentTrips.get(i);
            if (tripNumber == trip.getTripNumber()) {
                trip.stop();
                for (int j = 0; j < boatsOnTrip.size(); i++){
                    if (boatsOnTrip.get(0).getBoatNumber() == trip.getBoatNumber()){
                        Boat boat = boatsOnTrip.get(j);
                        boatsOnTrip.remove(boat);
                        availableBoats.add(boat);
                        Duration timeSinceLastInspection = boat.getTimeSinceLastInspection().plus(trip.getDuration());
                        if (timeSinceLastInspection.getSeconds() > 10800) {
                            // Inspectie nodig
                            System.out.println("Inspectie nodig op bootNr: " + boat.getBoatNumber());
                        }
                    }
                }
                currentTrips.remove(trip);
                pastTrips.add(trip);
                //availableBoats.add(trip.getBoatNumber());
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




