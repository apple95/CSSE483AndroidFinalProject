package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                final EditText edit = (EditText)findViewById(R.id.dialog_add_zip);
                if(edit.getText().toString().equals("47803")||edit.getText().toString().equals("47802")||edit.getText().toString().equals("47804")||edit.getText().toString().equals("47801")||edit.getText().toString().equals("47809")||edit.getText().toString().equals("47811")
                        ||edit.getText().toString().equals("47812")||edit.getText().toString().equals("47805")||edit.getText().toString().equals("47807")||edit.getText().toString().equals("47808")){
                Intent myIntent = new Intent(v.getContext(), Activity3TerreHauteHospital.class);
                startActivityForResult(myIntent,1);}
            }
        });



        }

}
