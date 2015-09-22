package com.jlmd.android.newfilmsmvp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.jlmd.android.newfilmsmvp.R;
import com.jlmd.android.newfilmsmvp.domain.formatter.RatingFormatter;
import com.jlmd.android.newfilmsmvp.domain.formatter.ReleaseDateFormatter;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;
import com.squareup.picasso.Picasso;
import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class MoviesListRecyclerAdapter
    extends RecyclerView.Adapter<MoviesListRecyclerAdapter.ViewHolder> {

  private final Context context;
  private List<Movie> movies = Collections.emptyList();

  public MoviesListRecyclerAdapter(Context context) {
    this.context = context;
  }

  public void updateItems(List<Movie> movies) {
    this.movies = movies;
    notifyDataSetChanged();
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View modelView =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
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
    String posterImage;

    if (isLandscape(viewHolder)) {
      posterImage = movie.getPosterImage().getMediumResolutionImgUrl();
      viewHolder.tvSummary.setText(movie.getOverview());
    } else {
      posterImage = movie.getPosterImage().getLowResolutionImgUrl();
    }

    Picasso.with(context).load(posterImage).into(viewHolder.ivPosterImage);

    if (movie.getVoteCount() > 0) {
      viewHolder.tvMovieRating.setText(new RatingFormatter().format(movie.getVoteAverage()));
    }

    viewHolder.tvMovieTitle.setText(movie.getTitle());
    viewHolder.movieReleaseDate.setText(new ReleaseDateFormatter().format(movie.getReleaseDate()));
  }

  private boolean isLandscape(ViewHolder viewHolder) {
    return viewHolder.tvSummary != null;
  }

  public class ViewHolder extends BaseRecyclerViewHolder {
    @InjectView(R.id.iv_poster_image) protected ImageView ivPosterImage;
    @InjectView(R.id.tv_movie_title) protected TextView tvMovieTitle;
    @InjectView(R.id.tv_movie_rating) protected TextView tvMovieRating;
    @InjectView(R.id.tv_movie_release_date) protected TextView movieReleaseDate;
    @Optional @InjectView(R.id.tv_overview) protected TextView tvSummary;

    public ViewHolder(View view) {
      super(view);
    }
  }
}
