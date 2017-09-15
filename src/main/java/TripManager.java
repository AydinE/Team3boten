
import java.time.Duration;
import java.time.LocalDateTime; // Dit zijn imports uit JAVA om te gebruiken. (localdatetime,arraylist,list)
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TripManager {


    // public/private/protect/niets Type naamVariable = new Type();
    private ArrayList<BoatTrip> trips = new ArrayList<>();

    private WeatherInfo weather = new WeatherInfo();


    // Start a new boattrip
    public int createTrip() {

        int identifier = trips.size() + 1;
        BoatTrip boatTrip = new BoatTrip(LocalDateTime.now(), identifier);
        trips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.

        return identifier;
    }

    // End a boattrip
    public boolean endTrip(int tripNumber) {
        for (int i = 0; i < trips.size(); i++) {
            BoatTrip trip = trips.get(i);
            if (tripNumber == trip.getTripNumber()) {
                LocalDateTime endtime = LocalDateTime.now(); // nieuwe variabele
                trip.setEndTime(endtime);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm");
                System.out.println("Trip "+ tripNumber + " ended at: " + endtime.format(formatter));
                BoatTripPriceCalculator calculator = new BoatTripPriceCalculator();
                weather.updateWeatherData();
                double price = calculator.calculateTripPrice(trip, weather);
                System.out.println( "€ " + price);
                return true;
            }
        }
        System.out.println("wrong number");
        return false;
    }

    // Return list of trips
    public List<BoatTrip> getBoatTrips() {

        return trips;
    }

    public WeatherInfo getWeather() {
        return weather;
    }

    //Average trip time
    public long averageTripTime() {

        int completedTrips = 0;
        Duration totalTime = Duration.ZERO;

        if (trips.size() > 0) {
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

        } else {

            return 0;

        }



    }
}




