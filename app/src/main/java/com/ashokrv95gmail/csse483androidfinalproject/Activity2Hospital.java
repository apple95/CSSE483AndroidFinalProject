package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity2Hospital extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        Button button1 = (Button)findViewById(R.id.ok_button_view);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity3Hospital.class);
                startActivityForResult(myIntent,1);
            }
        });



        }

}
