package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;

import java.util.List;

import javax.inject.Inject;

/**
 * @author jlmd
 */
public class MoviesListPresenter extends Presenter<MoviesListView> {

    @Inject
    protected UpcomingMoviesApi upcomingMoviesApi;

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

    private void loadMovies() {
        view.showLoading();
        upcomingMoviesApi.getUpcomingMovies(new UpcomingMoviesApi.Callback() {
            @Override
            public void onFinish(List<Movie> movies) {
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

}
