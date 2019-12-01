package ru.niceaska.geo.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.niceaska.geo.data.model.WeatherResponse;

public interface WeatherApi {

    @GET("/data/2.5/weather")
    Call<WeatherResponse> getWeather(@Query("lat") double lat, @Query("lon") double lon,
                                     @Query("units") String unit, @Query("appid") String appId);
}
