package com.example.apiteht;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by NgocTri on 11/15/2015.
 */
public class CustomListAdapter extends BaseAdapter {

    private Context mContext;
    private List<data> mProductList;

    //Constructor

    public CustomListAdapter(Context mContext, List<data> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.customlistview, null);
        TextView title = v.findViewById(R.id.title);
        TextView body = v.findViewById(R.id.body);
        //Set text for TextView
        title.setText(mProductList.get(position).getTitle());
        body.setText(mProductList.get(position).getBody());

        //Save product id to tag
        v.setTag(mProductList.get(position).getId());

        return v;
    }
}

