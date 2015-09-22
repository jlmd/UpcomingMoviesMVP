package com.jlmd.android.newfilmsmvp.mvp.presenter;

import android.util.Log;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;

/**
 * @author jlmd
 */
public class MovieDetailsPresenterImp extends MovieDetailsPresenter {

  private final static String TAG = MovieDetailsPresenterImp.class.getSimpleName();
  private MovieDetailsApi movieDetailsApi;

  public MovieDetailsPresenterImp(MovieDetailsApi movieDetailsApi) {
    this.movieDetailsApi = movieDetailsApi;
  }

  @Override
  public void onMovieReceive(Movie movie) {
    loadMovieDetails(movie);
  }

  @Override
  public void initialize() {
    // Empty
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

  private void loadMovieDetails(final Movie movie) {
    movieDetailsApi.getMovieDetails(movie.getId(), new MovieDetailsApi.Callback() {
      @Override
      public void onFinish(MovieDetails movieDetails) {
        movieDetails.setMovie(movie);
        view.renderMovie(movieDetails);
        view.hideLoading();
      }

      @Override
      public void onError(String errorMessage) {
        Log.i(TAG, "Error: " + errorMessage);
        view.hideLoading();
      }
    });
  }
}
