package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.mvp.view.View;

/**
 * Presenter contains the lifecycle of the view
 *
 * @author jlmd
 */
public abstract class Presenter<T extends View> {

  protected T view;

  public void setView(T view) {
    this.view = view;
  }

  public abstract void initialize();

  public abstract void resume();

  public abstract void pause();

  public abstract void destroy();
}
