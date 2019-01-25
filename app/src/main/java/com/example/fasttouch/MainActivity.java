package com.example.fasttouch;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private ImageView button;
    private GridLayout gridLayout;

    public static TextView score;
    public static Integer scoreCount = 0;

    public static TextView timer;
    public static Integer timerCount = 30;

    private Integer columnsCount = 4;
    private Integer rowsCount = 6;
    private Integer buttonsCount = columnsCount * (rowsCount -1);
    private Integer tileSize = 0;

    //    private Integer buttonsCount = 12;
    private ImageButton[] theButtons = new ImageButton[buttonsCount];
    private View resetButton;

    // some transient state for the activity instance
    private ArrayList <String> mGameState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initArray();
//        if (savedInstanceState != null) {
//            for (int i = 0; i < buttonsCount; i++){
//                mGameState.set(i, savedInstanceState.getString(theButtons[i].getTag().toString()));
//
//            }
//        }




        // Set bg color
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#393152"));

        // Find score and timer
        score = findViewById(R.id.score_count);
        timer = findViewById(R.id.timer_count);
        resetButton = findViewById(R.id.resetButton);

        // Set layout params
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout)findViewById(R.id.grid_layout);
        gridLayout.setColumnCount(columnsCount);
        gridLayout.setRowCount(rowsCount);


        // Get columns / rows dimensions
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        tileSize = size.x / columnsCount;
//        tileSize = size.x / columnsCount - ((rowsCount * size.x / columnsCount) - size.y);


        for (int i = 0; i < buttonsCount; i++) {
            theButtons[i] = new ImageButton(this, tileSize);
            theButtons[i].setImageResource(R.drawable.button_off);
            theButtons[i].startInterval();

            gridLayout.addView(theButtons[i]);
        }

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(Integer.toString((int) (millisUntilFinished / 1000)));
            }

            public void onFinish() {
                timer.setText("is over");

                for (int i = 0; i < buttonsCount; i++) {
                    Log.d(LOG_TAG, "JE PASSE DEDANS");
                    theButtons[i].setImageResource(R.drawable.button_off);

                    theButtons[i].stopInterval();
                    theButtons[i].setOnClickListener(null);
                }
//                resetButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void initArray(){
        mGameState = new ArrayList<>();
        for (int i =0; i>0; i++){
            mGameState.set(i, "button_off");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        for (int i = 0; i < buttonsCount; i++) {
            outState.putString(theButtons[i].getTag().toString(), theButtons[i].getTag().toString() );
            Log.d(LOG_TAG, "on save save instance ");
        }
        super.onSaveInstanceState(outState);


    }
    static public void scoreCountUp() {
        scoreCount++;
        score.setText(String.valueOf(scoreCount));
    }

    static public void scoreCountDown() {
        scoreCount--;
        score.setText(String.valueOf(scoreCount));
    }

    public void resetGame(View view) {
        Log.d(LOG_TAG, "RESET GAME");
        for ( int i = 0; i < buttonsCount; i++) {
            theButtons[i].startInterval();
//            theButtons[i].setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
////                    handleClick();
//                }
//            });
        }
    }
}

