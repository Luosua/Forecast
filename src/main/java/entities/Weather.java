package entities;

import java.util.Date;

/**
 * Created by Yuliya Pedash on 27.02.2017.
 */
public class Weather {
    Date date;
    String summmary;
    double temp;
    double humidity;
    double windSpeed;
    double preassure;
    String iconType;

    public Weather() {
    }

    public Weather(Date date, String summary, double temp, double humidity, double windSpeed, double preassure, String iconType) {
        this.date = date;
        this.summmary = summary;
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.preassure = preassure;
        this.iconType = iconType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSummmary() {
        return summmary;
    }

    public void setSummmary(String summmary) {
        this.summmary = summmary;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPreassure() {
        return preassure;
    }

    public void setPreassure(double preassure) {
        this.preassure = preassure;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }
    @Override
    public String toString(){
        String result = "";
        char newLine = '\n';
        result+="Date: " + date.toString() + newLine + "Temperature: " + temp + newLine;
        result+= "Summary: " + summmary + newLine + "Icon type: " + iconType + newLine;
        result += "Pressure: " + preassure + newLine + "Wind speed: " + windSpeed + newLine;
        result += "Humidity: " + humidity + newLine;
        return result;
    }
}
