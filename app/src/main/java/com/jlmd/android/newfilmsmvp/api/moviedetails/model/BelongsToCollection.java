package com.jlmd.android.newfilmsmvp.api.moviedetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BelongsToCollection {

  @Expose private Integer id;
  @Expose private String name;
  @SerializedName("poster_path") @Expose private String posterPath;
  @SerializedName("backdrop_path") @Expose private String backdropPath;

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
   * @return The name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name The name
   */
  public void setName(String name) {
    this.name = name;
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
   * @return The backdropPath
   */
  public String getBackdropPath() {
    return backdropPath;
  }

  /**
   * @param backdropPath The backdrop_path
   */
  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }
}
