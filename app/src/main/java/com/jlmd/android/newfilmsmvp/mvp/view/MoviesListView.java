package com.jlmd.android.newfilmsmvp.mvp.view;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import java.util.List;

/**
 * @author jlmd
 */
public interface MoviesListView extends View {

  void showLoading();

  void hideLoading();

  void renderMovies(final List<Movie> movies);
}
