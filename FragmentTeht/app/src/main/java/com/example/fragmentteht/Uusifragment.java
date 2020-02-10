package com.example.fragmentteht;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;



public class Uusifragment extends Fragment {

    Button button1;
    Button button2;
    TextView textview1;
    TextView textview2;
    EditText edittext1;
    EditText edittext2;

    public interface IUusiFragment {
        void onButtonPressed();
    }

    private IUusiFragment mListener;


    private final View.OnClickListener bListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button1:

                    String result = edittext1.getText().toString();
                    textview1.setText(result);
                    break;
                case R.id.button2:

                    String result2 = edittext2.getText().toString();
                    textview1.setText(result2);
                    break;
            }
        }
    };

    public Uusifragment() {
        // Required empty public constructor
    }


    public static Uusifragment newInstance() {
        Uusifragment fragment = new Uusifragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment1, container, false);
        View v2 = inflater.inflate(R.layout.fragment2, container, false);
        button1 = v.findViewById(R.id.button1);
        button2 = v2.findViewById(R.id.button2);

        v.findViewById(R.id.button1).setOnClickListener(bListener);
        v2.findViewById(R.id.button2).setOnClickListener(bListener);

        textview1 = v.findViewById(R.id.textView1);
        edittext1 = v.findViewById((R.id.edittext1));

        textview2 = v2.findViewById(R.id.textView2);
        edittext2 = v2.findViewById((R.id.edittext2));

        edittext1.setText("Testi1");
        edittext2.setText("Testi2");



        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IUusiFragment) {
            mListener = (IUusiFragment) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IUusiFragment");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



}
