package com.example.sqliteteht;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editableText;
    private Button save;
    private TextView textview;
    public static Tietokanta tietokanta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.save = findViewById(R.id.savebutton);
        this.editableText = findViewById(R.id.edittext);
        this.textview = findViewById(R.id.lista);


        tietokanta = Room.databaseBuilder(getApplicationContext(), Tietokanta.class, Tietokanta.NIMI).allowMainThreadQueries().build();
        getdata();

        this.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date currentTime = Calendar.getInstance().getTime();
                data data = new data();
                String text = editableText.getText().toString();
                String time = currentTime.toString();
                data.setText(text);
                data.setTime(time);

                tietokanta.myTableDao().InsertMyEntity(data);
                String tostText = "Lisätty tietokantaan";
                Toast toast = Toast.makeText(getApplicationContext(), tostText , Toast.LENGTH_SHORT);
                toast.show();

                editableText.setText("");
                getdata();
            }
        });

    }

    private void getdata() {

        List<data> datat = MainActivity.tietokanta.myTableDao().getAllInDescendingOrder();
        String info = "";
        for(data dat : datat)
        {
            int id = dat.getId();
            String text = dat.getText();
            String time = dat.getTime();
            info = info+"\n\n"+"id : "+id+"\n text :"+text+"\n"+"time : "+time;

        }
        textview.setText(info);
    }

}
