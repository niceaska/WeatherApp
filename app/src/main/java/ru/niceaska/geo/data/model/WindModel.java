package ru.niceaska.geo.data.model;

import com.google.gson.annotations.SerializedName;

public class WindModel {

    @SerializedName("speed")
    private double mSpeed;

    @SerializedName("deg")
    private int mDeg;

    public double getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(double mSpeed) {
        this.mSpeed = mSpeed;
    }

    public int getmDeg() {
        return mDeg;
    }

    public void setmDeg(int mDeg) {
        this.mDeg = mDeg;
    }
}
