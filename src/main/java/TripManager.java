
import java.time.Duration;
import java.time.LocalDateTime; // Dit zijn imports uit JAVA om te gebruiken. (localdatetime,arraylist,list)
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; // implementatie
import java.util.List;  // aangeven dat je een list wilt

public class TripManager {

    // public/private/protect/niets Type naamVariable = new Type();
    private ArrayList<BoatTrip> trips = new ArrayList<BoatTrip>();

    // Start a new boattrip
    public int createTrip() {

        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier); // BoatTrip is het TYPE en boatrip is naam van een variabele
        trips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return identifier;
    }

    // End a boattrip
    public boolean endTrip(int tripnumber) {
        for (int i = 0; i < trips.size(); i++) {
            BoatTrip trip = trips.get(i);
            if (tripnumber == trip.getTripNumber()) {
                LocalDateTime endtime = LocalDateTime.now(); // nieuwe variabele
                trip.setEndTime(endtime);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy  HH:mm");
                String out = endtime.format(formatter);
                System.out.println("Trip " + tripnumber + " ended at: " + out);
                return true;
            }
        }
        System.out.println("wrong number");
        return false;
    }

    public List<BoatTrip> getBoatTrips() {
        return trips;
    }

    //Average trip time
    public long averageTripTime() throws InterruptedException {

        int completedTrips = 0;
        Duration totalTime = Duration.ZERO;

        for (int i = 0; i < trips.size(); i++) {
            BoatTrip trip = trips.get(i);
            if (trip.getEndTime() != null) {
                Duration d = Duration.between(trip.getStartTime(), trip.getEndTime());
                System.out.println("Duration was: " + d);
                totalTime = totalTime.plus(d); // Hij slaat het hem nu op in variabele totalTime.
                completedTrips = completedTrips + 1;
            }

        }
        System.out.println("Averagetime " + totalTime.getSeconds() / completedTrips); /* de get.Seconds is een LONG
        value en kan daarom mee gerekend worden in combinatie met INT */

        return totalTime.getSeconds() / completedTrips;


    }
}




