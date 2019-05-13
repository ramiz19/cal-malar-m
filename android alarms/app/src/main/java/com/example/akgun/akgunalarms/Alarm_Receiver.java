package com.example.akgun.akgunalarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by AKGUN on 2.12.2017.
 */

public class Alarm_Receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("We are in the receiver.", "Yay!");
        // fetch extra strings from the intent
        // tells the app whether the user pressed the alarm on button or the alarm off button
        String get_your_string = intent.getExtras().getString("extra");

        Log.e("What is the key? ", get_your_string);
        // fetch the extra longs from the intent
        // tells the app which value the user picked from the drop down menu/spinner
        Integer get_your_whale_choice = intent.getExtras().getInt("whale_choice");

        Log.e("The whale choice is ", get_your_whale_choice.toString());

        // create an intent to the ringtone service
        Intent service_intent = new Intent(context, RingtonePlayingService.class);
        // pass the extra string from Main Activity to the Ringtone Playing Service
        service_intent.putExtra("extra", get_your_string);

        // start the ringtone service
        context.startService(service_intent);


    }
}
