package com.toggleable.morgan.yora.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.toggleable.morgan.yora.R;


public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private View loginButton;
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.activity_login_login);
        if(loginButton != null) {
            loginButton.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View view) {
        if(view == loginButton) {
            startActivity(new Intent(this, LoginNarrowActivity.class));
        }
    }
}
