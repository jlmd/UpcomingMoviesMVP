package com.jlmd.android.newfilmsmvp.api.mock;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.utils.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author jlmd
 */
public class MockedUpcomingMoviesApi implements UpcomingMoviesApi {

    private Gson gson;
    private final Mapper upcomingMoviesApiMapper;
    private final Context context;
    private static final String FILE_NAME = "mock/upcoming/upcomingmovies.json";

    public MockedUpcomingMoviesApi(Context context,
                                   Mapper upcomingMoviesApiMapper) {
        this.context = context;
        this.upcomingMoviesApiMapper = upcomingMoviesApiMapper;
        initGson();
    }

    private void initGson() {
        gson = new Gson();
    }

    @Override
    public void getUpcomingMovies(Callback callback) {
        loadMockedMoviesDelayed(callback, 1000);
    }

    private void loadMockedMoviesDelayed(final Callback callback, int delay) {
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            public void run() {
                String json = Utils.loadJSONFromAsset(context, FILE_NAME);
                List<Movie> movies = (List<Movie>) upcomingMoviesApiMapper.
                        map(gson.fromJson(json, UpcomingMoviesResult.class));
                callback.onFinish(movies);
            }
        };

        handler.postDelayed(runnable, delay);
    }

}
