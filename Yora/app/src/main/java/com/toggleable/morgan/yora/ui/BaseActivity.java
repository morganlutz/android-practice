package com.toggleable.morgan.yora.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.toggleable.morgan.yora.util.App;

public abstract class BaseActivity extends AppCompatActivity {
    protected App application;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        application = (App) getApplication();
    }

}
