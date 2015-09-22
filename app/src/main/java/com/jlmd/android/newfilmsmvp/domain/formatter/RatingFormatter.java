package com.jlmd.android.newfilmsmvp.domain.formatter;

/**
 * @author jlmd
 */
public class RatingFormatter implements Formatter<Double> {

  private static final String RATING_SEPARATOR = "/";
  private static final String RATING_MAX_VALUE = "10";

  @Override
  public String format(Double value) {
    return value + RATING_SEPARATOR + RATING_MAX_VALUE;
  }
}
