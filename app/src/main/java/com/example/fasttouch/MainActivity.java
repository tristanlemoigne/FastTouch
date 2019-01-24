package com.example.fasttouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ImageView button;
    private TextView score;
    private Integer scoreCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        score = findViewById(R.id.score_count);
    }

    public void toggleLight(View view) {
         if(button.getTag().toString().equals("button_off")){
             button.setImageResource(R.drawable.button_on);
             button.setTag("button_on");

             scoreCount = scoreCount + 1;

        } else {
             button.setImageResource(R.drawable.button_off);
             button.setTag("button_off");

             scoreCount = scoreCount - 1;
        }


        Log.d(LOG_TAG, scoreCount.toString());
        score.setText(scoreCount);
    }
}
