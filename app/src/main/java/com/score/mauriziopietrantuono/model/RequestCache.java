package com.score.mauriziopietrantuono.model;

import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;

public interface RequestCache {
    void put(String key, Observable<Score> observable);

    Observable<Score> get(String key);
}
