import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WeatherTest {

private Weather weather;

    //raining testen; int weatherID = 480

    @Before

    public void Initialize() {
        weather = new Weather();
    }

    @Test
    public void isRaining(){

       weather.setRaining(true);
        assertEquals(true, weather.isRaining());
    }

    @Test
    public void getTemperature(){
        weather.setTemperature(BigDecimal.valueOf(30));
        assertEquals(30, weather.getTemperature(), 0.01 );
    }

}
