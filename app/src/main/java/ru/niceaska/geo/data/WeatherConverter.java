package ru.niceaska.geo.data;

import ru.niceaska.geo.data.model.WeatherResponse;
import ru.niceaska.geo.data.repository.WeatherRepository;
import ru.niceaska.geo.domain.model.Weather;

public class WeatherConverter {

    public Weather convert(WeatherResponse response) {
        Weather weather = new Weather();
        weather.setmDescription(response.getmWeatherModelList().get(0).getmDescription());
        weather.setmHumidity(response.getmMainWeather().getmHumidity());
        weather.setmMain(response.getmWeatherModelList().get(0).getmMain());
        weather.setmPressure(response.getmMainWeather().getmPressure());
        weather.setmSeaLevel(response.getmMainWeather().getmSeaLevel());
        weather.setmTemp(response.getmMainWeather().getmTemp());
        weather.setmTempMin(response.getmMainWeather().getmTempMin());
        weather.setmTempMax(response.getmMainWeather().getmTempMax());
        weather.setmWindSpeed(response.getmWind().getmSpeed());
        weather.setmWindDeg(response.getmWind().getmDeg());
        weather.setLat(response.getmCoords().getmLat());
        weather.setLon(response.getmCoords().getmLon());
        return weather;
    }
}
