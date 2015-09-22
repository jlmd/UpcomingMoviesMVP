package com.jlmd.android.newfilmsmvp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

/**
 * @author jlmd
 */
public class Movie implements Parcelable {

  @SuppressWarnings("unused") public static final Parcelable.Creator<Movie> CREATOR =
      new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
          return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
          return new Movie[size];
        }
      };
  private int id;
  private String title;
  private Image posterImage;
  private Image backdropImage;
  private Date releaseDate;
  private boolean adult;
  private Double voteAverage;
  private float voteCount;
  private double popularity;
  private String overview;

  public Movie() {
    // Empty constructor
  }

  protected Movie(Parcel in) {
    id = in.readInt();
    title = in.readString();
    posterImage = (Image) in.readValue(Image.class.getClassLoader());
    backdropImage = (Image) in.readValue(Image.class.getClassLoader());
    long tmpReleaseDate = in.readLong();
    releaseDate = tmpReleaseDate != -1 ? new Date(tmpReleaseDate) : null;
    adult = in.readByte() != 0x00;
    voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
    voteCount = in.readFloat();
    popularity = in.readDouble();
    overview = in.readString();
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public boolean isAdult() {
    return adult;
  }

  public void setAdult(boolean adult) {
    this.adult = adult;
  }

  public Double getVoteAverage() {
    return voteAverage;
  }

  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }

  public float getVoteCount() {
    return voteCount;
  }

  public void setVoteCount(float voteCount) {
    this.voteCount = voteCount;
  }

  public double getPopularity() {
    return popularity;
  }

  public void setPopularity(double popularity) {
    this.popularity = popularity;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }

  public Image getPosterImage() {
    return posterImage;
  }

  public void setPosterImage(Image posterImage) {
    this.posterImage = posterImage;
  }

  public Image getBackdropImage() {
    return backdropImage;
  }

  public void setBackdropImage(Image backdropImage) {
    this.backdropImage = backdropImage;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(id);
    dest.writeString(title);
    dest.writeValue(posterImage);
    dest.writeValue(backdropImage);
    dest.writeLong(releaseDate != null ? releaseDate.getTime() : -1L);
    dest.writeByte((byte) (adult ? 0x01 : 0x00));
    if (voteAverage == null) {
      dest.writeByte((byte) (0x00));
    } else {
      dest.writeByte((byte) (0x01));
      dest.writeDouble(voteAverage);
    }
    dest.writeFloat(voteCount);
    dest.writeDouble(popularity);
    dest.writeString(overview);
  }
}