package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.api.mapper.MovieDetailsMapper;
import com.jlmd.android.newfilmsmvp.api.mapper.UpcomingMoviesMapper;
import com.jlmd.android.newfilmsmvp.api.moviedetails.MovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.retrofit.moviedetails.RetrofitMovieDetailsApi;
import com.jlmd.android.newfilmsmvp.api.retrofit.upcomingmovies.RetrofitUpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.UpcomingMoviesApi;
import com.jlmd.android.newfilmsmvp.api.mapper.Mapper;

import javax.inject.Named;
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
    @Named("upcomingmovies")
    @Singleton
    public Mapper providesUpcomingMoviesMapper() {
        return new UpcomingMoviesMapper();
    }

    @Provides
    @Named("moviedetails")
    @Singleton
    public Mapper providesMovieDetailsMapper() {
        return new MovieDetailsMapper();
    }

    @Provides
    @Singleton
    public UpcomingMoviesApi providesUpcomingMoviesApi(@Named("upcomingmovies")
                                                           final Mapper mapper) {
        return new RetrofitUpcomingMoviesApi(mapper);
    }

    @Provides
    @Singleton
    public MovieDetailsApi providesMovieDetailsApi(@Named("moviedetails")
                                                       final Mapper mapper) {
        return new RetrofitMovieDetailsApi(mapper);
    }

}
