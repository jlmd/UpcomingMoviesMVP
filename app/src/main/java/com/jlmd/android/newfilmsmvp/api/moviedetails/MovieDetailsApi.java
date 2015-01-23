package com.jlmd.android.newfilmsmvp.api.moviedetails;

import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;

/**
 * @author jlmd
 */
public interface MovieDetailsApi {

    static final String BASE_URL = "https://api.themoviedb.org/3/movie";
    static final String API_KEY = "XXX";

    void getMovieDetails(int movieId, Callback callback);

    public interface Callback {

        void onFinish(MovieDetails movieDetails);

        void onError(String errorMessage);
    }
}
