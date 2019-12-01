package ru.niceaska.geo.presentation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.niceaska.geo.data.repository.WeatherRepository;
import ru.niceaska.geo.domain.OnLoadDtatListener;
import ru.niceaska.geo.domain.interactors.GetLocationInteractor;
import ru.niceaska.geo.domain.interactors.GetWeatherInteractor;
import ru.niceaska.geo.domain.model.Weather;

public class GeoViewModel extends AndroidViewModel {

    public MutableLiveData<String> weatherMain = new MutableLiveData<>();
    public MutableLiveData<String> weatherDescription = new MutableLiveData<>();
    public MutableLiveData<String> weatherTemp = new MutableLiveData<>();
    public MutableLiveData<String> weatherTempMin = new MutableLiveData<>();
    public MutableLiveData<String> weatherTempMax = new MutableLiveData<>();
    public MutableLiveData<String> weatherHumidity = new MutableLiveData<>();
    public MutableLiveData<String> weatherPressure = new MutableLiveData<>();
    public MutableLiveData<String> weatherSeaLevel = new MutableLiveData<>();
    public MutableLiveData<String> weatherWinSpeed = new MutableLiveData<>();
    public MutableLiveData<String> weatherWinDeg = new MutableLiveData<>();
    public MutableLiveData<String> lovationName = new MutableLiveData<>();


    private double mLat;
    private double mLon;
    private WeatherRepository weatherRepository = new WeatherRepository(getApplication());
    private GetLocationInteractor locationInteractor = new GetLocationInteractor(weatherRepository);
    private GetWeatherInteractor weatherInteractor = new GetWeatherInteractor(weatherRepository);

    public GeoViewModel(@NonNull Application application) {
        super(application);
    }

    public void startLocationService() {

        final OnLoadDtatListener listener = new OnLoadDtatListener() {

            @Override
            public void onLoadData(Weather weather) {
                if (weather != null) {
                    weatherMain.setValue(weather.getmMain());
                    weatherDescription.setValue(weather.getmDescription());
                    weatherTemp.setValue(String.valueOf(weather.getmTemp()));
                    weatherTempMin.setValue(String.valueOf(weather.getmTempMin()));
                    weatherTempMax.setValue(String.valueOf(weather.getmTempMax()));
                    weatherHumidity.setValue(String.valueOf(weather.getmHumidity()));
                    weatherSeaLevel.setValue(String.valueOf(weather.getmSeaLevel()));
                    weatherPressure.setValue(String.valueOf(weather.getmPressure()));
                    weatherWinSpeed.setValue(String.valueOf(weather.getmWindSpeed()));
                    weatherWinDeg.setValue(String.valueOf(weather.getmWindDeg()));

                    if (mLat != weather.getLat() || mLon != weather.getLon()) {
                        mLat = weather.getLat();
                        mLon = weather.getLon();
                        updateLocation(mLat, mLon);
                    }
                }
            }
        };

        locationInteractor.startLocationService(listener);
    }



    private void updateLocation(double lat, double lon) {
        Disposable disposable = weatherInteractor.getAdress(lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        lovationName.setValue(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                    }
                });

    }


}
