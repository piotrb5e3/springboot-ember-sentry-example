package pw.a0bit.weather.openweathermap;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pw.a0bit.weather.WeatherDataSourceKind;
import pw.a0bit.weather.WeatherResponseDTO;
import pw.a0bit.weather.WeatherSource;

@RequiredArgsConstructor
@Service
public class OpenWeatherMapWeatherSource implements WeatherSource {
    private final OpenWeatherMapClient client;

    @Override
    public WeatherDataSourceKind getWeatherDataSourceKind() {
        return WeatherDataSourceKind.OPEN_WEATHER_MAP;
    }

    @Override
    public WeatherResponseDTO getWeatherForCity(String cityName) {
        OpenWeatherMapAPIResponse response = client.getWeather(cityName);
        return WeatherResponseDTO.builder()
            .temperature(response.getMain().getTemp())
            .pressure(response.getMain().getPressure())
            .description(response.getWeather().get(0).getDescription())
            .build();
    }
}