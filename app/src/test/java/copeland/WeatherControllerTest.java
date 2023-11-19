package copeland;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherControllerTest {

    @Mock
    WeatherService weatherService;

    @InjectMocks
    WeatherController subject;

    @Test
    void testGetCurrentWeather() {
        Optional<String> lat = Optional.of("10");
        Optional<String> lon = Optional.of("20");
        Optional<String> city = Optional.of("Columbus");
        Optional<String> zip = Optional.of("43212");
        String appid = "secretKey";
        when(weatherService.getWeather(lat, lon, city, zip, appid)).thenReturn("expectedResult");


        String result = subject.getCurrentWeather(lat,
                lon,
                city,
                zip,
                appid);

        assertEquals("expectedResult", result);
    }

}