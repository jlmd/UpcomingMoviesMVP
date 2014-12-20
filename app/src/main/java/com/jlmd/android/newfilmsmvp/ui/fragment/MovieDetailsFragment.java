package com.jlmd.android.newfilmsmvp.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MovieDetailsPresenter;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.view.MovieDetailsView;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;
import com.jlmd.android.newfilmsmvp.ui.adapter.MoviesListRecyclerAdapter;
import com.jlmd.android.newfilmsmvp.utils.Constants;
import com.melnykov.fab.FloatingActionButton;

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

    private Movie movie;
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
        initMovie();
    }

    private void initPresenter() {
        movieDetails.setView(this);
        movieDetails.initialize();
    }

    private void initMovie() {
        movie = getArguments().getParcelable(Constants.KEY_MOVIE_DETAILS);
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

    }

}
