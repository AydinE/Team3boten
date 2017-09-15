import java.time.Duration;

public class BoatTripPriceCalculator {

    public double calculateTripPrice(BoatTrip trip, Weather weather) {
        double hourlyPrice = 5;

        int temperature = weather.getTemprature();
        boolean isRaining = weather.isRaining();

        if( isRaining ){
            hourlyPrice = hourlyPrice - 1;
        }
        if(temperature > 18){
            if(temperature > 25){
                hourlyPrice = hourlyPrice + 3;
            } else {
                hourlyPrice = hourlyPrice + 2;
            }
        }

        Duration duration = Duration.between(trip.getStartTime(), trip.getEndTime());

    }

}
