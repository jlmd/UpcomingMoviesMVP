package com.jlmd.android.newfilmsmvp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;

/**
 * @author jlmd
 */
public abstract class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

  public BaseRecyclerViewHolder(View view) {
    super(view);
    ButterKnife.inject(this, view);
  }
}
