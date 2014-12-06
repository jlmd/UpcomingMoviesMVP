package com.jlmd.android.newfilmsmvp.ui.adapter;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
public class MoviesListAdapter extends BaseAdapter {

    private List<Movie> movies = Collections.emptyList();
    private final Context context;
    private static final String RELEASE_DATE_FORMAT = "dd-MM-yyyy";

    public MoviesListAdapter(Context context) {
        this.context = context;
    }

    public void updateItems(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.movie_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Movie movie = (Movie) getItem(position);

        renderMovieView(movie, viewHolder);

        return convertView;
    }

    private void renderMovieView(Movie movie, ViewHolder viewHolder) {
        viewHolder.movieTitle.setText(movie.getTitle());
        Picasso.with(context)
                .load(movie.getPosterImgUrl())
                .into(viewHolder.posterImage);
        viewHolder.movieReleaseDate.setText(DateFormat.format(RELEASE_DATE_FORMAT,
                movie.getReleaseDate()));
    }

    protected static class ViewHolder extends BaseViewHolder {
        @InjectView(R.id.moviePosterImage)
        protected ImageView posterImage;

        @InjectView(R.id.movieTitle)
        protected TextView movieTitle;

        @InjectView(R.id.movieReleaseDate)
        protected TextView movieReleaseDate;

        public ViewHolder(View view) {
            super(view);
        }
    }
}
