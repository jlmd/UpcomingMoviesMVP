package com.jlmd.android.newfilmsmvp.api.retrofit.upcomingmovies;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * @author jlmd
 */
public interface UpcomingMoviesService {

  @GET("/movie/upcoming")
  void getUpcomingMovies(@Query("api_key") String apiKey, Callback<UpcomingMoviesResult> callback);
}
