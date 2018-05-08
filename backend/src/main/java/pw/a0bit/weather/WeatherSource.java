package pw.a0bit.weather;

public interface WeatherSource {
    public WeatherDataSourceKind getWeatherDataSourceKind();
    
    public WeatherResponseDTO getWeatherForCity(String cityName);
}