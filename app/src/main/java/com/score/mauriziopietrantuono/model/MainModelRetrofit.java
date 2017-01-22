package com.score.mauriziopietrantuono.model;

import com.score.mauriziopietrantuono.model.api.Api;
import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;
import rx.Scheduler;

public class MainModelRetrofit implements MainModel {
    private static final String REQUEST = "cache_key";
    private final Api api;
    private final RequestCache cache;
    private final Scheduler subscribeOn;
    private final Scheduler observeOn;

    public MainModelRetrofit(Api api, RequestCache cache, Scheduler subscribeOn, Scheduler observeOn) {
        this.api = api;
        this.cache = cache;
        this.subscribeOn = subscribeOn;
        this.observeOn = observeOn;
    }

    /** Gets the observable and stores it */
    @Override
    public Observable<Score> getScore(){
        Observable<Score> request = api.getScore().subscribeOn(subscribeOn)
                .observeOn(observeOn).cache();
        cache.put(REQUEST,request);
        return request;
    }


    @Override
    public Observable<Score> getCachedRequest() {
        return cache.get(REQUEST);
    }
}
