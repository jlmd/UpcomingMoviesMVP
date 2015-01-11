package com.jlmd.android.newfilmsmvp.api.mock;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.moviedetails.model.MovieDetailsResult;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;
import com.jlmd.android.newfilmsmvp.utils.Utils;


/**
 * @author jlmd
 */
public class MockedMovieDetailsApi implements MovieDetailsApi {

    private Gson gson;
    private final Mapper movieDetailsMapper;
    private final Context context;
    private static final String FILE_PATH = "mock/details/";

    public MockedMovieDetailsApi(Context context,
                                 Mapper movieDetailsMapper) {
        this.context = context;
        this.movieDetailsMapper = movieDetailsMapper;
        initGson();
    }

    private void initGson() {
        gson = new Gson();
    }

    @Override
    public void getMovieDetails(int movieId, Callback callback) {
        loadMockedMoviesDelayed(movieId, callback, 1000);
    }

    private void loadMockedMoviesDelayed(final int movieId, final Callback callback, int delay) {
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            public void run() {
                String json = Utils.loadJSONFromAsset(context, FILE_PATH + movieId + ".json");
                MovieDetails movieDetails = (MovieDetails) movieDetailsMapper.
                        map(gson.fromJson(json, MovieDetailsResult.class));
                callback.onFinish(movieDetails);
            }
        };

        handler.postDelayed(runnable, delay);
    }

}
