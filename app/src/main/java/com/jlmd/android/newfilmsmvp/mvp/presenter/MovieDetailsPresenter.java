package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.view.MovieDetailsView;

/**
 * @author jlmd
 */
public abstract class MovieDetailsPresenter extends Presenter<MovieDetailsView> {

  public abstract void onMovieReceive(Movie movie);
}
