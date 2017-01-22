package com.score.mauriziopietrantuono.view;

public interface MainView {

    /** Sets the score in the view */
    void setScore(int score);

    /** Hides/shows the view */
    void setProgressVisible(boolean isVisible);

    /** Shows error message */
    void onError(String message);
}
