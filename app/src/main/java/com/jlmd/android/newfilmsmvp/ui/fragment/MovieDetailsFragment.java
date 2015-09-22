package com.jlmd.android.newfilmsmvp.ui.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.formatter.GenresFormatter;
import com.jlmd.android.newfilmsmvp.domain.model.Image;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.domain.model.MovieDetails;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.mvp.view.MovieDetailsView;
import com.jlmd.android.newfilmsmvp.utils.Constants;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * @author jlmd
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

  private static final String TAG = MovieDetailsFragment.class.getName();
  @Inject protected MovieDetailsPresenter movieDetails;
  @InjectView(R.id.iv_backdrop_image) protected ImageView ivBackDrop;
  @InjectView(R.id.tv_title) protected TextView tvTitle;
  @InjectView(R.id.tv_genres) protected TextView tvGenres;
  @InjectView(R.id.tv_description) protected TextView tvDescription;

  public static MovieDetailsFragment newInstance(Movie movie) {
    MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(Constants.KEY_MOVIE_DETAILS, movie);
    movieDetailsFragment.setArguments(bundle);
    return movieDetailsFragment;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initPresenter();
    movieDetails.onMovieReceive(getMovie());
  }

  private void initPresenter() {
    movieDetails.setView(this);
    movieDetails.initialize();
  }

  private Movie getMovie() {
    return getArguments().getParcelable(Constants.KEY_MOVIE_DETAILS);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_movie_details, container, false);
  }

  @Override
  public void showLoading() {
    // Empty
  }

  @Override
  public void hideLoading() {
    // Empty
  }

  @Override
  public void renderMovie(MovieDetails movieDetails) {
    Picasso.with(getActivity().getApplicationContext())
        .load(getImageUrl(movieDetails.getMovie().getBackdropImage()))
        .into(ivBackDrop);
    tvTitle.setText(movieDetails.getMovie().getTitle());
    tvGenres.setText(new GenresFormatter().format(movieDetails.getGenres()));
    tvDescription.setText(movieDetails.getMovie().getOverview());
  }

  private String getImageUrl(Image image) {
    return isLandscape() ? image.getHighResolutionImgUrl() : image.getLowResolutionImgUrl();
  }

  private boolean isLandscape() {
    return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
  }
}
