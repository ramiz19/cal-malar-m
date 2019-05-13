package com.example.akgun.final_project;

import android.content.Intent;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = (TextView) findViewById(R.id.textView2);
        Thread t = new Thread() {
            @Override
            public void run() {
                try {

                        while (!isInterrupted()) {
                            Thread.sleep(500);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Date noteTS = Calendar.getInstance().getTime();
                                    String h = String.valueOf(noteTS.getHours());
                                    String m = String.valueOf(noteTS.getMinutes());
                                    String s = String.valueOf(noteTS.getSeconds());
                                    if (noteTS.getMinutes() < 10)
                                        m = "0" + m;
                                    if (noteTS.getHours() < 10)
                                        h = "0" + h;
                                    if (noteTS.getSeconds() < 10)
                                        s = "0" + s;
                                    tv.setText("" + h + ":" + m);
                                }
                            });
                        }
                } catch (InterruptedException e) {
                }
            }
        };t.start();


        Button bCountDown= (Button) findViewById(R.id.bcountdown);
        bCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,CountdownActivity.class);
                startActivity(i);


            }
        });




        Button bBaglan= (Button) findViewById(R.id.bconnect);
        bBaglan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,BaglanActivity.class);
                startActivity(i);

            }
        });

        Button bList =(Button) findViewById(R.id.blist);
        bList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,ListActivity.class);
                startActivity(i2);
            }
        });

        Button btimer =(Button) findViewById(R.id.btimer);
        btimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3= new Intent(MainActivity.this,TimerActivity.class);
                startActivity(i3);

            }
        });





    }
}
