package com.example.GifExperiment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

import java.io.IOException;

public class Activity1 extends Activity {

    private GifDrawable gifDrawable;
    private Activity1 mContext;
    private GifImageView gifImageView;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity1);

        mContext = this;

        try {
            gifDrawable = new GifDrawable( getAssets(), "1.gif" );
        } catch (IOException e) {
            e.printStackTrace();
        }

        gifImageView = ((GifImageView) findViewById(R.id.gifView1));
        gifImageView.setImageDrawable(gifDrawable);

        findViewById(R.id.buttonStartActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gifImageView.setImageDrawable(null);
                gifDrawable.recycle();
                Intent intent = new Intent(mContext, Activity2.class);
                mContext.finish();
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        gifDrawable.recycle();
    }
}
