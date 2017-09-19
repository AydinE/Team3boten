import java.io.IOException;
import java.time.LocalDateTime;

public class BoatTripDemo {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Weer informatie
        Weather weather = new Weather();
        weather.updateWeatherData();

        if (weather.isRaining()) {
            System.out.println("Het regent.");
        } else {
            System.out.println("Het regent niet.");
        }
        System.out.println();

        if (weather.getTemperature() > 0) {
            System.out.println("Temperatuur: " + weather.getTemperature() + " graden celsius");
        } else {
            System.out.println("Geen weerinformatie beschikbaar.");
        }

        LocalDateTime currentTime = LocalDateTime.now();

        BoatTripManager manager = new BoatTripManager();

        //Maak een aantal nieuwe trips | Laat tripnumber en begintijd zien
        for (int i = 0; i < 2; i++) {

            BoatTrip trip = manager.createTrip(BoatTripType.RIVER_TRIP);
            LocalDateTime startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours((int) (Math.random() * 3)).minusMinutes((int) (Math.random() * 60)));
            trip.printTicket();
    }
        System.out.println();
        for (int i = 0; i < 2; i++) {

            manager.endTrip(i + 1);
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {

            BoatTrip trip = manager.createTrip(BoatTripType.LAKE_TRIP);
            LocalDateTime startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours((int) (Math.random() * 3)).minusMinutes((int) (Math.random() * 60)));
            trip.printTicket();

        }
        System.out.println();
        for (int i = 2; i < 4; i++) {

            manager.endTrip(i + 1);
        }
        System.out.println();
        System.out.println("Total number of trips: " + manager.getCompletedTrips().size());

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


//        Code wordt later geimplementeerd
//        BoatTrip durationBoatTrip = durationOfBoatTrip;
//
//        double durationOfBoatTrip = ((durationOfBoatTrip % 3600) / 60);
//        System.out.println(durationOfBoatTrip);

    }
}
