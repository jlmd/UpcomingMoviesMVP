package com.jlmd.android.newfilmsmvp.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.jlmd.android.newfilmsmvp.di.AppApplication;

import butterknife.ButterKnife;

/**
 * @author jlmd
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        injectViews();
    }

    private void injectDependencies() {
        ((AppApplication) getApplicationContext()).inject(this);
    }

    private void injectViews() {
        ButterKnife.inject(this);
    }

}
