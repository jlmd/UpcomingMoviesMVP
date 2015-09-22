package com.jlmd.android.newfilmsmvp.domain.formatter;

import android.text.TextUtils;
import java.util.List;

/**
 * @author jlmd
 */
public class GenresFormatter implements Formatter<List<String>> {

  private static final String GENRES_SEPARATOR = ", ";

  @Override
  public String format(List<String> strings) {
    return TextUtils.join(GENRES_SEPARATOR, strings);
  }
}
