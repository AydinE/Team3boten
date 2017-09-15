import java.time.Duration;

public class BoatTripPriceCalculator {

    public double calculateTripPrice(BoatTrip trip) {
        double hourlyPrice = 5;

        WeatherInfo weather = new WeatherInfo();
        weather.GetWeatherInfo();

        double temperature = weather.getTemperature();
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
        double timeInMinutes = ((double) duration.getSeconds()) / 60;


        double totalPrice = hourlyPrice * (timeInMinutes / 60);
        return totalPrice;

    }

}
