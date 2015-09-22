package com.jlmd.android.newfilmsmvp.api.mock;

import android.content.Context;
import android.os.Handler;
import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.moviedetails.model.MovieDetailsResult;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;
import com.jlmd.android.newfilmsmvp.utils.Utils;
import java.io.IOException;

/**
 * @author jlmd
 */
public class MockedMovieDetailsApi implements MovieDetailsApi {

  private static final String FILE_PATH = "mock/details/";
  private static final int LOAD_DELAY_TIME = 1000;
  private final Mapper movieDetailsMapper;
  private final Context context;
  private final Gson gson;

  public MockedMovieDetailsApi(Context context, Mapper movieDetailsMapper, Gson gson) {
    this.context = context;
    this.movieDetailsMapper = movieDetailsMapper;
    this.gson = gson;
  }

  @Override
  public void getMovieDetails(int movieId, Callback callback) {
    loadMockedMoviesDelayed(movieId, callback, LOAD_DELAY_TIME);
  }

  private void loadMockedMoviesDelayed(final int movieId, final Callback callback, int delay) {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
      public void run() {
        try {
          String json = Utils.loadJSONFromAsset(context, FILE_PATH + movieId + ".json");
          MovieDetails movieDetails = (MovieDetails) movieDetailsMapper.
              map(gson.fromJson(json, MovieDetailsResult.class));
          callback.onFinish(movieDetails);
        } catch (IOException e) {
          callback.onError(e.getMessage());
        }
      }
    };
    handler.postDelayed(runnable, delay);
  }
}
