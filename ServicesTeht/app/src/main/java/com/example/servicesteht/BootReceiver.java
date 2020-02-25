package com.example.servicesteht;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Date;


public class BootReceiver extends BroadcastReceiver {


    boolean screenOff;


    @Override
    public void onReceive(Context context, Intent intent) {
        data data = new data();

        try {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                    screenOff = true;
                    Toast.makeText(context, "kiinni", Toast.LENGTH_LONG).show();
                } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
                    screenOff = false;
                    Date currentTime = Calendar.getInstance().getTime();
                    String time = currentTime.toString();
                    data.setTime(time);
                    Toast.makeText(context, data.getTime(), Toast.LENGTH_LONG).show();
                    intent.putExtra("serialized_data", data);
                    context.startActivity(intent);

                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}