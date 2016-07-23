package com.ashokrv95gmail.csse483androidfinalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ashokvardhanraja on 7/23/16.
 */
public class NameAdapterTUDep extends BaseAdapter{
    private Context mContext;
    final ArrayList<String> mNames = new ArrayList<>();
    private Random mRandom = new Random();


    public NameAdapterTUDep(Context context){
        mContext = context;
        for(int i =0;i<46;i++){
            mNames.add(getRandomName(i));
        }
    }

    private String getRandomName(int pos){
        String[] names = new String[]{

        "Allergy", "Anesthesiology" , "Cardiology" , "Cardiovascular Surgery" , "Dental", "Dermatology", "Emergency Medicine", "Endocrinology", "Family Medicine", "Gastroenterology", "Geriatric Medicine", "General Surgery", "Gynecology", "Hand Surgery", "Holistic Medicine", "Hospitalist" , "Infectious Diseases", "Internal Medicine",
                "Medical Acupuncture", "Neonatology" , "Nephrology","Neurological Surgery", "Neurology", "Nuclear Medicine", "Oncology", "Ophthalmology", "Oral Surgery", "Orthopaedics", "Otolaryngology", "Otorhinolaryngology",  "Obstetrics and Gynecology", "Pain Management",  "Pathology","“Pediatric Infectious Disease", "Pediatric Neurology",
                 "Pediatrics", "PhysicalMedicineRehabilitation", "Plastic Surgery" , "Podiatry", "Psychiatry", "Pulmonology", "Radiology" , "Radiation Oncology", "Rheumatology", "Urology", "Wound Care"

        };
        int count = names.length;
        return names[pos];
    }


    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int position) {
        return mNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView == null){
            //Make a view
            view = LayoutInflater.from(mContext).inflate(R.layout.hospital_view,parent,false);
        }else{
            view = convertView;
        }
        //Customize it
        String name = mNames.get(position);
        TextView positionTextView = (TextView)view.findViewById(R.id.position_view);

        switch(name) {
            case "Allergy":
                positionTextView.setText(name);
                break;

            case  "Pathology":
                positionTextView.setText(name);
                break;

            case  "Pain Management":
                positionTextView.setText(name);
                break;
            case  "Anesthesiology":
                positionTextView.setText(name);
                break;
            case  "Pediatric Infectious Disease":
                positionTextView.setText(name);
                break;
            case  "Obstetrics and Gynecology":
                positionTextView.setText(name);
                break;
            case  "Nuclear Medicine":
                positionTextView.setText(name);
                break;
            case  "Oral Surgery":
                positionTextView.setText(name);
                break;
            case  "Pediatric Neurology":
                positionTextView.setText(name);
                break;
            case  "Neurology":
                positionTextView.setText(name);
                break;
            case  "Medical Acupuncture":
                positionTextView.setText(name);
                break;
            case  "Radiology":
                positionTextView.setText(name);
                break;
            case  "Neurological Surgery":
                positionTextView.setText(name);
                break;
            case  "Internal Medicine":
                positionTextView.setText(name);
                break;
            case  "Infectious Diseases":
                positionTextView.setText(name);
                break;
            case  "Hospitalist":
                positionTextView.setText(name);
                break;
            case  "Holistic Medicine":
                positionTextView.setText(name);
                break;
            case  "Hand Surgery":
                positionTextView.setText(name);
                break;
            case  "General Surgery":
                positionTextView.setText(name);
                break;
            case  "Plastic Surgery":
                positionTextView.setText(name);
                break;
            case  "Radiation Oncology":
                positionTextView.setText(name);
                break;
            case  "Psychiatry":
                positionTextView.setText(name);
                break;
            case  "Pulmonology":
                positionTextView.setText(name);
                break;
            case  "Otolaryngology":
                positionTextView.setText(name);
                break;
            case  "Ophthalmology":
                positionTextView.setText(name);
                break;
            case  "Orthopaedics":
                positionTextView.setText(name);
                break;
            case  "Oncology":
                positionTextView.setText(name);
                break;
            case  "Rheumatology":
                positionTextView.setText(name);
                break;
            case  "Urology":
                positionTextView.setText(name);
                break;
            case  "Podiatry":
                positionTextView.setText(name);
                break;
            case  "Gynecology":
                positionTextView.setText(name);
                break;
            case  "Pediatrics":
                positionTextView.setText(name);
                break;
            case  "PhysicalMedicineRehabilitation":
                positionTextView.setText(name);
                break;
            case  "Nephrology":
                positionTextView.setText(name);
                break;
            case  "Neonatology":
                positionTextView.setText(name);
                break;
            case  "Geriatric Medicine":
                positionTextView.setText(name);
                break;
            case  "Gastroenterology":
                positionTextView.setText(name);
                break;
            case  "Family Medicine":
                positionTextView.setText(name);
                break;
            case  "Endocrinology":
                positionTextView.setText(name);
                break;
            case  "Emergency Medicine":
                positionTextView.setText(name);
                break;
            case  "Dermatology":
                positionTextView.setText(name);
                break;
            case  "Dental":
                positionTextView.setText(name);
                break;
            case  "Cardiovascular Surgery":
                positionTextView.setText(name);
                break;
            case  "Cardiology":
                positionTextView.setText(name);
                break;
            case  "Wound Care":
                positionTextView.setText(name);
                break;
            default:
                break;




        }

        return view;


    }
    public void addName(int pos){

        mNames.add(0,getRandomName(pos));
        notifyDataSetChanged();
    }
}
