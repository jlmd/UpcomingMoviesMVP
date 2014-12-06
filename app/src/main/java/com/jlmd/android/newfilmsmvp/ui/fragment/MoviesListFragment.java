package com.jlmd.android.newfilmsmvp.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;
import com.jlmd.android.newfilmsmvp.mvp.view.MoviesListView;
import com.jlmd.android.newfilmsmvp.ui.adapter.MoviesListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

/**
 * @author jlmd
 */
public class MoviesListFragment extends BaseFragment implements MoviesListView {

    @Inject
    protected MoviesListPresenter moviesListPresenter;

    @InjectView(R.id.moviesListView)
    protected ListView moviesListView;

    private MoviesListAdapter moviesListAdapter;
    private static final String TAG = MoviesListFragment.class.getName();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initMoviesListView();
        initPresenter();
    }

    private void initPresenter() {
        moviesListPresenter.setView(this);
        moviesListPresenter.initialize();
    }

    private void initMoviesListView() {
        moviesListAdapter = new MoviesListAdapter(getActivity().getApplicationContext());
        moviesListView.setAdapter(moviesListAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies_list, container, false);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void renderMovies(List<Movie> movies) {
        Log.i(TAG, "Movies loaded: " + movies);
        moviesListAdapter.updateItems(movies);
    }
}
