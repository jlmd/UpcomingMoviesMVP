package com.jlmd.android.newfilmsmvp.di;

import android.app.Application;
import com.jlmd.android.newfilmsmvp.di.module.RootModule;
import dagger.ObjectGraph;

/**
 * @author jlmd
 */
public class AppApplication extends Application {

  private ObjectGraph objectGraph;

  @Override
  public void onCreate() {
    super.onCreate();
    injectDependencies();
  }

  private void injectDependencies() {
    objectGraph = ObjectGraph.create(new RootModule(this));
    objectGraph.inject(this);
  }

  public void inject(Object object) {
    objectGraph.inject(object);
  }
}
