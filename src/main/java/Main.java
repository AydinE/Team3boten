import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime currentTime = LocalDateTime.now();
        int identifier = 1;
        BoatTrip boatTrip1 = new BoatTrip(currentTime, identifier);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy  HH:mm");
        String out = currentTime.format(formatter);
        System.out.println(out);
        // added 2 hrs and 37 minutes to get a time value
        Duration d = Duration.between(currentTime.minusHours(2).minusMinutes(37), LocalDateTime.now());
        //      System.out.println("Time of the boattrip was " + d.getSeconds() + " seconds");

        StringBuilder sb = new StringBuilder("Time of the boat trip was ");
        if (d.getSeconds() > 3600) {
            double hours = Math.floor(d.getSeconds() / 3600);
            sb.append((int) hours + " hours and "); // sb. append voegt hours toe aan string builder.
        }
        double minutes = Math.floor((d.getSeconds() % 3600) / 60);
        sb.append((int) minutes + " minutes");
        System.out.println(sb.toString());


        TripManager manager = new TripManager();

        //Maak een aantal nieuwe trips | Laat tripnumber en begintijd zien
        for (int i = 0;i < 2; i++) {

            int tripId = manager.createTrip();
            System.out.println("Tripnumber created: " + tripId);
            Thread.sleep(2000);
        }
        for (int i = 0;i < 2; i++) {

            manager.endTrip(i+1);
        }
        for (int i = 0;i < 2; i++) {

            int tripId = manager.createTrip();
            System.out.println("Tripnumber created: " + tripId);

        }
        for (int i = 2;i < 4; i++) {

            manager.endTrip(i+1);
        }
        System.out.println("Total number of trips: " + manager.getBoatTrips().size());

        //End trip laat duur van trip zien.

        //Geef overzicht van gemiddelde duur van een boattrip.
        manager.averageTripTime();
    }
}
