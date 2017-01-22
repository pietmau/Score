package com.score.mauriziopietrantuono.model.api;


import com.score.mauriziopietrantuono.model.pojos.Score;

import retrofit2.http.GET;
import rx.Observable;

public interface Api {

    @GET("prod/mockcredit/values")
    Observable<Score> getScore();
}
