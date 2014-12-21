package com.jlmd.android.newfilmsmvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.view.MovieDetailsView;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;
import com.jlmd.android.newfilmsmvp.ui.adapter.MoviesListRecyclerAdapter;
import com.jlmd.android.newfilmsmvp.utils.Constants;
import com.melnykov.fab.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * @author jlmd
 */
public class MovieDetailsFragment extends BaseFragment implements MovieDetailsView {

    @Inject
    protected MovieDetailsPresenter movieDetails;

    @InjectView(R.id.iv_backdrop_image)
    protected ImageView ivBackDrop;
    @InjectView(R.id.tv_title)
    protected TextView tvTitle;
    @InjectView(R.id.tv_genres)
    protected TextView tvGenres;
    @InjectView(R.id.tv_description)
    protected TextView tvDescription;

    private static final String TAG = MovieDetailsFragment.class.getName();

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

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void renderMovie(Movie movie) {
        Picasso.with(getActivity().getApplicationContext())
                .load(movie.getBackdropImgUrl())
                .into(ivBackDrop);
        tvTitle.setText(movie.getTitle());
        tvGenres.setText(TextUtils.join(", ", movie.getMovieDetails().getGenres()));
        tvDescription.setText(movie.getMovieDetails().getOverview());
    }

}
