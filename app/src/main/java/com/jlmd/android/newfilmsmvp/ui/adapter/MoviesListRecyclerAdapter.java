package com.jlmd.android.newfilmsmvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

import butterknife.InjectView;

/**
 * @author jlmd
 */
public class MoviesListRecyclerAdapter extends RecyclerView.Adapter<MoviesListRecyclerAdapter.ViewHolder> {

    private List<Movie> movies = Collections.emptyList();
    private final Context context;
    private static final String RELEASE_DATE_FORMAT = "dd-MM-yyyy";
    private static final String RATING_SEPARATOR = "/";
    private static final String RATING_MAX_VALUE = "10";

    public MoviesListRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updateItems(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View modelView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item,
                viewGroup, false);
        return new ViewHolder(modelView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Movie movie = movies.get(i);
        renderMovieView(movie, viewHolder);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    private void renderMovieView(Movie movie, ViewHolder viewHolder) {
        Picasso.with(context)
                .load(movie.getPosterImgUrl())
                .into(viewHolder.posterImage);

        if (movie.getVoteCount() > 0) {
            viewHolder.movieRating.setText(movie.getVoteAverage() + RATING_SEPARATOR +
                    RATING_MAX_VALUE);
        }

        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.movieReleaseDate.setText(DateFormat.format(RELEASE_DATE_FORMAT,
                movie.getReleaseDate()).toString());
    }

    public class ViewHolder extends BaseRecyclerViewHolder {
        @InjectView(R.id.moviePosterImage)
        protected ImageView posterImage;

        @InjectView(R.id.movieTitle)
        protected TextView movieTitle;

        @InjectView(R.id.movieRating)
        protected TextView movieRating;

        @InjectView(R.id.movieReleaseDate)
        protected TextView movieReleaseDate;

        public ViewHolder(View view) {
            super(view);
        }
    }
}
