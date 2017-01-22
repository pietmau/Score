package com.score.mauriziopietrantuono.model;


import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;

public interface MainModel {

    /** Gets the score from the api */
    Observable<Score> getScore();

    /** Gets the cached response, if any */
    Observable<Score> getCachedRequest();
}
