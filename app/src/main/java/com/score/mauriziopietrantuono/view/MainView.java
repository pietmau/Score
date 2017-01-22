package com.score.mauriziopietrantuono.view;

public interface MainView {

    void setScore(int score);

    void setProgressVisible(boolean isVisible);

    void onError(String message);
}
