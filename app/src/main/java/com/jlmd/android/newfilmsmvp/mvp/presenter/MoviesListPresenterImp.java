package com.jlmd.android.newfilmsmvp.mvp.presenter;

import android.util.Log;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieDateComparator;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieTitleComparator;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;

import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class MoviesListPresenterImp extends MoviesListPresenter {

    private UpcomingMoviesApi upcomingMoviesApi;
    private boolean sortedByTitle;
    private List<Movie> movies = Collections.emptyList();
    private final static String TAG = MoviesListPresenterImp.class.getSimpleName();

    public MoviesListPresenterImp(UpcomingMoviesApi upcomingMoviesApi) {
        this.upcomingMoviesApi = upcomingMoviesApi;
    }

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

    @Override
    public void onSortButtonClick() {
        if (sortedByTitle) {
            sortMoviesByDate();
        } else {
            sortMoviesByTitle();
        }
        sortedByTitle = !sortedByTitle;
    }

    private void sortMoviesByTitle() {
        Collections.sort(movies, MovieTitleComparator.getInstance());
        showMovies(movies);
    }

    private void sortMoviesByDate() {
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
                Log.i(TAG, "Error: " + errorMessage);
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
