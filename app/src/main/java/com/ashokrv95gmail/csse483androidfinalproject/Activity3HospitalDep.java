package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity3HospitalDep extends Activity{
    private NameAdapterTUDep mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        ListView listView = (ListView)findViewById(R.id.list_view);
        mAdapter = new NameAdapterTUDep(this);
        listView.setAdapter(mAdapter);
        int  index = mAdapter.mNames.indexOf("Allergy");
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                Intent myIntent = new Intent(view.getContext(), Activity3HUTDocAllergy.class);
                startActivityForResult(myIntent,1);}
                if(position == 11){
                    Intent myIntent = new Intent(view.getContext(), Activity3HUTDocGeneralSurgery.class);
                    startActivityForResult(myIntent,1);
                }
            }
        });

//        if(listView.getOnItemClickListener().toString().equals("Allergy")){
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent myIntent = new Intent(view.getContext(), Activity3HUTDocAllergy.class);
//                startActivityForResult(myIntent,1);
//            }
//        });
   //     }

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent myIntent = new Intent(view.getContext(), Activity3HospitalDep.class);
//                startActivityForResult(myIntent,1);
//            }
//        });

    }
}
