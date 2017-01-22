package com.score.mauriziopietrantuono.score.model;

import com.score.mauriziopietrantuono.model.RequestCache;
import com.score.mauriziopietrantuono.model.MainModelRetrofit;
import com.score.mauriziopietrantuono.model.api.Api;
import com.score.mauriziopietrantuono.model.pojos.Score;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import rx.Observable;
import rx.Scheduler;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainModelTest {
    @Mock Api api;
    @Mock RequestCache cache;
    @Mock Scheduler observeOn;
    @Mock Scheduler subscribeOn;
    @InjectMocks MainModelRetrofit model;

    @Before
    public void setUp() throws Exception {
        Observable<Score> observable = Observable.just(null);
        when(api.getScore()).thenReturn(observable);
    }

    @Test
    public void when_getScore_then_getsScore() {
        // WHEN
        model.getScore();
        // THEN
        verify(api).getScore();
    }

    @Test
    public void when_getScore_then_storesTheObservable() {
        // WHEN
        model.getScore();
        // THEN
        verify(cache).put(anyString(), isA(Observable.class));
    }
}