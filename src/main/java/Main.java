import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        LocalDateTime currentTime = LocalDateTime.now();
        int identifier = 1;
        BoatTrip boatTrip1 = new BoatTrip(currentTime, identifier);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy  HH:mm");
        String out = currentTime.format(formatter);
        System.out.println(out);
        Thread.sleep(5000);
        Duration d = Duration.between(currentTime.minusHours(1), LocalDateTime.now());
        System.out.println("Time of the boattrip was " + d.getSeconds() + " seconds");

        if (d.getSeconds() > 3600) {
           double uren = Math.floor(d.getSeconds()/3600);
           double minuten = Math.floor((d.getSeconds()%3600)/60);
           System.out.println("Time of the boattrip was " + uren + " uur en " + minuten + " minuten");
        }


        TripManager manager = new TripManager();

        //Maak een aantal nieuwe trips | Laat tripnumber en begintijd zien
        for (int i = 0; i < 10; i++) {

            int tripId = manager.createTrip();
            System.out.println("Trip aangemaakt met: " + tripId);

        }

        System.out.println("Totaal aantal boottochten: " + manager.getBoatTrips().size());

        //End trip laat duur van trip zien.

        //Geef overzicht van gemiddelde duur van een boattrip.

    }
}
