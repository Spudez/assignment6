package com.example.servicesteht;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {



    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textview = findViewById(R.id.lista);


        try{
            BroadcastReceiver myrcver  = new BootReceiver();
            IntentFilter screenStateFilter = new IntentFilter();
            screenStateFilter.addAction(Intent.ACTION_SCREEN_ON);
            screenStateFilter.addAction(Intent.ACTION_SCREEN_OFF);
            registerReceiver(myrcver, screenStateFilter);
            data aika = (data) getIntent().getSerializableExtra("serialized_data");
            aika.setTime("123");
            Log.d("myTag", aika.getTime());
            String time = aika.getTime();
            onResume(time);


        }
        catch (Exception e){
            e.fillInStackTrace();
        }




    }
    public void onResume(String time){
        super.onResume();

        textview.append("\n\n"+""+time);

    }
}

