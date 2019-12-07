package ru.niceaska.geo.presentation.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import ru.niceaska.geo.domain.OnLoadDtatListener;
import ru.niceaska.geo.domain.interactors.GetLocationInteractor;
import ru.niceaska.geo.domain.interactors.GetWeatherInteractor;
import ru.niceaska.geo.domain.model.Weather;
import ru.niceaska.geo.utils.WeatherUtils;

public class GeoViewModel extends ViewModel {

    public MutableLiveData<String> weatherMain = new MutableLiveData<>();
    public MutableLiveData<String> weatherDescription = new MutableLiveData<>();
    public MutableLiveData<String> weatherTemp = new MutableLiveData<>();
    public MutableLiveData<String> weatherTempMaxMin = new MutableLiveData<>();
    public MutableLiveData<String> weatherPressureHumidity = new MutableLiveData<>();
    public MutableLiveData<String> weatherWinSpeedDeg = new MutableLiveData<>();
    public MutableLiveData<String> locationName = new MutableLiveData<>();


    private double mLat;
    private double mLon;
    private Disposable updateLocation;
    private static final String TAG = "GeoViewModel";

    private GetLocationInteractor mLocationInteractor;
    private GetWeatherInteractor mGetWeatherInteractor;

    public GeoViewModel(GetLocationInteractor locationInteractor,
                        GetWeatherInteractor getWeatherInteractor) {
        mLocationInteractor = locationInteractor;
        mGetWeatherInteractor = getWeatherInteractor;
    }

    public void startLocationService() {

        final OnLoadDtatListener listener = new OnLoadDtatListener() {

            @Override
            public void onLoadData(Weather weather) {
                if (weather != null) {
                    weatherMain.setValue(weather.getmMain());
                    weatherDescription.setValue(weather.getmDescription());
                    weatherTemp.setValue(String.valueOf(weather.getmTemp()));
                    weatherTempMaxMin.setValue(WeatherUtils.formatMinMaxTemp(
                            weather.getmTempMin(), weather.getmTempMax())
                    );
                    weatherPressureHumidity.setValue(
                            WeatherUtils.formatPressureHumadity(weather.getmHumidity(), weather.getmPressure())
                    );
                    weatherWinSpeedDeg.setValue(
                            WeatherUtils.formatWind(weather.getmWindDeg(), weather.getmWindSpeed())
                    );

                    if (mLat != weather.getLat() || mLon != weather.getLon()) {
                        mLat = weather.getLat();
                        mLon = weather.getLon();
                        updateLocation(mLat, mLon);
                    }
                }
            }
        };

        mLocationInteractor.startLocationService(listener);
    }



    private void updateLocation(double lat, double lon) {
        updateLocation = mGetWeatherInteractor.getAdress(lat, lon)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        locationName.setValue(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "accept: " + " error " + throwable.getMessage());
                    }
                });
    }

    public void dispose() {
        updateLocation.dispose();
    }
}
