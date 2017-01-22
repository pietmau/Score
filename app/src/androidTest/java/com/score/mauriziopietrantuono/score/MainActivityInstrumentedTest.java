package com.score.mauriziopietrantuono.score;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;


import com.score.mauriziopietrantuono.dagger.FakeModel;
import com.score.mauriziopietrantuono.model.pojos.CreditReportInfo;
import com.score.mauriziopietrantuono.model.pojos.Score;
import com.score.mauriziopietrantuono.view.MainActivity;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static com.score.mauriziopietrantuono.score.Matchers.withScore;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    private static final String MESSAGE = "message";
    //private Score score;

    @Rule public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

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
        Score score = createScore();
        FakeModel.setResponse(Observable.just(score));
        // WHEN
        onView(withId(R.id.load)).perform(click());
        // THEN
        onView(withId(R.id.scoreview)).check(matches(withScore(100)));
    }

    @Test
    public void when_error_then_ErrorIsShown() {
        // GIVEN
        Observable<Score> error = Observable.error(new Exception(MESSAGE));
        FakeModel.setResponse(error);
        // WHEN
        onView(withId(R.id.load)).perform(click());
        // THEN
        onView(withText(MESSAGE)).check(matches(isDisplayed()));
    }

    private Score createScore() {
        Score score = new Score();
        CreditReportInfo report = new CreditReportInfo();
        report.setScore(100);
        score.setCreditReportInfo(report);
        return score;
    }
}
