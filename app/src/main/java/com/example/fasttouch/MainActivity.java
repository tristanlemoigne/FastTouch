package com.example.fasttouch;

import android.support.constraint.ConstraintSet;
import android.support.v4.widget.ImageViewCompat;
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
    public static Integer scoreCount = 0;
    private Integer buttonsCount = 24;
    private ImageView[] theButtons = new ImageView[buttonsCount];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        score = findViewById(R.id.score_count);

        GridLayout picGL = new GridLayout(this);
        picGL.setAlignmentMode(GridLayout.ALIGN_BOUNDS);
        picGL.setColumnCount(4);
        picGL.setRowCount(3);

//        ConstraintSet set = new ConstraintSet();
//        set.connect(picGL.getId(), ConstraintSet.TOP,
//                ConstraintSet.PARENT_ID, ConstraintSet.TOP, 70);
//        set.applyTo(picGL);

        // picGL.setLayoutParams(new GridLayout.LayoutParams(GridLayout.spec(1),GridLayout.spec(1)));

//        picLL.layout(0, 0, 100, 100);
//        picLL.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
//        picLL.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < buttonsCount; i++) {

            theButtons[i] = new ImageButton(this);
            theButtons[i].setImageResource(R.drawable.button_off);
            theButtons[i].layout(i * 100, i * 100, 0, 0);


            Log.d(LOG_TAG, "///////___________////////");
            Log.d(LOG_TAG, theButtons[i].toString());

            picGL.addView(theButtons[i]);


            Log.d(LOG_TAG, "the buttons: " + theButtons[i].toString());
            setContentView(picGL);
        }

        score.setText(String.valueOf(scoreCount));
    }

    static public void scoreCountUp()

    {
        scoreCount++;
    }

    static public void scoreCountDown()

    {
        scoreCount--;
    }

//    public Integer getScoreCount() {
//        return scoreCount;
//    }
//
//    public static void setScoreCount(Integer scoreCount) {
//        MainActivity.scoreCount = scoreCount;
//    }
}

