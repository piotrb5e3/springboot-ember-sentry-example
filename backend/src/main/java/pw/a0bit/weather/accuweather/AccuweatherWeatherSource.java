package pw.a0bit.weather.accuweather;

import org.springframework.stereotype.Service;

import pw.a0bit.weather.WeatherDataSourceKind;
import pw.a0bit.weather.WeatherResponseDTO;
import pw.a0bit.weather.WeatherSource;

@Service
public class AccuweatherWeatherSource implements WeatherSource {

    @Override
    public WeatherDataSourceKind getWeatherDataSourceKind() {
        return WeatherDataSourceKind.ACCUWEATHER;
    }

    @Override
    public WeatherResponseDTO getWeatherForCity(String cityName) {
        throw new RuntimeException("Not implemented yet");
    }
}