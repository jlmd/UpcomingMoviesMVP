package com.jlmd.android.newfilmsmvp.domain.model;

import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class MovieDetails {
    private List<String> genres = Collections.emptyList();
    private String homepage;
    private String overview;

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
