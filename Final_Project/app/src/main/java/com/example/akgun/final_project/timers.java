package com.example.akgun.final_project;
import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * Created by AKGUN on 11.12.2017.
 */

public class timers extends CountDownTimer {


    public TextView our;
    public long timeElapsed;
    public long startTime;

    public timers(long startTime, long s, TextView Our) {
        super(startTime, s);
        this.our = Our;
        this.startTime=startTime;
    }



    public void onTick(long millisUntilFinished) {

        long s=millisUntilFinished/(60*1000);
        long ss=millisUntilFinished/(1000);
        our.setText("" + millisUntilFinished/(1000*60*60)+":"+s%(60)+":"+ss%60);
        timeElapsed = startTime - millisUntilFinished;

    }

    @Override
    public void onFinish() {
        our.setText("Süre Doldu!!!");


    }

}
