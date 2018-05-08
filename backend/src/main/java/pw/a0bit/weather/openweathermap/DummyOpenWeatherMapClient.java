package pw.a0bit.weather.openweathermap;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
class DummyOpenWeatherMapClient implements OpenWeatherMapClient {
    public OpenWeatherMapAPIResponse getWeather(String cityName){
        return OpenWeatherMapAPIResponse.builder()
        .main(OpenWeatherMapAPIResponse.MainWeatherData.builder()
                .pressure(1012)
                .temp(280.31)
                .build())
        .weather(
            Arrays.asList(
                OpenWeatherMapAPIResponse.WeatherDescription.builder()
                .description("Sunny")
                .build()))
        .build();
    }
}