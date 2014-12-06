package com.jlmd.android.newfilmsmvp.ui.adapter;

import android.view.View;

import butterknife.ButterKnife;

/**
 * @author jlmd
 */
public abstract class BaseViewHolder {
    public BaseViewHolder(View view) {
        ButterKnife.inject(this, view);
    }
}
