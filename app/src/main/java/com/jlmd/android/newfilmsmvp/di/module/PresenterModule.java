package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenterImp;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenterImp;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import java.util.Comparator;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author jlmd
 */
@Module(
    complete = false,
    library = true)
public class PresenterModule {

  @Provides
  @Singleton
  MoviesListPresenter providesMoviesListPresenter(UpcomingMoviesApi upcomingMoviesApi, Bus eventBus,
      @Named("date") Comparator<Movie> movieDateComparator,
      @Named("title") Comparator<Movie> movieTitleComparator) {
    return new MoviesListPresenterImp(upcomingMoviesApi, eventBus, movieDateComparator,
        movieTitleComparator);
  }

  @Provides
  @Singleton
  MovieDetailsPresenter providesMovieDetailsPresenter(MovieDetailsApi movieDetailsApi) {
    return new MovieDetailsPresenterImp(movieDetailsApi);
  }
}
