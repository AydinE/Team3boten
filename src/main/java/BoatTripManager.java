import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BoatTripManager {


    // public/private/protect/niets Type naamVariable = new Type();
    private ArrayList<BoatTrip> trips = new ArrayList<>();

    private WeatherInfo weather = new WeatherInfo();


    // Start a new boattrip
    public BoatTrip createTrip(TripType tripType) {
        int identifier = trips.size() + 1;
      
        BoatTrip boatTrip ;
        if (true) { // if rivertrip has to be included yes
            boatTrip = new BoatTrip(LocalDateTime.now().plusMinutes(30), identifier, tripType);
        } else {
            boatTrip = new BoatTrip(LocalDateTime.now(), identifier, tripType);
        }
        trips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.
      
        return boatTrip;
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
                trip.setTripPrice(price);
                System.out.println( "Price of trip: € " + price);
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




