package com.example.guest.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {



    //crossfade examples
    public void fade(View view) {
        ImageView space1 = (ImageView) findViewById(R.id.space1);
        //cut size in half
        space1.animate()
                .translationXBy(1000f)
                .translationYBy(1000f)
                .rotationBy(3600)
                .setDuration(2000);


        //spin upside down. Larger the number, more spins//
//        space1.animate().rotation(180f).setDuration(2000);



        //animates off screen down. Negative # animates offscreen up
        //space1.animate().translationYBy(2000f).setDuration(2000);

        //animates to the right
//        space1.animate().translationXBy(2000f).setDuration(2000);
        //animate with negative number moves to the left
        //space1.animate().translationXBy(-2000f).setDuration(2000);

//        fade into new picture:
//        ImageView space2 = (ImageView) findViewById(R.id.space2);
//        space2.animate().alpha(1f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ImageView space1 = (ImageView) findViewById(R.id.space1);
        animates picture onto screen on start up
        space1.setTranslationX(-1000);
        */

        ImageView space1 = (ImageView) findViewById(R.id.space1);
        space1.setTranslationX(-1000f);
        space1.setTranslationY(-1000f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }
}
