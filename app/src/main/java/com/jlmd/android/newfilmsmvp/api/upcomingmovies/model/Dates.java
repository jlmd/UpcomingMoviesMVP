package com.jlmd.android.newfilmsmvp.api.upcomingmovies.model;

import com.google.gson.annotations.Expose;

public class Dates {

  @Expose private String minimum;
  @Expose private String maximum;

  /**
   * @return The minimum
   */
  public String getMinimum() {
    return minimum;
  }

  /**
   * @param minimum The minimum
   */
  public void setMinimum(String minimum) {
    this.minimum = minimum;
  }

  /**
   * @return The maximum
   */
  public String getMaximum() {
    return maximum;
  }

  /**
   * @param maximum The maximum
   */
  public void setMaximum(String maximum) {
    this.maximum = maximum;
  }
}
