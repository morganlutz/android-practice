package com.toggleable.morgan.yora.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.toggleable.morgan.yora.R;

public class LoginFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        //layout you want to inflate, parent (provided by android), false because you do not want
        //to attach to root, or the view will inflate twice.
        View view = inflater.inflate(R.layout.fragment_login, root, false);
        //do not create and return in the same line if you are going to reference it elsewhere
        return view;
    }
}
