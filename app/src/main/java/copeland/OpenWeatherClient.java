package copeland;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

@Component
public class OpenWeatherClient {

    public static final String ONECALL_PATH = "/data/3.0/onecall";
    public static final String WEATHER_PATH = "/data/2.5/weather";
    public static final String BASE_URL = "https://api.openweathermap.org";
    private final WebClient webClientBuilder;

    public OpenWeatherClient() {
        webClientBuilder = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public String getWeatherByLatLon(String lat, String lon, String appid) {

        Function<UriBuilder, URI> uriBuilderFunction = uriBuilder -> uriBuilder
                .path(ONECALL_PATH)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .queryParam("appid", appid)
                .build();

        return triggerClientRequest(uriBuilderFunction);
    }

    public String getWeatherByCity(String city, String appid) {

        Function<UriBuilder, URI> uriBuilderFunction = uriBuilder -> uriBuilder
                .path(WEATHER_PATH)
                .queryParam("q", city)
                .queryParam("appid", appid)
                .build();

        return triggerClientRequest(uriBuilderFunction);
    }

    public String getWeatherByZipCode(String zip, String appid) {

        Function<UriBuilder, URI> uriBuilderFunction = uriBuilder -> uriBuilder
                .path(WEATHER_PATH)
                .queryParam("zip", zip)
                .queryParam("appid", appid)
                .build();

        return triggerClientRequest(uriBuilderFunction);
    }

    private String triggerClientRequest(Function<UriBuilder, URI> uriBuilderURIFunction) {
        return webClientBuilder
                .get()
                .uri(uriBuilderURIFunction)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
