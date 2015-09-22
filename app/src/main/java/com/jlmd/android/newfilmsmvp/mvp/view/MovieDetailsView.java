package com.jlmd.android.newfilmsmvp.mvp.view;

import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;

/**
 * @author jlmd
 */
public interface MovieDetailsView extends View {

  void showLoading();

  void hideLoading();

  void renderMovie(final MovieDetails movieDetails);
}
