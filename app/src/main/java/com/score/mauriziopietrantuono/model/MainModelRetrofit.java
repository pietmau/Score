package com.score.mauriziopietrantuono.model;

import com.score.mauriziopietrantuono.model.api.Api;
import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;
import rx.Scheduler;

public class MainModelRetrofit implements MainModel {
    private static final String KEY = "cache_key";
    private final Api api;
    private final Cache cache;
    private final Scheduler subscribeOn;
    private final Scheduler observeOn;

    public MainModelRetrofit(Api api, Cache cache, Scheduler subscribeOn, Scheduler observeOn) {
        this.api = api;
        this.cache = cache;
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    @Override
    public Observable<Score> getScore(){
        Observable<Score> observable = api.getScore().subscribeOn(subscribeOn)
                .observeOn(observeOn).cache();
        cache.put(KEY,observable);
        return observable;
    }


    @Override
    public Observable<Score> getCachedResponse() {
        return cache.get(KEY);
    }
}
