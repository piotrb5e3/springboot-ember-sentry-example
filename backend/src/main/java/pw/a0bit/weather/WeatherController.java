package pw.a0bit.weather;

import com.google.common.collect.ImmutableMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.sentry.Sentry;
import io.sentry.event.BreadcrumbBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class WeatherController {

    private final WeatherSourceProvider weatherSourceProvider;

    @GetMapping("/api/getWeather")
    public WeatherResponseDTO getWeather(
            @RequestParam(name = "cityName") String cityName,
            @RequestParam (name = "dataSourceCode") String dataSourceCode) {

        Sentry.getContext().recordBreadcrumb(
            new BreadcrumbBuilder()
                .setMessage("User requests weather")
                .setData(ImmutableMap.of(
                    "city name", cityName,
                    "data source code", dataSourceCode))
                .setCategory("weather")
                .build());

        WeatherSource weatherSource = getWeatherSource(dataSourceCode);
        return weatherSource.getWeatherForCity(cityName);
    }

    private WeatherSource getWeatherSource(String dataSourceCode){
        WeatherDataSourceKind kind = WeatherDataSourceKind.getByCode(dataSourceCode);
        return weatherSourceProvider.getWeatherSourceForKind(kind);
    }
}