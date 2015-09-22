package com.jlmd.android.newfilmsmvp.api.mock;

import android.content.Context;
import android.os.Handler;
import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.utils.Utils;
import java.io.IOException;
import java.util.List;

/**
 * @author jlmd
 */
public class MockedUpcomingMoviesApi implements UpcomingMoviesApi {

  private static final String FILE_PATH = "mock/upcoming/";
  private static final String FILE_NAME = "upcomingmovies.json";
  private static final int LOAD_DELAY_TIME = 1000;
  private final Mapper upcomingMoviesApiMapper;
  private final Context context;
  private final Gson gson;

  public MockedUpcomingMoviesApi(Context context, Mapper upcomingMoviesApiMapper, Gson gson) {
    this.context = context;
    this.upcomingMoviesApiMapper = upcomingMoviesApiMapper;
    this.gson = gson;
  }

  @Override
  public void getUpcomingMovies(Callback callback) {
    loadMockedMoviesDelayed(callback, LOAD_DELAY_TIME);
  }

  private void loadMockedMoviesDelayed(final Callback callback, int delay) {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
      public void run() {
        try {
          String json = Utils.loadJSONFromAsset(context, FILE_PATH + FILE_NAME);
          List<Movie> movies = (List<Movie>) upcomingMoviesApiMapper.
              map(gson.fromJson(json, UpcomingMoviesResult.class));
          callback.onFinish(movies);
        } catch (IOException e) {
          callback.onError(e.getMessage());
        }
      }
    };
    handler.postDelayed(runnable, delay);
  }
}
