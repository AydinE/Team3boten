

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class WeatherInfo {

    public void GetWeatherInfo() throws IOException {

        try {
            // Dit is de API request met mijn persoonlijke API key (gratis voor < 60 requests per minuut)
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?id=6426072&APPID=7d0438aeeeb1d75e74a9825f9ae539c3&units=metric");
            InputStream stream = url.openStream();

            String output = convertStreamToString(stream);

            // Om te zien hoe de complete output eruit ziet uncomment onderstaande regel.
            //System.out.println(output);

            // Converteer teruggekeerde string naar JSON
            JSONObject jsonObj = new JSONObject(output.toString());
            JSONObject main = jsonObj.getJSONObject("main");
            JSONArray weather = jsonObj.getJSONArray("weather");
            int weatherId = (int) weather.getJSONObject(0).get("id");

            System.out.println("Huidige temperatuur is: " + main.get("temp") + " graden celsius");

            // De API geeft ID codes aan het weer, code 500 t/m 599 is gereserveerd voor weersituaties met regen
            // Als het ID dus buiten 500 t/m 599 valt dan regent het niet.
            if (weatherId >= 500 && weatherId <= 599) {
                System.out.println("Het regent");
            } else {
                System.out.println("Geen regen");
            }
        } catch (IOException e) {

            System.out.println("Geen weerinformatie beschikbaar, kijk naar buiten voor actuele weer informatie");

        }

    }

    static String convertStreamToString(java.io.InputStream is) {

        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";

    }

}
