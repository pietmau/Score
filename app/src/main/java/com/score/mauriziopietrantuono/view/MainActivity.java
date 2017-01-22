package com.score.mauriziopietrantuono.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.score.mauriziopietrantuono.dagger.DaggerMainComponent;
import com.score.mauriziopietrantuono.dagger.MainModule;
import com.score.mauriziopietrantuono.model.Cache;
import com.score.mauriziopietrantuono.presenter.MainPresenter;
import com.score.mauriziopietrantuono.score.R;
import com.score.mauriziopietrantuono.scoverview.ScoreView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView {
    @Inject MainPresenter presenter;
    @Inject Cache cache;
    @BindView(R.id.scoreview) ScoreView scoreView;
    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.activity_main) RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        performInjection();
        presenter.bind(MainActivity.this);
    }

    private void performInjection() {
        DaggerMainComponent.builder().mainModule(new MainModule(MainActivity.this)).build().inject(MainActivity.this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @OnClick(R.id.load)
    public void onLoadClicked() {
        presenter.onLoadClicked();
    }

    @Override
    public void setScore(int score) {
        scoreView.setScore(score);
    }

    @Override
    public void setProgressVisible(boolean isVisible) {
        if (isVisible) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onError(String message) {
        Snackbar.make(relativeLayout, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return cache;
    }
}
