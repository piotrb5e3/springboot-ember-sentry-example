package pw.a0bit.weather.openweathermap;

public interface OpenWeatherMapClient {
    public OpenWeatherMapAPIResponse getWeather(String cityName);
}