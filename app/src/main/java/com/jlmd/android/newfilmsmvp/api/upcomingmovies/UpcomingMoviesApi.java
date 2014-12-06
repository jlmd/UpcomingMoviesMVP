package com.jlmd.android.newfilmsmvp.api.upcomingmovies;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;

import java.util.List;

/**
 * @author jlmd
 */
public interface UpcomingMoviesApi {
    void getUpcomingMovies(Callback callback);

    public interface Callback {
        void onFinish(List<Movie> movies);

        void onError(String errorMessage);
    }
}
