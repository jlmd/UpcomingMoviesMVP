package com.jlmd.android.newfilmsmvp.domain.formatter;

/**
 * @author jlmd
 */
public interface Formatter<TFrom> {

  String format(TFrom from);
}
