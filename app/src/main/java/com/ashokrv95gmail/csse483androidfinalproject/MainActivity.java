package com.ashokrv95gmail.csse483androidfinalproject;

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

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button button = (Button) findViewById(R.id.button_view);
        Button button1 = (Button)findViewById(R.id.buttonemergency_view);
        Button button2 = (Button)findViewById(R.id.buttonfixappointment_view);
        Button button3 = (Button) findViewById(R.id.buttonpay_view);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Activity2Hospital.class);
                startActivityForResult(myIntent,1);
//                DialogFragment df = new DialogFragment(){
//                    @NonNull
//                    @Override
//                    public Dialog onCreateDialog(Bundle savedInstanceState){
//                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                        View view = getActivity().getLayoutInflater().inflate(R.layout.hospital_view, null);
//                        builder.setView(view);
//                        builder.setTitle("HOSPITALS");
//                        final EditText edit = (EditText)view.findViewById(R.id.dialog_add_zip);
//                        Log.e("A",edit.getText().toString());
//                        edit.
//
//                        // boolean checked = ((RadioButton) view).isChecked();
//
//                        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                if(edit.getText().toString().equals("47803")){
//                                    Intent myIntent = new Intent(v.getContext(), Activity2.class);
//                                    startActivityForResult(myIntent, 0);
//
//
//                                }
//                            }
//                        });
//
//                        builder.setNegativeButton(android.R.string.cancel,null);
//
//                        return builder.create();
//                    }
//                };
//                df.show(getSupportFragmentManager(),"select");

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DialogFragment(){
                    @NonNull
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        View view = getActivity().getLayoutInflater().inflate(R.layout.emergency_view, null);
                        builder.setView(view);
                        builder.setTitle("EMERGENCY");
                        // boolean checked = ((RadioButton) view).isChecked();

                        builder.setPositiveButton(android.R.string.ok, null);






                        builder.setNegativeButton(android.R.string.cancel,null);

                        return builder.create();
                    }
                };
                df.show(getSupportFragmentManager(),"select");

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DialogFragment(){
                    @NonNull
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        View view = getActivity().getLayoutInflater().inflate(R.layout.fix_appointment, null);
                        builder.setView(view);
                        builder.setTitle("FIX APPOINTMENT");
                        // boolean checked = ((RadioButton) view).isChecked();

                        builder.setPositiveButton(android.R.string.ok, null);






                        builder.setNegativeButton(android.R.string.cancel,null);

                        return builder.create();
                    }
                };
                df.show(getSupportFragmentManager(),"select");

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment df = new DialogFragment(){
                    @NonNull
                    @Override
                    public Dialog onCreateDialog(Bundle savedInstanceState){
                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        View view = getActivity().getLayoutInflater().inflate(R.layout.paybills_view, null);
                        builder.setView(view);
                        builder.setTitle("PAY BILLS");
                        // boolean checked = ((RadioButton) view).isChecked();

                        builder.setPositiveButton(android.R.string.ok, null);






                        builder.setNegativeButton(android.R.string.cancel,null);

                        return builder.create();
                    }
                };
                df.show(getSupportFragmentManager(),"select");

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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
