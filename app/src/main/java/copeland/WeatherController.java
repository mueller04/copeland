package copeland;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController()
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping()
    public String getCurrentWeather(@RequestParam("lat") Optional<String> lat,
                                     @RequestParam("lon") Optional<String> lon,
                                     @RequestParam("city") Optional<String> city,
                                    @RequestParam("zip") Optional<String> zip,
                                     @RequestParam("appid") String appid) {
            return weatherService.getWeather(lat, lon, city, zip, appid);
    }
}
