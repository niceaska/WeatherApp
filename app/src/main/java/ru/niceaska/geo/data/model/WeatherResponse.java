package ru.niceaska.geo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("coord")
    private CoordModel mCoords;

    @SerializedName("weather")
    private List<WeatherModel> mWeatherModelList;

    @SerializedName("main")
    private MainWeatherModel mMainWeather;

    @SerializedName("wind")
    private WindModel mWind;

    @SerializedName("name")
    private String mName;

    public CoordModel getmCoords() {
        return mCoords;
    }

    public void setmCoords(CoordModel mCoords) {
        this.mCoords = mCoords;
    }

    public List<WeatherModel> getmWeatherModelList() {
        return mWeatherModelList;
    }

    public void setmWeatherModelList(List<WeatherModel> mWeatherModelList) {
        this.mWeatherModelList = mWeatherModelList;
    }

    public MainWeatherModel getmMainWeather() {
        return mMainWeather;
    }

    public void setmMainWeather(MainWeatherModel mMainWeather) {
        this.mMainWeather = mMainWeather;
    }

    public WindModel getmWind() {
        return mWind;
    }

    public void setmWind(WindModel mWind) {
        this.mWind = mWind;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
