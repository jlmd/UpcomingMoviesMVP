package com.jlmd.android.newfilmsmvp.di.module;

import android.content.Context;

import com.jlmd.android.newfilmsmvp.di.AppApplication;
import com.jlmd.android.newfilmsmvp.ui.activity.MainActivity;
import com.jlmd.android.newfilmsmvp.ui.fragment.MoviesListFragment;
import com.jlmd.android.newfilmsmvp.mvp.presenter.MoviesListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author jlmd
 */

@Module(
        includes = {
                RepositoryModule.class,
                PresenterModule.class
        },
        injects = {
                AppApplication.class,
                MainActivity.class,
                MoviesListFragment.class,
                MoviesListPresenter.class
        },
        library = true
)

public class RootModule {
    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return context;
    }
}
