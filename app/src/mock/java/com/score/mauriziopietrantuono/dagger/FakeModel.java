package com.score.mauriziopietrantuono.dagger;

import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;

/** Replacement for the real Model for instrumented tests */
public class FakeModel implements MainModel {
    private static Observable<Score> cachedResponse;
    private static Observable<Score> response;

    @Override
    public Observable<Score> getScore() {
        return response;
    }

    @Override
    public Observable<Score> getCachedRequest() {
        return cachedResponse;
    }

    public static void setCachedResponse(Observable<Score> cachedResponse) {
        FakeModel.cachedResponse = cachedResponse;
    }

    public static void setResponse(Observable<Score> response) {
        FakeModel.response = response;
    }
}
