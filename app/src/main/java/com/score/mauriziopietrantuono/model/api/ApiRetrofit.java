package com.score.mauriziopietrantuono.model.api;

import com.score.mauriziopietrantuono.model.pojos.Score;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ApiRetrofit implements Api {
    private final Api api;

    public ApiRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    @Override
    public Observable<Score> getScore() {
        return api.getScore();
    }
}
