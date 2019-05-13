package com.example.akgun.akgunalarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //to make our alarm manager
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;
    int choose_whale_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context=this;

        alarm_manager=(AlarmManager) getSystemService(ALARM_SERVICE);

        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        //initialize our text update box
        update_text = (TextView) findViewById(R.id.update_text);
        // create an instance of a calendar
        final Calendar calendar = Calendar.getInstance();
        // create an intent to the Alarm Receiver class
        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);





        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.alarm_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setOnItemSelectedListener(this);


        final Button alarm_iptal =(Button)findViewById(R.id.alarm_iptal);
        final Button alarm_kur =(Button)findViewById(R.id.alarm_kur);

        alarm_kur.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                    calendar.set(calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                    calendar.set(calendar.MINUTE, alarm_timepicker.getMinute());


                    int hour = alarm_timepicker.getHour();


                    int min = alarm_timepicker.getMinute();


                    String hour_str = String.valueOf(hour);
                    String min_str = String.valueOf(min);


                    if (hour > 12) {
                        hour_str = String.valueOf(hour - 12);
                    }
                    if (min < 10) {
                        min_str = "" + String.valueOf(hour);
                    }

                    set_alarm_text("Alarm " + hour_str + ":" + alarm_timepicker.getMinute() + " kuruldu");


                    my_intent.putExtra("extra", "alarm on");

                    my_intent.putExtra("whale_choice", choose_whale_sound);
                    Log.e("The whale id is" , String.valueOf(choose_whale_sound));


                    pending_intent = PendingIntent.getBroadcast(MainActivity.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                    alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);


                }
        });



        alarm_iptal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // method that changes the update text Textbox
                set_alarm_text("Alarm off!");
                // cancel the alarm
                alarm_manager.cancel(pending_intent);
                // put extra string into my_intent
                // tells the clock that you pressed the "alarm off" button
                my_intent.putExtra("extra", "alarm off");
                // also put an extra int into the alarm off section
                // to prevent crashes in a Null Pointer Exception
                my_intent.putExtra("whale_choice", choose_whale_sound);

                // stop the ringtone
                sendBroadcast(my_intent);

            }
        });



    }
///////////////////////////////////////////////////////////////////////////////////
    private void set_alarm_text(String str) {

        update_text.setText(str);

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


       // Toast.makeText(parent.getContext(),"the spinners item "+ id,Toast.LENGTH_SHORT).show();

        choose_whale_sound = (int) id;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
