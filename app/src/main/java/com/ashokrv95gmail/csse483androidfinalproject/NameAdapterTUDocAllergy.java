package com.ashokrv95gmail.csse483androidfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class NameAdapterTUDocAllergy extends BaseAdapter {
    private Context mContext;
    final ArrayList<String> mNames = new ArrayList<>();
    private Random mRandom = new Random();


    public NameAdapterTUDocAllergy(Context context){
        mContext = context;
        for(int i =0;i<2;i++){
            mNames.add(getRandomName(i));
        }
    }

    private String getRandomName(int pos){
        String[] names = new String[]{
                "Diane L. Jordan-Wagner MD", "Nagarjuna R. Ponugoti MD"

        };
        int count = names.length;
        return names[pos];
    }


    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView == null){
            //Make a view
            view = LayoutInflater.from(mContext).inflate(R.layout.hospital_view,parent,false);
        }else{
            view = convertView;
        }
        //Customize it
        String name = mNames.get(position);
        TextView positionTextView = (TextView)view.findViewById(R.id.position_view);

        switch(name) {
            case "Nagarjuna R. Ponugoti MD":
                positionTextView.setText(name);
                break;

            case "Diane L. Jordan-Wagner MD":
                positionTextView.setText(name);
                break;
            default:
                break;
        }

        return view;


    }
    public void addName(int pos){

        mNames.add(0,getRandomName(pos));
        notifyDataSetChanged();
    }
}
