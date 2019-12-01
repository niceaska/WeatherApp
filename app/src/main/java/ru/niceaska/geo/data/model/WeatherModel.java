package ru.niceaska.geo.data.model;

import com.google.gson.annotations.SerializedName;

public class WeatherModel {

    @SerializedName("main")
    private String mMain;
    @SerializedName("description")
    private String mDescription;

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
}
