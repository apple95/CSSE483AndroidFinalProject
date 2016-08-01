package com.ashokrv95gmail.csse483androidfinalproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ashokvardhanraja on 8/1/16.
 */

    public class AllergyDoc2 extends Activity {
        Activity3HUTDocAllergy mAllergyDoc;
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.docdetail);

            TextView textView = (TextView)findViewById(R.id.docname);
            textView.setText("Nagarjuna R. Ponugoti MD");

        }

}
