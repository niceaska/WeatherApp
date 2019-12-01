package ru.niceaska.geo.data.model;

import com.google.gson.annotations.SerializedName;

public class CoordModel {

    @SerializedName("lon")
    private double mLon;

    @SerializedName("lat")
    private double mLat;

    public double getmLon() {
        return mLon;
    }

    public void setmLon(double mLon) {
        this.mLon = mLon;
    }

    public double getmLat() {
        return mLat;
    }

    public void setmLat(double mLat) {
        this.mLat = mLat;
    }
}
