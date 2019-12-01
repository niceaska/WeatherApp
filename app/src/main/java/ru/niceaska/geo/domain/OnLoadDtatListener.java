package ru.niceaska.geo.domain;

import ru.niceaska.geo.domain.model.Weather;

public interface OnLoadDtatListener {
    void onLoadData(Weather weather);
}
