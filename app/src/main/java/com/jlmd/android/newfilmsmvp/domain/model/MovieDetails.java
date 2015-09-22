package com.jlmd.android.newfilmsmvp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jlmd
 */
public class MovieDetails implements Parcelable {

  @SuppressWarnings("unused") public static final Parcelable.Creator<MovieDetails> CREATOR =
      new Parcelable.Creator<MovieDetails>() {
        @Override
        public MovieDetails createFromParcel(Parcel in) {
          return new MovieDetails(in);
        }

        @Override
        public MovieDetails[] newArray(int size) {
          return new MovieDetails[size];
        }
      };
  private Movie movie;
  private List<String> genres = Collections.emptyList();
  private String homepage;

  public MovieDetails() {
    // Empty constructor
  }

  protected MovieDetails(Parcel in) {
    movie = (Movie) in.readValue(Movie.class.getClassLoader());
    if (in.readByte() == 0x01) {
      genres = new ArrayList<String>();
      in.readList(genres, String.class.getClassLoader());
    } else {
      genres = null;
    }
    homepage = in.readString();
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public List<String> getGenres() {
    return genres;
  }

  public void setGenres(List<String> genres) {
    this.genres = genres;
  }

  public String getHomepage() {
    return homepage;
  }

  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(movie);
    if (genres == null) {
      dest.writeByte((byte) (0x00));
    } else {
      dest.writeByte((byte) (0x01));
      dest.writeList(genres);
    }
    dest.writeString(homepage);
  }
}