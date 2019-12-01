package ru.niceaska.geo.domain.model;

public class Weather {

    private double lon;
    private double lat;
    private String mMain;
    private String mDescription;
    private double mTemp;
    private int mHumidity;
    private double mTempMin;
    private double mPressure;
    private double mTempMax;
    private  double mSeaLevel;
    private double mWindSpeed;
    private int mWindDeg;

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

    public String getmMain() {
        return mMain;
    }

    public void setmMain(String mMain) {
        this.mMain = mMain;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public double getmWindSpeed() {
        return mWindSpeed;
    }

    public void setmWindSpeed(double mWindSpeed) {
        this.mWindSpeed = mWindSpeed;
    }

    public int getmWindDeg() {
        return mWindDeg;
    }

    public void setmWindDeg(int mWindDeg) {
        this.mWindDeg = mWindDeg;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
