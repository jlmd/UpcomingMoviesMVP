package com.jlmd.android.newfilmsmvp.api.mapper;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.Result;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Movie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Map the api model of upcoming movies to domain model
 *
 * @author jlmd
 */
public class UpcomingMoviesApiMapper implements Mapper<UpcomingMoviesResult, List<Movie>> {

    private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w185";

    @Override
    public List<Movie> map(UpcomingMoviesResult upcomingMoviesResult) {
        List<Movie> movies = new ArrayList<Movie>();

        for (Result result : upcomingMoviesResult.getResults()) {
            movies.add(mapMovie(result));
        }

        return movies;
    }

    private Movie mapMovie(Result result) {
        Movie movie = new Movie();
        movie.setTitle(result.getTitle());
        movie.setPosterImgUrl(createAbsoluteImgURL(result.getPosterPath()));
        movie.setBackdropImgUrl(createAbsoluteImgURL((String) result.getBackdropPath()));
        movie.setReleaseDate(parseReleaseDate(result.getReleaseDate()));
        movie.setAdult(result.getAdult());
        movie.setVoteAverage(result.getVoteAverage());
        movie.setVoteCount(result.getVoteCount());
        movie.setPopularity(result.getPopularity());

        return movie;
    }

    private Date parseReleaseDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    private String createAbsoluteImgURL(String relativeImgURL) {
        return IMAGE_URL + relativeImgURL;
    }
}
