package com.jlmd.android.newfilmsmvp.domain.formatter;

import android.text.format.DateFormat;
import java.util.Date;

/**
 * @author jlmd
 */
public class ReleaseDateFormatter implements Formatter<Date> {

  private static final String RELEASE_DATE_FORMAT = "dd-MM-yyyy";

  @Override
  public String format(Date date) {
    return DateFormat.format(RELEASE_DATE_FORMAT, date).toString();
  }
}
