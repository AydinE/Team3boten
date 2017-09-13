import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

//        LocalDateTime currentTime = LocalDateTime.now();
//        int identifier = 1;
//        BoatTrip boatTrip1 = new BoatTrip(currentTime, identifier);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MM yyyy  HH:mm");
//        String out = currentTime.format(formatter);
//        System.out.println(out);

        TripManager manager = new TripManager();

        //Maak een aantal nieuwe trips | Laat tripnumber en begintijd zien
        for (int i = 0; i < 10; i++) {

            int tripId = manager.createTrip();
            System.out.println("Trip aangemaakt met: " + tripId);

        }

        System.out.println("Aantal actieve boottochten: " + manager.getBoatTrips().size());

        //End trip laat duur van trip zien.

        //Geef overzicht van gemiddelde duur van een boattrip.

    }
}
