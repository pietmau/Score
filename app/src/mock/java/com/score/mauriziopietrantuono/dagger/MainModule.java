package com.score.mauriziopietrantuono.dagger;

import android.support.v7.app.AppCompatActivity;

import com.score.mauriziopietrantuono.model.RequestCache;
import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.SimpleRequestCache;
import com.score.mauriziopietrantuono.model.api.Api;
import com.score.mauriziopietrantuono.model.api.ApiRetrofit;
import com.score.mauriziopietrantuono.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/** Module for instrumented tests */
@Module
public class MainModule {
    private static final String BASE_URL = "https://5lfoiyb0b3.execute-api.us-west-2.amazonaws.com/";
    private RequestCache cache;

    public MainModule(AppCompatActivity activity) {
        cache = (RequestCache) activity.getLastCustomNonConfigurationInstance();
        if (cache == null) {
            cache = new SimpleRequestCache();
        }
    }

    @Provides
    MainPresenter provideMainPresenter(MainModel model) {
        return new MainPresenter(model);
    }

    @Provides
    MainModel provideMainModel(Api api) {
        return new FakeModel();
    }

    @Provides
    Api provideApi() {
        return new ApiRetrofit(BASE_URL);
    }

    @Provides
    RequestCache provideCache(){
        return cache;
    }
}
