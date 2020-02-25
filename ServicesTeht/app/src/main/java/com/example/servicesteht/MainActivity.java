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

    data aika = new data();
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
            Intent i= getIntent();
            aika = (data) i.getSerializableExtra("serialized_data");
            //Toast.makeText(getApplicationContext(), aika.getTime(), Toast.LENGTH_LONG).show();


        }
        catch (Exception e){
            e.fillInStackTrace();
        }




    }
    @Override
    public void onResume(){
        super.onResume();
        // Tuon aika objektin tuominen getIntentillä ei toimi, tulee vaan null. ja kaataa ohjelman

           // String time = aika.getTime();
           // Toast.makeText(getApplicationContext(), time, Toast.LENGTH_LONG).show();
          //  textview.append("\n\n"+""+time);

    }
}

