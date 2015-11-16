package com.toggleable.morgan.yora.fragments;


import android.app.Fragment;
import android.os.Bundle;

import com.toggleable.morgan.yora.util.App;

public abstract class BaseFragment extends Fragment {
    protected App application;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        application = (App) getActivity().getApplication();
    }
}
