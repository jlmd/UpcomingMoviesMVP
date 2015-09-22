package com.jlmd.android.newfilmsmvp.api.moviedetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductionCountry {

  @SerializedName("iso_3166_1") @Expose private String iso31661;
  @Expose private String name;

  /**
   * @return The iso31661
   */
  public String getIso31661() {
    return iso31661;
  }

  /**
   * @param iso31661 The iso_3166_1
   */
  public void setIso31661(String iso31661) {
    this.iso31661 = iso31661;
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
