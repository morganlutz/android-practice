package com.toggleable.morgan.yora.util;


import android.app.Application;

import com.toggleable.morgan.yora.models.Auth;

//Singleton design pattern

public class App extends Application {
    private Auth auth;

    @Override
    public void onCreate() {
        super.onCreate();
        auth = new Auth(this);
    }

    public Auth getAuth() {
        return auth;
    }
}
