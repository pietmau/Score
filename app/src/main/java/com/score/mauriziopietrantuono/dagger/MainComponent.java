package com.score.mauriziopietrantuono.dagger;


import com.score.mauriziopietrantuono.view.MainActivity;


import dagger.Component;

@Component (modules ={MainModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
