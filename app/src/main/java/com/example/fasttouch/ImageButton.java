package com.example.fasttouch;

import android.content.Context;
import android.os.CountDownTimer;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.util.AttributeSet;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ImageButton extends AppCompatImageView {

    private static final String LOG_TAG = ImageButton.class.getSimpleName();

    public ImageButton(Context context) {
        super(context);
//        this.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                toggleLight();
//            }
//        });

        this.setTag("button_off");

        Random random = new Random();
        int randomTimer = random.nextInt(1000 - 100) + 100;


        new Timer().scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                toggleLight();
                randomTimer = random.nextInt(1000 - 100) + 100;

            }

        },0,randomTimer);

    }

    public ImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void toggleLight() {

        if(this.getTag().toString().equals("button_off")){
            this.setImageResource(R.drawable.button_on);
            this.setTag("button_on");
//            MainActivity.scoreCountDown();
        } else {
            this.setImageResource(R.drawable.button_off);
            this.setTag("button_off");
//            MainActivity.scoreCountUp();
        }

         // Log.d(LOG_TAG, MainActivity.getScoreCount().toString());

         Log.d(LOG_TAG, "_______________" + this.getTag().toString());
    }
}
