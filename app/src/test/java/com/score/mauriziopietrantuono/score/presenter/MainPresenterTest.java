package com.score.mauriziopietrantuono.score.presenter;


import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.pojos.CreditReportInfo;
import com.score.mauriziopietrantuono.model.pojos.Score;
import com.score.mauriziopietrantuono.presenter.MainPresenter;
import com.score.mauriziopietrantuono.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.mockito.junit.MockitoJUnitRunner;

import rx.Observable;
import rx.Observer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {
    private static final int SCORE = 123;
    private static final String MESSAGE = "MESSAGE";

    @Mock MainModel mainModel;
    @Mock MainView view;
    @InjectMocks MainPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter.bind(view);
    }

    @Test
    public void when_onLoadClicked_then_progressIsVisible() {
        // WHEN
        presenter.onLoadClicked();
        // THEN
        verify(view).setProgressVisible(true);
    }

    @Test
    public void when_onLoadClicked_then_scoreIsSetTo0() {
        // WHEN
        presenter.onLoadClicked();
        // THEN
        verify(view).setScore(0);
    }

    @Test
    public void when_onNext_viewIsUpdated() {
        //GIVEN
        requestIsSuccesful();
        initPresenter();
        // WHEN
        presenter.subscribe();
        // THEN
        verify(view).setScore(SCORE);
    }

    @Test
    public void when_onComplete_viewIsUpdated() {
        //GIVEN
        requestIsSuccesful();
        initPresenter();
        // WHEN
        presenter.subscribe();
        // THEN
        verify(view).setProgressVisible(false);
    }

    @Test
    public void when_onError_userIsInformed() {
        //GIVEN
        requestIsUnsuccesful();
        initPresenter();
        // WHEN
        presenter.subscribe();
        // THEN
        verify(view).onError(MESSAGE);
    }

    private void requestIsUnsuccesful() {
        Observable<Score> observable = Observable.error(new Exception(MESSAGE));
        when(mainModel.getCachedResponse()).thenReturn(observable);
    }

    private void initPresenter() {
        presenter = new MainPresenter(mainModel);
        presenter.bind(view);
    }

    private void requestIsSuccesful() {
        Score score = createScore();
        when(mainModel.getCachedResponse()).thenReturn(Observable.just(score));
    }

    private Score createScore() {
        Score score = new Score();
        CreditReportInfo report = new CreditReportInfo();
        report.setScore(SCORE);
        score.setCreditReportInfo(report);
        return score;
    }
}