package pw.a0bit.weather;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WeatherSourceProvider {

    private final WeatherSource[] weatherSources;

    public WeatherSource getWeatherSourceForKind(WeatherDataSourceKind kind) {
        return Arrays.stream(weatherSources)
            .filter(ws -> ws.getWeatherDataSourceKind().equals(kind))
            .findFirst()
            .orElse(null);
    }
}