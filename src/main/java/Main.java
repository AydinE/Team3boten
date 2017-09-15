import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        Random rand = new Random();

        // Weer informatie
        WeatherInfo weather = new WeatherInfo();
        weather.GetWeatherInfo();

        LocalDateTime currentTime = LocalDateTime.now();

        TripManager manager = new TripManager();

        //Maak een aantal nieuwe trips | Laat tripnumber en begintijd zien
        for (int i = 0; i < 2; i++) {

            int tripId = manager.createTrip();
            BoatTrip trip = manager.getBoatTrips().get(tripId - 1);
            LocalDateTime startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours((int) (Math.random() * 3)).minusMinutes((int) (Math.random() * 60)));
            System.out.println("Trip number created: " + tripId);
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {

            manager.endTrip(i + 1);
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {

            int tripId = manager.createTrip();
            BoatTrip trip = manager.getBoatTrips().get(tripId - 1);
            LocalDateTime startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours((int) (Math.random() * 3)).minusMinutes((int) (Math.random() * 60)));
            System.out.println("Trip number created: " + tripId);

        }
        System.out.println();
        for (int i = 2; i < 4; i++) {

            manager.endTrip(i + 1);
        }
        System.out.println();
        System.out.println("Total number of trips: " + manager.getBoatTrips().size());

        //End trip laat duur van trip zien.

        //Geef overzicht van gemiddelde duur van een boattrip.
        System.out.println();

        StringBuilder sb = new StringBuilder("Average trip time: ");
        long averageDurationInSeconds = manager.averageTripTime();
        if (averageDurationInSeconds > 3600) {
            double hours = Math.floor(averageDurationInSeconds / 3600);
            sb.append((int) hours + " hours and "); // sb. append voegt hours toe aan string builder.
        }
        double minutes = Math.floor((averageDurationInSeconds % 3600) / 60);
        sb.append((int) minutes + " minutes");
        System.out.println(sb.toString());
        System.out.println();
    }
}
