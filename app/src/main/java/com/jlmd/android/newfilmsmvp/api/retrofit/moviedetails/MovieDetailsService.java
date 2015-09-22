package com.jlmd.android.newfilmsmvp.api.retrofit.moviedetails;

import com.jlmd.android.newfilmsmvp.api.moviedetails.model.MovieDetailsResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * @author jlmd
 */
public interface MovieDetailsService {

  @GET("/movie/{movie_id}")
  void getMovieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey,
      Callback<MovieDetailsResult> callback);
}
