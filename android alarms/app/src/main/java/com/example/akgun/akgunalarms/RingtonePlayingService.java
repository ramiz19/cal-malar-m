package com.example.akgun.akgunalarms;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;
import java.security.Provider;

import java.util.Random;


public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flag ,int startId){

       // Log.e("localservice---","reveived start id :"+startId+" :  "+intent);
        String state =intent.getExtras().getString("extra");
       // Log.e("ringstone state extra:",state);
        int alarm_sound=intent.getExtras().getInt("alarm_sound");


        NotificationManager notify_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // set up an intent that goes to the Main Activity
        Intent intent_main_activity = new Intent(this.getApplicationContext(), MainActivity.class);
        // set up a pending intent
        PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0,
                intent_main_activity, 0);

        // make the notification parameters
        Notification notification_popup = new Notification.Builder(this)
                .setContentTitle("An alarm is going off!")
                .setContentText("Click me!")
                .setContentIntent(pending_intent_main_activity)
                .setAutoCancel(true)
                .build();

        /*

        Log.e("ringstone state extra:",state);
        Log.e("alarm sound:",String.valueOf(alarm_sound));

*/

        /*FAIL
            NotificationManager notify_manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

            Intent intent_main_activity = new Intent(this.getApplicationContext(),MainActivity.class);

            PendingIntent pending_intent_main_activity= PendingIntent.getActivity(this,0,intent_main_activity,0);

            Notification notification=new Notification.Builder(this)
                    .setContentTitle("An Alarm Going Off!!")
                    .setContentText("clickme")
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .build();

                bu satırsonras


        */

        assert state != null;
        switch (state){
            case "alarm on":
                startId=1;
                break;
            case "alarm off":
                startId=0;
                break;
            default:
                startId=0;
                break;
        }

        if(!this.isRunning && startId==1){
            Log.e("no musıc","alarm on");
            this.isRunning=true;
            this.startId=0;

            //notify_manager.notify(0,notification);


            if(alarm_sound==0) {

                int minnum = 1;
                int maxnum = 8;
                Random rand = new Random();
                int alarm_numberr = rand.nextInt(maxnum + minnum);

                alarm_sound = alarm_numberr;
            }


            if(alarm_sound==1){
                media_song=MediaPlayer.create(this,R.raw.dove);
                media_song.start();
            }
            else if(alarm_sound==2){
                media_song=MediaPlayer.create(this,R.raw.linking);
                media_song.start();
            }
            else if(alarm_sound==3){
                media_song=MediaPlayer.create(this,R.raw.manus);
                media_song.start();
            }
            else if(alarm_sound==4){
                media_song=MediaPlayer.create(this,R.raw.rebirt);
                media_song.start();
            }
            else if(alarm_sound==5){
                media_song=MediaPlayer.create(this,R.raw.sapka);
                media_song.start();
            }
            else if(alarm_sound==6){
                media_song=MediaPlayer.create(this,R.raw.skillet);
                media_song.start();
            }
            else if(alarm_sound==7){
                media_song=MediaPlayer.create(this,R.raw.taylor);
                media_song.start();
            }
            else{
                media_song=MediaPlayer.create(this,R.raw.baba);
                media_song.start();
            }


        }
        else if(isRunning && startId==0){
            Log.e(" yes musıc","alarm off");
            media_song.stop();
            media_song.reset();
            this.isRunning=false;
            this.startId=0;

        }
        else if(!this.isRunning && startId==0){
            Log.e("no musıc","alarm off");
            this.isRunning=false;
            this.startId=0;
        }
        else if(this.isRunning && startId==1){
            Log.e("yes musıc","alarm on");
            this.isRunning=true;
            this.startId=1;
        }
        else{

            Log.e("else","else d ");
        }





        return START_NOT_STICKY;

    }


    public void onDestroy(){
        Log.e("destroyy","ta daa");
        super.onDestroy();
        //this.isRunning=false;

    }


}
