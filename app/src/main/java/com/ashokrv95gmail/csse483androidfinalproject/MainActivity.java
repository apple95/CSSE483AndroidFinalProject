package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Application;
import android.app.Dialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class    MainActivity extends AppCompatActivity {
    private String name;
    private String password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private OnCompleteListener mOnCompleteListener;
    private MenuItem log_in_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();
        logout();
        initializeListeners();

        final Button button = (Button) findViewById(R.id.button_view);
        Button button1 = (Button) findViewById(R.id.buttonemergency_view);
        Button button2 = (Button) findViewById(R.id.buttonfixappointment_view);
        Button button3 = (Button) findViewById(R.id.buttonpay_view);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2Hospital.class);
                startActivityForResult(myIntent, 1);


            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2Emergency.class);
                startActivityForResult(myIntent, 1);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent myIntent = new Intent(v.getContext(), Activity2FixAppointment.class);
                startActivityForResult(myIntent, 1);


            }


        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2PayBill.class);
                startActivityForResult(myIntent, 1);
            }
        });


    }

    private void findDoc() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        log_in_out = menu.getItem(0);
        Log.d("TTT", "onCreateOptionsMenu: " + log_in_out.getTitle());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.log_in_item) {
            if (mAuth.getCurrentUser() != null) {
                logout();
            } else {
                DialogFragment df = new DialogFragment() {
                    @NonNull
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        final View view = getActivity().getLayoutInflater().inflate(R.layout.login, null);
                        builder.setView(view);
                        // capture
                        final EditText nameEditText = (EditText) view.findViewById(R.id.log_in_username);
                        final EditText passwordEditText = (EditText) view.findViewById(R.id.log_in_password);


                        //buttons
                        builder.setNegativeButton(android.R.string.cancel, null);
                        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!nameEditText.getText().toString().isEmpty()) {
                                    name = nameEditText.getText().toString();
                                } else {
                                    name = "";
                                }
                                if (!passwordEditText.getText().toString().isEmpty()) {
                                    password = passwordEditText.getText().toString();
                                } else {
                                    password = "";
                                }

                                emailLogIn();
                            }
                        });
                        return builder.create();
                    }

                };
                df.show(getSupportFragmentManager(), "add");
                log_in_out.setTitle("LOG OUT");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    protected void emailLogIn() {
        if (!(name == null || name.length() == 0) && !(password == null || password.length() == 0)) {
            mAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(mOnCompleteListener);
        } else {
            Toast.makeText(getBaseContext(), "Log in failure: Form not filled out correctly", Toast.LENGTH_SHORT).show();
            log_in_out.setTitle("LOG IN");
        }

    }

    protected void logout() {
        mAuth.signOut();
        Toast.makeText(getBaseContext(), "Logged out", Toast.LENGTH_SHORT).show();
        name = "";
        password = "";
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuthListener != null && mAuth != null) {
            mAuth.addAuthStateListener(mAuthListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuthListener != null && mAuth != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void initializeListeners() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    Log.d("TTT", "onAuthStateChanged: user is: " + user.getUid());
                } else {
                    Log.d("TTT", "onAuthStateChanged: user is null when adding Authstatelistener");
                }
            }
        };
        mOnCompleteListener = new OnCompleteListener() {
            @Override
            public void onComplete(@NonNull Task task) {
                if(!task.isSuccessful()) {
                    Toast.makeText(getBaseContext(), "Failed to log in as: " + name, Toast.LENGTH_SHORT).show();
                    log_in_out.setTitle("LOG IN");
                } else {
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(getBaseContext(), "Logged in as: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                    name = "";
                    password = "";
                    log_in_out.setTitle("LOG OUT");
                    checkUser(user);
                }
            }
        };
    }

    private void checkUser(FirebaseUser user) {
        // this is where the user will be checked for and made in firebase if it doesn't exist
        DatabaseReference firData = FirebaseDatabase.getInstance().getReference();
//        firData.child("users").child(user.getUid());
        Map<String, Object> data = new HashMap<>();
        data.put("empty", true);
        firData.child("users").child(user.getUid()).updateChildren(data);
        Log.d("TTT", "checkUser: " + firData);
    }
}
