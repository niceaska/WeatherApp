package ru.niceaska.geo.utils;

public class WeatherUtils {

    private static final String FIELD_DELIM = " / ";
    private static final String HUMIDITY_CAPTION = "Humidity: ";
    private static final String PRESSURE = " Pressure: ";
    private static final String WIND_SPEED = "Wind speed: ";
    private static final String SPEED_VALUES = " m/s ";
    private static final String WIND_DEG = " Wind degree: ";

    private WeatherUtils() {
    }

    public static String formatMinMaxTemp(double minTemp, double maxTemp) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(minTemp)
                .append(FIELD_DELIM)
                .append(maxTemp);
        return new String(stringBuilder);
    }

    public static String formatPressureHumadity(int humidity, double pressure) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HUMIDITY_CAPTION)
                .append(humidity)
                .append(PRESSURE)
                .append(pressure);
        return new String(stringBuilder);
    }

    public static String formatWind(int windDeg, double windSpeed) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WIND_SPEED)
                .append(windSpeed)
                .append(SPEED_VALUES)
                .append(WIND_DEG)
                .append(windDeg);
        return new String(stringBuilder);
    }
}
