package com.jlmd.android.newfilmsmvp.bus.event;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;

/**
 * @author jlmd
 */
public class ItemSelectedEvent {

    private final Movie movie;

    public ItemSelectedEvent(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
