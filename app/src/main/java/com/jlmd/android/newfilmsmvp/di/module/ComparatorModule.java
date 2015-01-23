package com.jlmd.android.newfilmsmvp.di.module;

import com.jlmd.android.newfilmsmvp.domain.comparator.MovieDateComparator;
import com.jlmd.android.newfilmsmvp.domain.comparator.MovieTitleComparator;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;

import java.util.Comparator;

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
public class ComparatorModule {

    @Provides
    @Named("date")
    @Singleton
    Comparator<Movie> providesMovieDateComparator() {
        return new MovieDateComparator();
    }

    @Provides
    @Named("title")
    @Singleton
    Comparator<Movie> providesMovieTitleComparator() {
        return new MovieTitleComparator();
    }
}
