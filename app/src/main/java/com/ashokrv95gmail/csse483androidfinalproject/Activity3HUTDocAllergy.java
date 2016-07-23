package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity3HUTDocAllergy extends Activity{
    private NameAdapterTUDocAllergy mAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3);

        ListView listView = (ListView) findViewById(R.id.list_view);
        mAdapter = new NameAdapterTUDocAllergy(this);
        listView.setAdapter(mAdapter);
    }
}
