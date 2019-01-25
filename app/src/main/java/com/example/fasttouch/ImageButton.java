package com.example.fasttouch;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.util.AttributeSet;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ImageButton extends AppCompatImageView {

    private static final String LOG_TAG = ImageButton.class.getSimpleName();
    static public Timer theInterval = new Timer();


    public ImageButton(Context context, Integer tileSize) {
        super(context);

        // Set Layout params
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(tileSize, tileSize);
//        layoutParams.setMargins(20,20,20,20);
        this.setLayoutParams(layoutParams);

        // Set tag
        this.setTag("button_off");

        // Set click listener
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleClick();
            }
        });
    }

    public ImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void startInterval(){
        Random random = new Random();
        int randomTimer = random.nextInt(2000 - 1000) + 1000;

        theInterval.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                toggleLight();
            }

        },0,randomTimer);
    }

    public void stopInterval(){
        theInterval.cancel();
    }


    public void toggleLight() {
        if(this.getTag().toString().equals("button_off")){
            this.setImageResource(R.drawable.button_on);
            this.setTag("button_on");
        } else {
            this.setImageResource(R.drawable.button_off);
            this.setTag("button_off");
        }
    }

    public void handleClick(){
        if(this.getTag().toString().equals("button_off")){
            MainActivity.scoreCountDown();
        } else {
            this.setImageResource(R.drawable.button_off);
            this.setTag("button_off");
            MainActivity.scoreCountUp();
        }
    }
}
