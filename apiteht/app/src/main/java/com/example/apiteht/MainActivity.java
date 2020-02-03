package com.example.apiteht;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private RequestQueue mQueue;

    private ListView lvProduct;
    private CustomListAdapter adapter;
    private List<data> mProductList;
    private Button addlist;
    private ProgressDialog pDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.listaViewi);


        mProductList = new ArrayList<>();


        mQueue = Volley.newRequestQueue(this);

       // mProductList.add(new data(1, 1, "Kissa", "Koira"));
        //mProductList.add(new data(2, 1, "Katti", "Kassi"));


        //Init adapter
        adapter = new CustomListAdapter(getApplicationContext(), mProductList);
        lvProduct.setAdapter(adapter);

        lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //Ex: display msg with product id get from view.getTag
                Toast.makeText(getApplicationContext(), "Clicked product id =" + view.getTag(), Toast.LENGTH_SHORT).show();
            }
        });


        //Populoi lista
        this.addlist = findViewById(R.id.addlist);

        this.addlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loadList();

            }
        });

    }

    private void jsonParse() {

        String url = "https://jsonplaceholder.typicode.com/posts";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {



                        try {
                            JSONArray jsonArray = response.getJSONArray("employees");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                int userId = employee.getInt("userId");
                                int id = employee.getInt("id");
                                String title = employee.getString("title");
                                String body = employee.getString("body");



                                //mProductList.add(new data(id ,userId,title, body));


                               // mTextViewResult.append(firstName + ", " + String.valueOf(age) + ", " + mail + "\n\n");
                            }
                        } catch (JSONException e) {
                            adapter = new CustomListAdapter(getApplicationContext(), mProductList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }

    private void loadList() {
        String JSON_URL = "https://jsonplaceholder.typicode.com/posts";
        //creating a string request to send request to the url
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //hiding the progressbar after completion and showing list view
                        // Showing json data in log monitor
                        Log.d("json", response.toString());
                        try {
                            //we have the array named hero inside the object
                            //so here we are getting that json array
                            JSONArray jsonArray = response.getJSONArray("data");
                            //now looping through all the elements of the json array
                            for (int i = 0; i < jsonArray.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //creating a hero object and giving them the values from json object
                                data item = new data();
                                item.setuserId(jsonObject.getInt("userId"));
                                item.setId(jsonObject.getInt("id"));
                                item.setTitle(jsonObject.getString("title"));
                                item.setBody(jsonObject.getString("body"));

                                //adding the json data to list
                                mProductList.add(item);
                            }
                            //creating custom adapter object
                            CustomListAdapter mAdapter = new CustomListAdapter(getApplicationContext(), mProductList);
                            //adding the adapter to list view
                            lvProduct.setAdapter(mAdapter);
                            mAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurred
                        Log.e(error.getMessage(), "ERROR onStart()");

                    }
                });
        //adding the string request to request queue
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}
