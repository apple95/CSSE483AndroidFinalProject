package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.android.gms.common.data.BitmapTeleporter;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity2FixAppointment extends Activity {
    Firebase ref = new Firebase("https://csse483androidfinalprije-63abd.firebaseio.com");
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        final EditText editText1 = (EditText) findViewById(R.id.fullname);
        final EditText editText2 = (EditText) findViewById(R.id.ssn);
        final EditText editText3 = (EditText)findViewById(R.id.mobile);
        final EditText editText4 = (EditText)findViewById(R.id.hospitalVisited);
        Button submitbutton = (Button)findViewById(R.id.register);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Firebase alanRef = ref.child("users").child("blah");
                User user = new User(editText1.getText().toString(), editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString());
                alanRef.setValue(user);

            }
        });

    }
}
