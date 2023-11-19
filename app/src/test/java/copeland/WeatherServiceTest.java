package copeland;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    OpenWeatherClient openWeatherClient;

    @InjectMocks
    WeatherService subject;

    @Test
    void getWeatherByLatlon() {
        Optional<String> lat = Optional.of("10");
        Optional<String> lon = Optional.of("20");
        Optional<String> city = Optional.of("Columbus");
        Optional<String> zip = Optional.of("43212");
        String appid = "secretKey";

        when(openWeatherClient.getWeatherByLatLon(lat.get(), lon.get(), appid)).thenReturn("expectedResult");

        String result = subject.getWeather(lat, lon, city, zip, appid);

        assertEquals("expectedResult", result);
    }

    @Test
    void getWeatherByCity() {
        Optional<String> lat = Optional.of("10");
        Optional<String> lon = Optional.empty();
        Optional<String> city = Optional.of("Columbus");
        Optional<String> zip = Optional.of("43212");
        String appid = "secretKey";

        when(openWeatherClient.getWeatherByCity(city.get(), appid)).thenReturn("expectedResult");

        String result = subject.getWeather(lat, lon, city, zip, appid);

        assertEquals("expectedResult", result);
    }

    @Test
    void getWeatherByZip() {
        Optional<String> lat = Optional.of("10");
        Optional<String> lon = Optional.empty();
        Optional<String> city = Optional.empty();
        Optional<String> zip = Optional.of("43212");
        String appid = "secretKey";

        when(openWeatherClient.getWeatherByZipCode(zip.get(), appid)).thenReturn("expectedResult");

        String result = subject.getWeather(lat, lon, city, zip, appid);

        assertEquals("expectedResult", result);
    }

    @Test
    void getIncorrectlyFormattedRequest() {
        Optional<String> lat = Optional.of("10");
        Optional<String> lon = Optional.empty();
        Optional<String> city = Optional.empty();
        Optional<String> zip = Optional.empty();
        String appid = "secretKey";

        assertThrows(IncorrectlyFormattedRequestException.class, ()-> subject.getWeather(lat, lon, city, zip, appid));
    }
}
