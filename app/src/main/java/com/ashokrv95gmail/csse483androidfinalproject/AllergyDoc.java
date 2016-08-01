package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ashokvardhanraja on 7/31/16.
 */
public class AllergyDoc extends Activity {
    Activity3HUTDocAllergy mAllergyDoc;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.docdetail);

            TextView textView = (TextView)findViewById(R.id.docname);
            textView.setText("Diane L. Jordan-Wagner MD");





    }

}
