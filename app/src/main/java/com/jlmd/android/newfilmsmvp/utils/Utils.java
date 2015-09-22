package com.jlmd.android.newfilmsmvp.utils;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jlmd
 */
public final class Utils {

  private Utils() {
    // Empty private constructor
  }

  public static String loadJSONFromAsset(final Context context, final String fileName)
      throws IOException {
    String json;
    InputStream is = context.getAssets().open(fileName);
    int size = is.available();
    byte[] buffer = new byte[size];
    is.read(buffer);
    is.close();
    json = new String(buffer, "UTF-8");
    return json;
  }
}
