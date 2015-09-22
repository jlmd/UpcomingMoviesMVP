package com.jlmd.android.newfilmsmvp.api.moviedetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpokenLanguage {

  @SerializedName("iso_639_1") @Expose private String iso6391;
  @Expose private String name;

  /**
   * @return The iso6391
   */
  public String getIso6391() {
    return iso6391;
  }

  /**
   * @param iso6391 The iso_639_1
   */
  public void setIso6391(String iso6391) {
    this.iso6391 = iso6391;
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
}
