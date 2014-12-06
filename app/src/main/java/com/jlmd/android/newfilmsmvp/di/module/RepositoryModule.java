package com.jlmd.android.newfilmsmvp.di.module;

import android.content.Context;

import com.jlmd.android.newfilmsmvp.api.mock.MockedUpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;
import com.jlmd.android.newfilmsmvp.api.mapper.UpcomingMoviesApiMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jlmd
 */
@Module(
        complete = false,
        library = true
)
public class RepositoryModule {

    @Provides
    @Singleton
    public Mapper providesUpcomingMoviesApiMapper() {
        return new UpcomingMoviesApiMapper();
    }

    @Provides
    @Singleton
    public UpcomingMoviesApi providesUpComingMoviesApi(final Context context, final Mapper mapper) {
        return new MockedUpcomingMoviesApi(context, mapper);
    }

}
