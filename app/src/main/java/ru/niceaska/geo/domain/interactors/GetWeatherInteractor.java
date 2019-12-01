package ru.niceaska.geo.domain.interactors;

import io.reactivex.Single;
import ru.niceaska.geo.data.repository.WeatherRepository;

public class GetWeatherInteractor {

    private WeatherRepository weatherRepository;


    public GetWeatherInteractor(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Single<String> getAdress(double lon, double lat) {
        return weatherRepository.getFromLocation(lat, lon);
    }
}
