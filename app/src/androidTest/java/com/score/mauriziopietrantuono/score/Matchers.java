package com.score.mauriziopietrantuono.score;

import android.view.View;

import com.score.mauriziopietrantuono.scoverview.ScoreView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

class Matchers {
    /** Used to match the score of the ScoreView */
    public static Matcher<View> withScore(final int expectedScore) {
            return new TypeSafeMatcher<View>() {

                @Override
                public boolean matchesSafely(View view) {
                    if (!(view instanceof ScoreView)) {
                        return false;
                    }

                    int actualScore = ((ScoreView) view).getScore();

                    return expectedScore == actualScore;
                }

                @Override
                public void describeTo(Description description) {
                }
            };
        }
    }