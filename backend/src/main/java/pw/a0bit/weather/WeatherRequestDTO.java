package pw.a0bit.weather;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class WeatherRequestDTO {
    private String cityName;
    private String dataSourceCode;
}