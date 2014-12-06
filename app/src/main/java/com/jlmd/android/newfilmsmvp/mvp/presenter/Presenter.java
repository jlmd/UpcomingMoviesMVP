package com.jlmd.android.newfilmsmvp.mvp.presenter;

import com.jlmd.android.newfilmsmvp.mvp.view.View;

/**
 * The presenter contains the lifecycle of the view
 *
 * @author jlmd
 */
public abstract class Presenter<T extends View> {

    protected T view;

    public void setView(T view) {
        this.view = view;
    }

    protected abstract void initialize();

    protected abstract void resume();

    protected abstract void pause();

    protected abstract void destroy();
}
