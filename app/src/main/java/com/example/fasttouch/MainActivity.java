package com.example.fasttouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // THIS IS A TEST

        imageView = findViewById(R.id.button);

    }

    public void toggleLight(View view) {
         if(imageView.getTag().toString().equals("button_off")){
            imageView.setImageResource(R.drawable.button_on);
            imageView.setTag("button_on");
        } else {
             imageView.setImageResource(R.drawable.button_off);
             imageView.setTag("button_off");
        }

        Log.d(LOG_TAG, imageView.getDrawable().toString());
        Log.d(LOG_TAG, imageView.getResources().toString());
        Log.d(LOG_TAG, imageView.getTag().toString());

    }
}
