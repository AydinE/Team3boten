import java.time.Duration;

public class BoatTripPriceCalculator {

    private Weather weather = new Weather();

    public double calculateTripPrice(BoatTrip trip) {
        double hourlyPrice = 5;
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

        return Math.round(hourlyPrice * (timeInMinutes / 60) * 100D) / 100D;
    }

    public void updateWeather() {
        weather.updateWeatherData();
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
