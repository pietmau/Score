package com.score.mauriziopietrantuono.dagger;

import android.support.v7.app.AppCompatActivity;

import com.score.mauriziopietrantuono.model.Cache;
import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.SimpleCache;
import com.score.mauriziopietrantuono.model.api.Api;
import com.score.mauriziopietrantuono.model.api.ApiRetrofit;
import com.score.mauriziopietrantuono.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private static final String BASE_URL = "https://5lfoiyb0b3.execute-api.us-west-2.amazonaws.com/";
    private Cache cache;

    public MainModule(AppCompatActivity activity) {
        cache = (Cache) activity.getLastCustomNonConfigurationInstance();
        if (cache == null) {
            cache = new SimpleCache();
        }
    }

    @Provides
    MainPresenter provideMainPresenter(MainModel model) {
        return new MainPresenter(model);
    }

    @Provides
    MainModel provideMainModel(Api api) {
        return new MockModel();
    }

    @Provides
    Api provideApi() {
        return new ApiRetrofit(BASE_URL);
    }

    @Provides
    Cache provideCache(){
        return cache;
    }
}
