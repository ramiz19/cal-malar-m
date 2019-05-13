package com.example.akgun.final_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CountdownActivity extends AppCompatActivity implements View.OnClickListener {

    private  timers countDownTimer;
    private Long startTime=0L;
    private TextView tvTime;
    private boolean timerHasStarted =false;
    private int hour=0,min=0;
    private long minMilis,hourMilis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        Button bSet = (Button) findViewById(R.id.bSet);
        Button bReset = (Button) findViewById(R.id.bReset);
        Button bPause = (Button) findViewById(R.id.bPause);
        Button bUnset = (Button) findViewById(R.id.bUnset);
        bPause.setOnClickListener(this);

        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bSet.setOnClickListener(this);
        bUnset.setOnClickListener(this);
    }

    public void onClick(View v) {
        TextView Tvv=(TextView)findViewById(R.id.textView16);
        Tvv.setText("ssssssss");
        if (timerHasStarted==false) {   // set e basıldı; timer calısmıyor demektir timerHasStarted =1 yapıcaz

            timerHasStarted=true;
            tvTime =(TextView) findViewById(R.id.tvTime);

            EditText etHour=(EditText)findViewById(R.id.etHour);
            EditText etMin=(EditText)findViewById(R.id.etMin);


            hour=Integer.valueOf(etHour.getText().toString());////////////// saat i aldik
            min=Integer.valueOf(etMin.getText().toString());////////////////dakikayi aldık

            minMilis=60*1000*min;
            hourMilis=60*60*1000*hour;
            startTime=hourMilis+minMilis;

            countDownTimer = new timers(startTime, 1000, tvTime);
            countDownTimer.start();


        }
        else if(timerHasStarted==true) //unset e basıldı; ve timer calısıyor demektir durudurucagımız için timerHasStarted=0 yapıcaz
        {
            timerHasStarted = false;
            countDownTimer.cancel();

        }

        else
        {
            TextView tv=(TextView)findViewById(R.id.tvCount1);
            tv.setText("HATA OLUSTU YAPIMCIYA BASVURUNUZ");
        }

    }


}
