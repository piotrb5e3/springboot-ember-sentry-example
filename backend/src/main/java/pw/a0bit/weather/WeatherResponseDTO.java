package pw.a0bit.weather;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class WeatherResponseDTO {
    private final double temperature; 
    private final String description;
    private final int pressure;
}