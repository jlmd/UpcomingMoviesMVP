package com.jlmd.android.newfilmsmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.jlmd.android.newfilmsmvp.di.AppApplication;

/**
 * @author jlmd
 */
public class BaseActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
  }

  private void injectDependencies() {
    ((AppApplication) getApplicationContext()).inject(this);
  }
}
