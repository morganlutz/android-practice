package com.toggleable.morgan.postmatesclone.models;

import android.os.AsyncTask;

/**
 * Created by Guest on 10/29/15.
 */
public class User extends AsyncTask<Void, Void, String> {
    private String mUserName, mUserImage;

    public User(String userName, String userImage) {
        mUserName = userName;
        mUserImage = userImage;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String userName) {
        mUserName = userName;
    }

    public String getUserImage() {
        return mUserImage;
    }

    public void setUserImage(String userImage) {
        mUserImage = userImage;
    }


    @Override
    protected String doInBackground(Void... params) {
        return null;
    }
}
