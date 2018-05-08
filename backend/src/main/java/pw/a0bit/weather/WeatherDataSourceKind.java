package pw.a0bit.weather;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum WeatherDataSourceKind {
    OPEN_WEATHER_MAP ("OWM"),
    ACCUWEATHER("ACCW"),
    WEATHERBUG("WB");

    private final String code;

    static WeatherDataSourceKind getByCode(String code) {
        return Arrays.stream(WeatherDataSourceKind.values())
            .filter(s -> s.getCode().equals(code))
            .findFirst()
            .orElse(null);
    }
}
