package mappers;

import entities.Weather;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Yuliya Pedash on 27.02.2017.
 */
public class WeatherMapper {
    JSONObject jsonObject;

    public WeatherMapper(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public List<Weather> getForecastsWeek(){
        final String TYPE = "daily";
        return getForecasts(TYPE);
    }
    public HashMap<String, Weather> getForecastsDayNight(){
        final String TYPE = "hourly";
        final String DATA = "data";
        String day = "day";
        String night="night";
        HashMap<String, Weather> forecasts = new HashMap<>();
        JSONObject obj = jsonObject.getJSONObject(TYPE);
        JSONArray jsnForecasts = obj.getJSONArray(DATA);
        forecasts.put(day, getForecastDay(jsnForecasts.getJSONObject(11), TYPE));
        forecasts.put(night, getForecastDay(jsnForecasts.getJSONObject(0),TYPE));
        return forecasts;
    }
    private List<Weather> getForecasts(String type){
        final String DATA = "data";
        List<Weather> forecasts = new ArrayList<>();
        JSONObject object = jsonObject.getJSONObject(type);
        JSONArray jsonForecasts = object.getJSONArray(DATA);
        for (int i = 0; i <jsonForecasts.length() ; i++) {
            forecasts.add(getForecastDay(jsonForecasts.getJSONObject(i), type));
        }
        return forecasts;
    }
    private Weather getForecastDay(JSONObject obj, String type){
        final String TIME="time";
        final String ICON = "icon";
        final String SUMMARY = "summary";
        final String HUMIDITY = "humidity";
        final String WIND_SPEED = "windSpeed";
        final String PRESSURE = "pressure";
        Weather weather = new Weather();
        weather.setSummmary(obj.getString(SUMMARY));
        weather.setHumidity(obj.getDouble(HUMIDITY));
        weather.setIconType(obj.getString(ICON));
        weather.setPreassure(obj.getDouble(PRESSURE));
        weather.setWindSpeed(obj.getDouble(WIND_SPEED));
        setTmperature(type, obj, weather);
        weather.setDate(new Date( obj.getLong(TIME)*1000));
        return weather;
    }
    private void setTmperature(String type, JSONObject obj, Weather weather){
        switch(type)
        {
            case "daily":
                final String MIN_TEMP = "temperatureMax";
                final String MAX_TEMP = "temperatureMin";
                double temp = (obj.getDouble(MIN_TEMP)+ obj.getDouble(MAX_TEMP))/2;
                weather.setTemp(temp);
                break;
            case "hourly":
                final String TEMPERATURE = "temperature";
                weather.setTemp(obj.getDouble(TEMPERATURE));
                break;
        }
    }
}
