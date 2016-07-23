package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity3Hospital extends Activity {
    private NameAdapterTerreHaute mAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);
        ListView listView = (ListView)findViewById(R.id.list_view);
        mAdapter = new NameAdapterTerreHaute(this);
        listView.setAdapter(mAdapter);

    }

}
