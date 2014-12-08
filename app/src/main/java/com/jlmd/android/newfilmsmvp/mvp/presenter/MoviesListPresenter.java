package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieDateComparator;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieTitleComparator;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

/**
 * @author jlmd
 */
public class MoviesListPresenter extends Presenter<MoviesListView> {

    @Inject
    protected UpcomingMoviesApi upcomingMoviesApi;

    private List<Movie> movies = Collections.emptyList();

    @Override
    public void initialize() {
        loadMovies();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void sortMoviesByTitle() {
        Collections.sort(movies, MovieTitleComparator.getInstance());
        showMovies(movies);
    }

    public void sortMoviesByDate() {
        Collections.sort(movies, MovieDateComparator.getInstance());
        showMovies(movies);
    }

    private void loadMovies() {
        view.showLoading();
        upcomingMoviesApi.getUpcomingMovies(new UpcomingMoviesApi.Callback() {
            @Override
            public void onFinish(List<Movie> movies) {
                setMovies(movies);
                showMovies(movies);
                view.hideLoading();
            }

            @Override
            public void onError(String errorMessage) {
                // TODO Show error message in view

                view.hideLoading();
            }
        });
    }

    private void showMovies(List<Movie> movies) {
        view.renderMovies(movies);
    }

    private void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
