package ru.niceaska.geo.utils;

public class TemperatureUtils {

    private static final String FIELD_DELIM = " / ";

    private TemperatureUtils() {
    }

    public static String formatMinMaxTemp(double minTemp, double maxTemp) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(minTemp)
                .append(FIELD_DELIM)
                .append(maxTemp);
        return new String(stringBuilder);
    }
}
