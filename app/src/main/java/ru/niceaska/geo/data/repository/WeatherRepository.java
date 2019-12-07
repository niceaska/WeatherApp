package ru.niceaska.geo.data.repository;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.niceaska.geo.data.WeatherApi;
import ru.niceaska.geo.data.WeatherConverter;
import ru.niceaska.geo.data.model.WeatherResponse;
import ru.niceaska.geo.domain.OnLoadDtatListener;

public class WeatherRepository {

    private static final String BASE_URL = "https://api.openweathermap.org";
    private static final String API_KEY = "79731a9d9e8a59e7d3618e6ead73f3f9";
    private static final String UNITS = "metric";
    private static final String TAG = "weather";
    private final String ADDRESS_NOT_FOUND = "Not found";
    private WeatherApi mApiService;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private LocationCallback mLocationCallback;
    private Geocoder mGeocoder;

    private Context mContext;


    public WeatherRepository(Context context) {
            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
            mApiService = retrofit.create(WeatherApi.class);
            mContext = context;
    }

    private void getWeather(final double lat, final double lon, final OnLoadDtatListener listener) {
        mApiService.getWeather(lat, lon, UNITS, API_KEY).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.body() != null) {
                    Log.d(TAG, "onResponse: " + lat + " " + lon);
                    listener.onLoadData(new WeatherConverter().convert(response.body()));

                }

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.d("WeatherRepository", "onFailure: " + t.toString());
            }
        });
    }

    public void startService(OnLoadDtatListener listener) {
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(mContext);
        mLocationCallback = new MainLocationCallback(listener);
        mGeocoder = new Geocoder(mContext);
        mFusedLocationProviderClient.requestLocationUpdates(getLocationRequest(), mLocationCallback, null);
    }

    private LocationRequest getLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000L);
        locationRequest.setFastestInterval(5000L);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        return locationRequest;
    }

    public Single<String> getFromLocation(final double lat, final double lon) {
        return Single.fromCallable(new Callable<List<Address>>() {
            @Override
            public List<Address> call() throws Exception {
                return  mGeocoder.getFromLocation(lat, lon, 1);
            }
        }).map(new Function<List<Address>, String>() {
            @Override
            public String apply(List<Address> addressList) throws Exception {
                return addressList == null || addressList.isEmpty() ?
                        ADDRESS_NOT_FOUND : addressList.get(0).getLocality();
            }
        });
    }

    private class MainLocationCallback extends LocationCallback {

        private OnLoadDtatListener listener;

        public MainLocationCallback(OnLoadDtatListener listener) {
            this.listener = listener;
        }

        @Override
        public void onLocationResult(LocationResult locationResult) {
            if (locationResult == null) {
                return;
            }

            Location lastLocation = locationResult.getLastLocation();
            getWeather(lastLocation.getLatitude(), lastLocation.getLongitude(), listener);

        }
    }
}
