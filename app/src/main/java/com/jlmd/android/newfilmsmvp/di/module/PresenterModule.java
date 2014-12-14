package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenterImp;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenterImp;
import com.jlmd.android.newfilmsmvp.mvp.presenter.Presenter;

import javax.inject.Named;
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
    MoviesListPresenter providesMoviesListPresenter(UpcomingMoviesApi upcomingMoviesApi) {
        return new MoviesListPresenterImp(upcomingMoviesApi);
    }

    @Provides
    @Singleton
    MovieDetailsPresenter providesMovieDetailsPresenter(MovieDetailsApi movieDetailsApi) {
        return new MovieDetailsPresenterImp(movieDetailsApi);
    }
}
