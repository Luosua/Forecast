import entities.Weather;
import json.JsonReader;
import mappers.WeatherMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuliya Pedash on 27.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        String url = "https://api.darksky.net/forecast/227df50bd4b2c09545e1eaf9754c955b/50.30,30.28";
        JsonReader reader = new JsonReader(url);
        WeatherMapper weatherMapper = new WeatherMapper(reader.readJson());
        List<Weather> forecasts = weatherMapper.getForecastsWeek();
        HashMap<String, Weather> dayWeather;
        System.out.println("Week weather");
        for(Weather weather: forecasts){
            System.out.println(weather.toString());
        }
        System.out.println("Day weather");
        dayWeather = weatherMapper.getForecastsDayNight();
        for (Map.Entry entry:
                dayWeather.entrySet()){
            System.out.println(entry.getValue().toString());
        }
    }
}
