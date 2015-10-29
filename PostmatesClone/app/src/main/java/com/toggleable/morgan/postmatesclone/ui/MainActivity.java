package com.toggleable.morgan.postmatesclone.ui;

import android.content.Intent;
import android.content.IntentSender;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;
import com.toggleable.morgan.postmatesclone.R;

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!LoginActivity.isLogIn){
            showSignedOutUI();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.sign_out_button){
            onSignOutClicked();
        }else if(id == R.id.map_button) {
            goToMap();
        }

        return super.onOptionsItemSelected(item);
    }

    private void goToMap() {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

    private void onSignOutClicked() {
        //clear the default account so that googleapiclient will not automatically
        //connect in the future.
        Toast.makeText(MainActivity.this, "Testing", Toast.LENGTH_LONG).show();


        if(LoginActivity.mGoogleApiClient.isConnected()) {
            Toast.makeText(MainActivity.this, "Testing", Toast.LENGTH_LONG).show();
            Plus.AccountApi.clearDefaultAccount(LoginActivity.mGoogleApiClient);
            LoginActivity.mGoogleApiClient.disconnect();
//            LoginActivity.mGoogleApiClient.connect();
        }
        LoginActivity.mGoogleApiClient = null;
        showSignedOutUI();
    }

    private void showSignedOutUI() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }


    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
