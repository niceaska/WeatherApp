package ru.niceaska.geo.data.model;

import com.google.gson.annotations.SerializedName;

public class MainWeatherModel {

    @SerializedName("temp")
    private double mTemp;

    @SerializedName("humidity")
    private int mHumidity;

    @SerializedName("temp_min")
    private double mTempMin;

    @SerializedName("pressure")
    private double mPressure;

    @SerializedName("temp_max")
    private double mTempMax;

    @SerializedName("sea_level")
    private  double mSeaLevel;

    public double getmTemp() {
        return mTemp;
    }

    public void setmTemp(double mTemp) {
        this.mTemp = mTemp;
    }

    public int getmHumidity() {
        return mHumidity;
    }

    public void setmHumidity(int mHumidity) {
        this.mHumidity = mHumidity;
    }

    public double getmTempMin() {
        return mTempMin;
    }

    public void setmTempMin(double mTempMin) {
        this.mTempMin = mTempMin;
    }

    public double getmPressure() {
        return mPressure;
    }

    public void setmPressure(double mPressure) {
        this.mPressure = mPressure;
    }

    public double getmTempMax() {
        return mTempMax;
    }

    public void setmTempMax(double mTempMax) {
        this.mTempMax = mTempMax;
    }

    public double getmSeaLevel() {
        return mSeaLevel;
    }

    public void setmSeaLevel(double mSeaLevel) {
        this.mSeaLevel = mSeaLevel;
    }
}
