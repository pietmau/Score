package com.score.mauriziopietrantuono.model;

import com.score.mauriziopietrantuono.model.pojos.Score;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;

/**
 * Used to cache the network request request.
 */
public class SimpleRequestCache implements RequestCache {
    private final Map<String, Observable<Score>> map;

    public SimpleRequestCache() {
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
