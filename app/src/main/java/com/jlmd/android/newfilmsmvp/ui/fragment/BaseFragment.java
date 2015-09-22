package com.jlmd.android.newfilmsmvp.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import butterknife.ButterKnife;
import com.jlmd.android.newfilmsmvp.di.AppApplication;

/**
 * @author jlmd
 */
public abstract class BaseFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectDependencies();
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    injectViews(view);
  }

  private void injectDependencies() {
    ((AppApplication) getActivity().getApplicationContext()).inject(this);
  }

  private void injectViews(View view) {
    ButterKnife.inject(this, view);
  }
}
