package com.example.fragmentteht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Uusifragment.IUusiFragment  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame1, Uusifragment.newInstance())
                .add(R.id.frame2, Uusifragment.newInstance())
                .commit();


    }

    @Override
    public void onButtonPressed() {
        Toast.makeText(getApplicationContext(), "Painoit nappia", Toast.LENGTH_SHORT).show();
    }
}