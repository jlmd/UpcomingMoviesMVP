package com.jlmd.android.newfilmsmvp.api.upcomingmovies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

  @Expose private Boolean adult;
  @SerializedName("backdrop_path") @Expose private Object backdropPath;
  @Expose private Integer id;
  @SerializedName("original_title") @Expose private String originalTitle;
  @SerializedName("release_date") @Expose private String releaseDate;
  @SerializedName("poster_path") @Expose private String posterPath;
  @Expose private Double popularity;
  @Expose private String title;
  @SerializedName("vote_average") @Expose private Double voteAverage;
  @SerializedName("vote_count") @Expose private Integer voteCount;
  @Expose private String overview;

  /**
   * @return The adult
   */
  public Boolean getAdult() {
    return adult;
  }

  /**
   * @param adult The adult
   */
  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  /**
   * @return The backdropPath
   */
  public Object getBackdropPath() {
    return backdropPath;
  }

  /**
   * @param backdropPath The backdrop_path
   */
  public void setBackdropPath(Object backdropPath) {
    this.backdropPath = backdropPath;
  }

  /**
   * @return The id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id The id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return The originalTitle
   */
  public String getOriginalTitle() {
    return originalTitle;
  }

  /**
   * @param originalTitle The original_title
   */
  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  /**
   * @return The releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate The release_date
   */
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * @return The posterPath
   */
  public String getPosterPath() {
    return posterPath;
  }

  /**
   * @param posterPath The poster_path
   */
  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  /**
   * @return The popularity
   */
  public Double getPopularity() {
    return popularity;
  }

  /**
   * @param popularity The popularity
   */
  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  /**
   * @return The title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title The title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return The voteAverage
   */
  public Double getVoteAverage() {
    return voteAverage;
  }

  /**
   * @param voteAverage The vote_average
   */
  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }

  /**
   * @return The voteCount
   */
  public Integer getVoteCount() {
    return voteCount;
  }

  /**
   * @param voteCount The vote_count
   */
  public void setVoteCount(Integer voteCount) {
    this.voteCount = voteCount;
  }

  public String getOverview() {
    return overview;
  }

  public void setOverview(String overview) {
    this.overview = overview;
  }
}
