package com.example.fasttouch;

import android.graphics.Color;
import android.graphics.Point;
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

    private Integer columnsCount = 4;
    private Integer rowsCount = 6;
    private Integer buttonsCount = columnsCount * (rowsCount -1);
    private Integer tileSize = 0;

    //    private Integer buttonsCount = 12;
    private ImageView[] theButtons = new ImageView[buttonsCount];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set bg color
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#393152"));

        // Set score
        score = findViewById(R.id.score_count);
        score.setText(String.valueOf(scoreCount));

        // Set layout params
        android.support.v7.widget.GridLayout gridLayout = (android.support.v7.widget.GridLayout)findViewById(R.id.grid_layout);
        gridLayout.setColumnCount(columnsCount);
        gridLayout.setRowCount(rowsCount);


        // Get columns / rows dimensions
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
//        tileSize = size.x / columnsCount - ((rowsCount * size.x / columnsCount) - size.y);
        tileSize = size.x / columnsCount;



        for (int i = 0; i < buttonsCount; i++) {
            theButtons[i] = new ImageButton(this, tileSize);
            theButtons[i].setImageResource(R.drawable.button_off);

            Log.d(LOG_TAG, "///////___________////////" +"x:"+ size.x + "y:" + size.y);

            gridLayout.addView(theButtons[i]);
        }
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

