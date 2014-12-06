package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.Presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jlmd
 */
@Module(
        complete = false,
        library = true
)
public class PresenterModule {
    @Provides
    @Singleton
    Presenter providesMoviesListPresenter() {
        return new MoviesListPresenter();
    }
}
