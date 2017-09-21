import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;

public class Weather {

    private boolean raining;
    private BigDecimal temperature = new BigDecimal(0);

    private String apiURL = "http://api.openweathermap.org/data/2.5/weather?id=6426072&APPID=7d0438aeeeb1d75e74a9825f9ae539c3&units=metric";

    public void updateWeatherData() {
        try {
            // Dit is de API request met mijn persoonlijke API key (gratis voor < 60 requests per minuut)
            URL url = new URL(apiURL);

            try (InputStream stream = url.openStream()) {
                String output = convertStreamToString(stream);

                // Converteer teruggekeerde string naar JSON
                JSONObject jsonObj = new JSONObject(output);
                JSONObject main = jsonObj.getJSONObject("main");
                JSONArray weather = jsonObj.getJSONArray("weather");
                int weatherId =  (int) weather.getJSONObject(0).get("id");

                //temperature = (double) main.get("temp");
                temperature = new BigDecimal(String.valueOf(main.get("temp")));

                // De API geeft ID codes aan het weer, code 500 t/m 599 is gereserveerd voor weersituaties met regen
                // Als het ID dus buiten 500 t/m 599 valt dan regent het niet.
                if (weatherId >= 500 && weatherId <= 599) {
                    raining = true;
                } else {
                    raining = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Geen weerinformatie beschikbaar, kijk naar buiten voor actuele weer informatie");
        }
    }

    public boolean isRaining() {
        return raining;
    }

    public double getTemperature() {
        return temperature.doubleValue();
    }

    private String convertStreamToString(java.io.InputStream is) {
        try (java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A")) {
            return s.hasNext() ? s.next() : "";
        }
    }
    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }
}
