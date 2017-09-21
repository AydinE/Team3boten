import java.time.LocalDateTime;

public class BoatTripDemo {

    public static void main(String[] args) {
        try {
            // Weer informatie
            System.out.println("------------------ Weather information ------------------");
            System.out.println();

            Weather weather = new Weather();
            weather.updateWeatherData();

            if (weather.isRaining()) {
                System.out.println("It's raining");
            } else {
                System.out.println("It's not raining");
            }

            if (weather.getTemperature() > 0) {
                System.out.println("Temperature: " + weather.getTemperature() + "°C");
            } else {
                System.out.println("No weather information available.");
            }

            System.out.println();
            System.out.println("-------------------- Starting trips ---------------------");

            BoatTripManager manager = new BoatTripManager();

            BoatTrip trip = manager.createTrip(BoatTripType.RIVER_TRIP);
            LocalDateTime startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours(1).minusMinutes(40));
            trip.printStartTicket();

            trip = manager.createTrip(BoatTripType.LAKE_TRIP);
            startTime = trip.getStartTime();
            trip.setStartTime(startTime.minusHours(3).minusMinutes(20));
            trip.printStartTicket();

            System.out.println();
            System.out.println("Total number of active trips: " + manager.getActiveTrips().size());
            System.out.println("Total number of completed trips: " + manager.getCompletedTrips().size());

            System.out.println();
            System.out.println("--------------------- Ending trips ----------------------");

            for (int i = 0; i < 2; i++) {
                trip = manager.getActiveTrips().get(i + 1);
                manager.endTrip(trip.getTripNumber());
                trip.printEndTicket();
                System.out.println();
            }

            System.out.println("Total number of active trips: " + manager.getActiveTrips().size());
            System.out.println("Total number of completed trips: " + manager.getCompletedTrips().size());

            StringBuilder sb = new StringBuilder("Average trip time: ");
            long averageDurationInSeconds = manager.averageTripTime();
            if (averageDurationInSeconds > 3600) {
                double hours = Math.floor(averageDurationInSeconds / 3600);
                sb.append((int) hours + " hours and "); // sb. append voegt hours toe aan string builder.
            }
            double minutes = Math.floor((averageDurationInSeconds % 3600) / 60);
            sb.append((int) minutes + " minutes");
            System.out.println();
            System.out.println(sb.toString());
            System.out.println();
            System.out.println("---------------------------------------------------------");

        } catch (BoatTripException ex) {
            System.out.println("No endtime known");
        } catch (NoAvailableBoatsException ex) {
            System.out.println("No boats available");
        }


//        Code wordt later geimplementeerd
//        BoatTrip durationBoatTrip = durationOfBoatTrip;
//
//        double durationOfBoatTrip = ((durationOfBoatTrip % 3600) / 60);
//        System.out.println(durationOfBoatTrip);

    }
}
