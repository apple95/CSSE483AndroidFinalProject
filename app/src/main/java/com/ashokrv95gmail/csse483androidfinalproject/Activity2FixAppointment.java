package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class Activity2FixAppointment extends Activity {
   // Firebase ref = new Firebase("https://csse483androidfinalprije-63abd.firebaseio.com");
    private DatabaseReference mDatabase;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        final EditText editText1 = (EditText) findViewById(R.id.fullname);
        final EditText editText2 = (EditText) findViewById(R.id.ssn);
        final EditText editText3 = (EditText)findViewById(R.id.mobile);
        final EditText editText4 = (EditText)findViewById(R.id.hospitalVisited);
        Button submitbutton = (Button)findViewById(R.id.register);
        class blahListener implements ChildEventListener {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                User user  = dataSnapshot.getValue(User.class);
                user.setKey(dataSnapshot.getKey());
                //User user = new User(editText1.getText().toString(), editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString());


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }
        submitbutton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
                mDatabase.addChildEventListener(new blahListener());

               // DatabaseReference alanRef = mDatabase.child("users").child("Default");
               User user = new User(editText1.getText().toString(), editText2.getText().toString(),editText3.getText().toString(),editText4.getText().toString());
//                alanRef.setValue(user);
         //       alanRef.child("fullName").push().setValue(editText1.getText().toString());
                mDatabase.push().setValue(user);

            }
        });

    }


}
