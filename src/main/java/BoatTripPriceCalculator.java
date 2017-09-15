import java.time.Duration;

public class BoatTripPriceCalculator {

    public double calculateTripPrice(BoatTrip trip, WeatherInfo weatherInfo) {
        double hourlyPrice = 5;
        double temperature = weatherInfo.getTemperature();
        boolean isRaining = weatherInfo.isRaining();

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
        double timeInMinutes = ((double) duration.getSeconds()) / 60;

        return Math.round(hourlyPrice * (timeInMinutes / 60) * 100D) / 100D;
    }

}
