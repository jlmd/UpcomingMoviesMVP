package com.jlmd.android.newfilmsmvp.api.upcomingmovies;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;

import java.util.List;

/**
 * @author jlmd
 */
public interface UpcomingMoviesApi {
    static final String BASE_URL = "https://api.themoviedb.org/3/movie";
    static final String API_KEY = "cb53f5e81377dfb656d6f6eba5efa33a";

    void getUpcomingMovies(Callback callback);

    public interface Callback {
        void onFinish(List<Movie> movies);
        void onError(String errorMessage);
    }
}
