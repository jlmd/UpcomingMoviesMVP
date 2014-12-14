package com.jlmd.android.newfilmsmvp.api.mock;

import android.content.Context;
import android.os.Handler;

import com.google.gson.Gson;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;

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

    private static final String FILE_NAME = "upcomingmovies_mocked.json";

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
                List<Movie> movies = (List<Movie>) upcomingMoviesApiMapper.
                        map(gson.fromJson(loadJSONFromAsset(), UpcomingMoviesResult.class));
                callback.onFinish(movies);
            }
        };

        handler.postDelayed(runnable, delay);
    }

    private String loadJSONFromAsset() {
        String json;

        try {
            InputStream is = context.getAssets().open(FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }
}
