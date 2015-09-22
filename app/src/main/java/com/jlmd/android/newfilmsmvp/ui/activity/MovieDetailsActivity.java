package com.jlmd.android.newfilmsmvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.ui.fragment.MovieDetailsFragment;
import com.jlmd.android.newfilmsmvp.utils.Constants;

/**
 * @author jlmd
 */
public class MovieDetailsActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_movie_details);
    initMovieDetailsFragment(getMovieFromBundle());
  }

  private Movie getMovieFromBundle() {
    return getIntent().getExtras().getParcelable(Constants.KEY_MOVIE_DETAILS);
  }

  private void initMovieDetailsFragment(Movie movie) {
    MovieDetailsFragment movieDetailsFragment = MovieDetailsFragment.newInstance(movie);
    getFragmentManager().beginTransaction()
        .replace(R.id.frm_movie_details, movieDetailsFragment)
        .disallowAddToBackStack()
        .commit();
  }
}