package copeland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private OpenWeatherClient openWeatherClient;

    public String getWeather(Optional<String> lat, Optional<String> lon, Optional<String> city, Optional<String> zip, String appid) {
        if (lat.isPresent() && !lat.get().isEmpty() && lon.isPresent() && !lon.get().isEmpty()) {
            return openWeatherClient.getWeatherByLatLon(lat.get(), lon.get(), appid);
        } else if (city.isPresent() && !city.get().isEmpty()) {
            return openWeatherClient.getWeatherByCity(city.get(), appid);
        } else if (zip.isPresent() && !zip.get().isEmpty()) {
            return openWeatherClient.getWeatherByZipCode(zip.get(), appid);
        }
        throw new IncorrectlyFormattedRequestException();
    }
}
