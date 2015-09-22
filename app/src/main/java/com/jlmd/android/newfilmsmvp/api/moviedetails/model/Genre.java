package com.jlmd.android.newfilmsmvp.api.moviedetails.model;

import com.google.gson.annotations.Expose;

public class Genre {

  @Expose private Integer id;
  @Expose private String name;

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
}
