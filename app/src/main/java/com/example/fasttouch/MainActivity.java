package com.example.fasttouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ImageView button;
    private TextView score;
    private Integer scoreCount = 0;
    private Integer buttonsCount = 10;
    private ImageView[] theButtons = new ImageView[buttonsCount];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        score = findViewById(R.id.score_count);

        LinearLayout picLL = new LinearLayout(this);
        picLL.layout(0, 0, 100, 100);
        picLL.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
        picLL.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < buttonsCount; i++){

            theButtons[i] = new ImageView(this);
            theButtons[i].setImageResource(R.drawable.button_off);
            theButtons[i].layout(i*100, i*100,0, 0 );
            // theButtons[i].setLayoutParams(
             //        new GridLayout.LayoutParams(
               //              GridLayout.spec(0, GridLayout.FILL),
                 //            GridLayout.spec(1, GridLayout.FILL)));

            Log.d(LOG_TAG, "///////___________////////");
            Log.d(LOG_TAG, theButtons[i].toString());

            picLL.addView(theButtons[i]);


            Log.d(LOG_TAG, "the buttons: " + theButtons[i].toString());
            setContentView(picLL);
        }


    }

    public void toggleLight(View view) {
         if(button.getTag().toString().equals("button_off")){
             button.setImageResource(R.drawable.button_on);
             button.setTag("button_on");

             scoreCount ++;
        } else {
             button.setImageResource(R.drawable.button_off);
             button.setTag("button_off");

             scoreCount --;
        }


        Log.d(LOG_TAG, scoreCount.toString());
        score.setText(String.valueOf(scoreCount));
    }
}
