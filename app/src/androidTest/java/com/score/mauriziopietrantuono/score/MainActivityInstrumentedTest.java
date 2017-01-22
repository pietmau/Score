package com.score.mauriziopietrantuono.score;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;


import com.score.mauriziopietrantuono.dagger.MockModel;
import com.score.mauriziopietrantuono.model.pojos.CreditReportInfo;
import com.score.mauriziopietrantuono.model.pojos.Score;
import com.score.mauriziopietrantuono.scoverview.ScoreView;
import com.score.mauriziopietrantuono.view.MainActivity;


import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static com.score.mauriziopietrantuono.score.Matchers.withScore;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private static final String MESSAGE = "message";
    private Score score;

    @Rule public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        score = new Score();
        CreditReportInfo report = new CreditReportInfo();
        report.setScore(100);
        score.setCreditReportInfo(report);
    }

    @Test
    public void when_starts_then_progressInvisible() {
        onView(withId(R.id.progress)).check(matches(not(isDisplayed())));
    }

    @Test
    public void when_starts_then_buttonIsVisible() {
        onView(withId(R.id.load)).check(matches(isDisplayed()));
    }

    @Test
    public void when_starts_then_scoreIsZero() {
        onView(withId(R.id.scoreview)).check(matches(withScore(0)));
    }

    @Test
    public void when_loads_then_scoreIsNotZero() {
        // GIVEN
        MockModel.setResponse(Observable.just(score));
        // WHEN
        onView(withId(R.id.load)).perform(click());
        // THEN
        onView(withId(R.id.scoreview)).check(matches(withScore(100)));
    }

    @Test
    public void when_error_then_ErrorIsShown() {
        // GIVEN
        Observable<Score> error = Observable.error(new Exception(MESSAGE));
        MockModel.setResponse(error);
        // WHEN
        onView(withId(R.id.load)).perform(click());
        // THEN
        onView(withText(MESSAGE)).check(matches(isDisplayed()));
    }
}
