package com.score.mauriziopietrantuono.presenter;

import com.score.mauriziopietrantuono.model.MainModel;
import com.score.mauriziopietrantuono.model.pojos.Score;
import com.score.mauriziopietrantuono.view.MainView;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainPresenter {
    private final MainModel model;
    private MainView view;
    private Subscription subscription;
    private Observable<Score> observable;

    public MainPresenter(MainModel model) {
        this.model = model;
        observable = model.getCachedRequest();
    }

    /** Sets the view */
    public void bind(MainView mainView) {
        this.view = mainView;
    }

    /** In case of error */
    private void onError(Throwable e) {
        onLoadCompleted();
        view.onError(e.getMessage());
    }

    /** Loading completes */
    private void onLoadCompleted() {
        view.setProgressVisible(false);
    }

    /** Creates the subscriber and subscribes it to the to the observable */
    public void subscribe() {
        Subscriber<Score> subscriber = new Subscriber<Score>() {
            @Override
            public void onCompleted() {
                onLoadCompleted();
            }

            @Override
            public void onError(Throwable e) {
                MainPresenter.this.onError(e);
            }

            @Override
            public void onNext(Score score) {
                if (score != null && score.getCreditReportInfo() != null) {
                    view.setScore(score.getCreditReportInfo().getScore());
                }
            }
        };
        if (observable != null) {
            onLoadingStarted();
            subscription = observable.subscribe(subscriber);
        }
    }

    /** Unsubscribes to prevent memory leaks */
    public void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /** Load button is clicked */
    public void onLoadClicked() {
        onLoadingStarted();
        observable = model.getScore();
        subscribe();
    }

    /** When loading starts */
    private void onLoadingStarted() {
        view.setProgressVisible(true);
        view.setScore(0);
    }
}
