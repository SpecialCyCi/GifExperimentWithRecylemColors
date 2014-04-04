package com.example.GifExperiment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.example.GifExperiment.R;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.io.IOException;

/**
 * User: special
 * Date: 14-4-4
 * Time: 下午6:21
 * Mail: specialcyci@gmail.com
 */
public class Activity2 extends Activity {
    private GifDrawable gifDrawable;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        try {
            gifDrawable = new GifDrawable( getAssets(), "2.gif" );
        } catch (IOException e) {
            e.printStackTrace();
        }

        ( (GifImageView) findViewById(R.id.gifView2) ).setImageDrawable(gifDrawable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gifDrawable.recycle();
    }
}