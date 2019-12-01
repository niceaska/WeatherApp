package ru.niceaska.geo.domain.interactors;

import ru.niceaska.geo.data.repository.WeatherRepository;
import ru.niceaska.geo.domain.OnLoadDtatListener;

public class GetLocationInteractor {

    private WeatherRepository weatherRepository;

    public GetLocationInteractor(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void startLocationService(OnLoadDtatListener listener) {
        weatherRepository.startService(listener);
    }
}
