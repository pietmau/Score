package com.score.mauriziopietrantuono.model;


import com.score.mauriziopietrantuono.model.pojos.Score;

import rx.Observable;

public interface MainModel {
    Observable<Score> getScore();

    Observable<Score> getCachedResponse();
}
