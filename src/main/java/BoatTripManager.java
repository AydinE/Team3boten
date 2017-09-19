import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BoatTripManager {

    List<Integer> availableBoats = new ArrayList<>();

    private ArrayList<BoatTrip> currentTrips = new ArrayList<>();
    private ArrayList<BoatTrip> pastTrips = new ArrayList<>();

    private int totalTrips = 0;

    private WeatherInfo weather = new WeatherInfo();

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
    public BoatTrip createTrip(BoatTripType tripType) throws Exception {

        //Check to see if there are available boats
        if (availableBoats.isEmpty()) {
            throw new Exception();
        }

        int identifier = totalTrips + 1;
      
        BoatTrip boatTrip;
        if (tripType == BoatTripType.RIVER_TRIP){
            boatTrip = new BoatTrip(LocalDateTime.now().plusMinutes(30), identifier, tripType, availableBoats.get(0));
        } else {
            boatTrip = new BoatTrip(LocalDateTime.now(), identifier, tripType, availableBoats.get(0));
        }
        availableBoats.remove(0);
        currentTrips.add(boatTrip); // variabele wordt toegevoegd in het lijstje voor trips. Zo alle trips centraal op 1 plaats.
      
        return boatTrip;
    }

    // End a boattrip
    public boolean endTrip(int tripNumber) {
        for (int i = 0; i < currentTrips.size(); i++) {
            BoatTrip trip = currentTrips.get(i);
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
                currentTrips.remove(trip);
                pastTrips.add(trip);
                availableBoats.add(trip.getBoatNumber());
                return true;
            }
        }
        System.out.println("wrong number");
        return false;
    }

    // Return list of trips
    public List<BoatTrip> getBoatTrips() {

        return pastTrips;
    }

    public WeatherInfo getWeather() {
        return weather;
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




