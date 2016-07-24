package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {
    private String name;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        } else if (id == R.id.log_out_item) {
            name = "";
            password = "";
            Toast.makeText(getBaseContext(), "Logged out", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.log_in_item) {
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
                            }
                            if (!passwordEditText.getText().toString().isEmpty()) {
                                password = passwordEditText.getText().toString();
                            }
                            if(passwordEditText.getText().toString().equals("password")) {
                                Log.d("TTT", "onClick: password checks out");
                                Toast.makeText(getContext(), "Tried to login as: " + name, Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                    return builder.create();
                }

            };
            df.show(getSupportFragmentManager(), "add");
        }

        return super.onOptionsItemSelected(item);
    }
}
