package ru.niceaska.geo.presentation.viewmodel;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.niceaska.geo.data.repository.WeatherRepository;
import ru.niceaska.geo.domain.interactors.GetLocationInteractor;
import ru.niceaska.geo.domain.interactors.GetWeatherInteractor;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Context appContext;

    public ViewModelFactory(Context appContext) {
        this.appContext = appContext;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(GeoViewModel.class)) {
            WeatherRepository weatherRepository = new WeatherRepository(appContext);
            GetLocationInteractor locationInteractor = new GetLocationInteractor(weatherRepository);
            GetWeatherInteractor weatherInteractor = new GetWeatherInteractor(weatherRepository);
            return (T) new GeoViewModel(locationInteractor, weatherInteractor);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
