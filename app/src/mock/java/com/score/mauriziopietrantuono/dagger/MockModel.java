package com.score.mauriziopietrantuono.dagger;

import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;

public class MockModel implements MainModel {
    private static Observable<Score> cachedResponse;
    private static Observable<Score> response;

    @Override
    public Observable<Score> getScore() {
        return response;
    }

    @Override
    public Observable<Score> getCachedResponse() {
        return cachedResponse;
    }

    public static void setCachedResponse(Observable<Score> cachedResponse) {
        MockModel.cachedResponse = cachedResponse;
    }

    public static void setResponse(Observable<Score> response) {
        MockModel.response = response;
    }
}
