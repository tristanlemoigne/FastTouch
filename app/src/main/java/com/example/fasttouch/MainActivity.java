package com.example.fasttouch;

import android.graphics.Color;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintSet;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set bg color
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#393152"));

        // Find score and timer
        score = findViewById(R.id.score_count);
        timer = findViewById(R.id.timer_count);

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
            }
        }.start();
    }

    static public void scoreCountUp() {
        scoreCount++;
        score.setText(String.valueOf(scoreCount));
    }

    static public void scoreCountDown() {
        scoreCount--;
        score.setText(String.valueOf(scoreCount));
    }
}

