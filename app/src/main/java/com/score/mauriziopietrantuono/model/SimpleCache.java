package com.score.mauriziopietrantuono.model;

import com.score.mauriziopietrantuono.model.pojos.Score;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

public class SimpleCache implements Cache {
    private final Map<String, Observable<Score>> map;

    public SimpleCache() {
        map = new HashMap<>();
    }

    @Override
    public void put(String key, Observable<Score> observable) {
        map.put(key,observable);
    }

    @Override
    public Observable<Score> get(String key) {
        return map.get(key);
    }
}
