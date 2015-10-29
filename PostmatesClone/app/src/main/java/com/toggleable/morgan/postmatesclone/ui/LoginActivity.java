package com.toggleable.morgan.postmatesclone.ui;


import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.IntentSender;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import com.toggleable.morgan.postmatesclone.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements
        LoaderCallbacks<Cursor>,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener {

    private static final int RC_SIGN_IN = 1;
    private static final int RC_PERM_GET_ACCOUNTS = 2;
    private static final String KEY_IS_RESOLVING = "is_resolving";
    private static final String KEY_SHOULD_RESOLVE = "should_resolve";
    public static GoogleApiClient mGoogleApiClient;
    private TextView mStatus;
    private boolean mIsResolving = false;
    private boolean mShouldResolve = false;
    private static final String TAG = "LOGIN_ACTIVITY";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.sign_in_button).setOnClickListener(this);

        // Build GoogleApiClient with access to basic profile
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Plus.API)
                .addScope(new Scope(Scopes.PROFILE))
                .addScope(new Scope(Scopes.EMAIL))
                .build();

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        //could not connect to google services!
        Log.d(TAG, "onConnectionFailed: " + connectionResult);

        if(!mIsResolving && mShouldResolve) {
            if(connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(this, RC_SIGN_IN);
                    mIsResolving = true;
                } catch (IntentSender.SendIntentException e) {
                    Log.e(TAG, "Could not resolve ConnectionResult", e);
                    mIsResolving = false;
                    mGoogleApiClient.connect();
                }
            } else {
                //could not resolve connection result, show error dialogue
                showErrorDialog(connectionResult);
            }
        } else {
            //show the signed-out UI
            showSignedOutUI();
        }
    }

    private void showSignedOutUI() {

    }

    private void showErrorDialog(ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        // onConnected indicates that an account was selected on the device, that the selected
        // account has granted any requested permissions to our app and that we were able to
        // establish a service connection to Google Play services.
        Log.d(TAG, "onConnected: " + bundle);
        mShouldResolve = false;
        //show the signed-in UI

        showSignedOutUI();

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.sign_in_button) {
            onSignInClicked();
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: " + requestCode + ":" + resultCode + ":" + data);

        if(requestCode == RC_SIGN_IN) {
            //if the error resolution was not successful we should not resolve further
            if(resultCode != RESULT_OK) {
                mShouldResolve = false;
            }

            mIsResolving = false;
            mGoogleApiClient.connect();
        }
    }

    private void onSignInClicked() {
        //user clicked sign-in button, so begin the sign-in process & automatically
        //attempt to resolve any errors that occur
        mShouldResolve = true;
        mGoogleApiClient.connect();

        //show a message to the user that we are signing in
        mStatus.setText(R.string.signing_in);
    }



}

