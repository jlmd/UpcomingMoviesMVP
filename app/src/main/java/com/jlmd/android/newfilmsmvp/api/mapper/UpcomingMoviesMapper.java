package com.jlmd.android.newfilmsmvp.api.mapper;

import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.Result;
import com.jlmd.android.newfilmsmvp.api.upcomingmovies.model.UpcomingMoviesResult;
import com.jlmd.android.newfilmsmvp.domain.model.Image;
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
public class UpcomingMoviesMapper implements Mapper<UpcomingMoviesResult, List<Movie>> {

  private static final String IMAGE_URL = "http://image.tmdb.org/t/p/w";
  private static final String RELEASE_DATE_FORMAT = "yyyy-MM-dd";
  private static final int POSTER_WIDTH_LOW = 185;
  private static final int POSTER_WIDTH_MEDIUM = 342;
  private static final int POSTER_WIDTH_HIGH = 500;
  private static final int BACKDROP_WIDTH_LOW = 300;
  private static final int BACKDROP_WIDTH_MEDIUM = 500;
  private static final int BACKDROP_WIDTH_HIGH = 780;

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
    movie.setId(result.getId());
    movie.setTitle(result.getTitle());
    movie.setPosterImage(
        mapImage(result.getPosterPath(), POSTER_WIDTH_LOW, POSTER_WIDTH_MEDIUM, POSTER_WIDTH_HIGH));
    movie.setBackdropImage(
        mapImage((String) result.getBackdropPath(), BACKDROP_WIDTH_LOW, BACKDROP_WIDTH_MEDIUM,
            BACKDROP_WIDTH_HIGH));
    movie.setReleaseDate(parseReleaseDate(result.getReleaseDate()));
    movie.setAdult(result.getAdult());
    movie.setVoteAverage(result.getVoteAverage());
    movie.setVoteCount(result.getVoteCount());
    movie.setPopularity(result.getPopularity());
    movie.setOverview(result.getOverview());
    return movie;
  }

  private Image mapImage(String imageUrl, int sizeLow, int sizeMedium, int sizeHigh) {
    Image image = new Image();
    image.setLowResolutionImgUrl(createAbsoluteImgURL(imageUrl, sizeLow));
    image.setMediumResolutionImgUrl(createAbsoluteImgURL(imageUrl, sizeMedium));
    image.setHighResolutionImgUrl(createAbsoluteImgURL(imageUrl, sizeHigh));
    return image;
  }

  private Date parseReleaseDate(String date) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RELEASE_DATE_FORMAT);
    try {
      return simpleDateFormat.parse(date);
    } catch (ParseException e) {
      return new Date();
    }
  }

  private String createAbsoluteImgURL(String relativeImgURL, int width) {
    return IMAGE_URL + width + relativeImgURL;
  }
}
