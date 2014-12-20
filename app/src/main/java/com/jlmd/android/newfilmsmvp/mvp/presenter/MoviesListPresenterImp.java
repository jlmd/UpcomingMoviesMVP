package com.jlmd.android.newfilmsmvp.mvp.presenter;

import android.content.Context;
import android.util.Log;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.bus.event.ItemSelectedEvent;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieDateComparator;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieTitleComparator;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.squareup.otto.Bus;

import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class MoviesListPresenterImp extends MoviesListPresenter {

    private UpcomingMoviesApi upcomingMoviesApi;
    private boolean sortedByTitle;
    private List<Movie> movies = Collections.emptyList();
    private final Context context;
    private final Bus bus;
    private final static String TAG = MoviesListPresenterImp.class.getSimpleName();

    public MoviesListPresenterImp(UpcomingMoviesApi upcomingMoviesApi, Context context, Bus bus) {
        this.upcomingMoviesApi = upcomingMoviesApi;
        this.context = context;
        this.bus = bus;
    }

    @Override
    public void initialize() {
        loadMovies();
    }

    @Override
    public void resume() {
        // Empty
    }

    @Override
    public void pause() {
        // Empty
    }

    @Override
    public void destroy() {
        // Empty
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

    @Override
    public void onItemSelected(int position) {
        bus.post(new ItemSelectedEvent(movies.get(position)));
    }

    private void launchMovieDetailsActivity(Movie movie) {

//        Intent detailsActivityIntent = new Intent(context, MovieDetailsActivity.class);
//        detailsActivityIntent.putExtra(Constants.KEY_MOVIE_DETAILS, movie);
//        detailsActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(detailsActivityIntent);
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
