package com.jlmd.android.newfilmsmvp.mvp.view;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;

import java.util.List;

/**
 * @author jlmd
 */
public interface MovieDetailsView extends View {

    void showLoading();

    void hideLoading();

    void renderMovie(final MovieDetails movieDetails);
}
