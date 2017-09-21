import java.time.LocalDateTime;
import java.util.List;

public class BoatTripDemo {

    public static void main(String[] args){
        try {
            // Weer informatie
            Weather weather = new Weather();
            weather.updateWeatherData();

            if (weather.isRaining()) {
                System.out.println("Het regent.");
            } else {
                System.out.println("Het regent niet.");
            }

            if (weather.getTemperature() > 0) {
                System.out.println("Temperatuur: " + weather.getTemperature() + " graden celsius");
            } else {
                System.out.println("Geen weerinformatie beschikbaar.");
            }

            BoatTripManager manager = new BoatTripManager();
            for (BoatTripType type : BoatTripType.values()) {
                BoatTrip trip = manager.createTrip(type);
                LocalDateTime startTime = trip.getStartTime();
                trip.setStartTime(startTime.minusHours((int) (Math.random() * 3 + 1)).minusMinutes((int) (Math.random() * 60)));
                trip.printStartTicket();
            }

            System.out.println();
            System.out.println("Total number of active trips: " + manager.getActiveTrips().size());
            System.out.println("Total number of completed trips: " + manager.getCompletedTrips().size());

            for (int i = 0; i < 2; i++) {
                BoatTrip trip = manager.getActiveTrips().get(i + 1);
                manager.endTrip(trip.getTripNumber());
                trip.printEndTicket();
            }

            System.out.println();
            System.out.println("Total number of active trips: " + manager.getActiveTrips().size());
            System.out.println("Total number of completed trips: " + manager.getCompletedTrips().size());

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

        } catch(BoatTripException ex) {
            System.out.println("No endtime known");
        } catch(NoAvailableBoatsException ex) {
            System.out.println("No boats available");
        }


//        Code wordt later geimplementeerd
//        BoatTrip durationBoatTrip = durationOfBoatTrip;
//
//        double durationOfBoatTrip = ((durationOfBoatTrip % 3600) / 60);
//        System.out.println(durationOfBoatTrip);

    }
}
