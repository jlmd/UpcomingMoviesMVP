package com.jlmd.android.newfilmsmvp.api.mapper;

/**
 * @author jlmd
 */
public interface Mapper<From, To> {
    To map(From from);
}
