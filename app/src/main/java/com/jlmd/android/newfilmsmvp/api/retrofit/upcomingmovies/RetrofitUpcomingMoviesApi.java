package com.jlmd.android.newfilmsmvp.api.retrofit.upcomingmovies;

import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import java.util.List;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * @author jlmd
 */
public class RetrofitUpcomingMoviesApi implements UpcomingMoviesApi {

  private final Mapper upcomingMoviesApiMapper;
  private UpcomingMoviesService upcomingMoviesService;

  public RetrofitUpcomingMoviesApi(Mapper mapper) {
    this.upcomingMoviesApiMapper = mapper;
    initRestAdapter();
  }

  private void initRestAdapter() {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).build();

    upcomingMoviesService = restAdapter.create(UpcomingMoviesService.class);
  }

  @Override
  public void getUpcomingMovies(final Callback callback) {
    upcomingMoviesService.getUpcomingMovies(API_KEY, new retrofit.Callback<UpcomingMoviesResult>() {
          @Override
          public void success(UpcomingMoviesResult upcomingMoviesResults, Response response) {
            callback.onFinish((List<Movie>) upcomingMoviesApiMapper.map(upcomingMoviesResults));
          }

          @Override
          public void failure(RetrofitError error) {
            callback.onError(error.getMessage());
          }
        });
  }
}
