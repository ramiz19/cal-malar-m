package com.example.akgun.final_project;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    private Button startButton;
    private Button pauseButton;
    private Button resetButton;
    private TextView timerValue ,timerValue2;
    private long baslangic = 0L;
    private long sifir = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timerValue = (TextView) findViewById(R.id.timerValue);

/*
        resetButton=(Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                timeSwapBuff =timeSwapBuff+ timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);

            }
        });

        */

        startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                baslangic = SystemClock.uptimeMillis();
                timerValue2 = (TextView) findViewById(R.id.textView6);
                timerValue2.setText(""+SystemClock.uptimeMillis()+"");
                customHandler.postDelayed(updateTimerThread, 0);


            }

        });

        pauseButton = (Button) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                timeSwapBuff =timeSwapBuff + timeInMilliseconds;
                customHandler.removeCallbacks(updateTimerThread);
                }
        });




    }


    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - baslangic;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds));
            customHandler.postDelayed(this, 0);
        }
    };
}

