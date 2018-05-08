package pw.a0bit.weather.openweathermap;

import lombok.Builder;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapAPIResponse {

    private MainWeatherData main;
    private List<WeatherDescription> weather;

    @Builder
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MainWeatherData {
        private double temp;
        private int pressure;
    }

    @Builder
    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WeatherDescription {
        private String main;
        private String description;
    }
}