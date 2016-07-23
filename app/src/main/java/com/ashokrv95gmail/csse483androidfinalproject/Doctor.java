package com.ashokrv95gmail.csse483androidfinalproject;


import java.util.ArrayList;

/**
 * Created by andersva on 7/9/2016.
 */
public class Doctor {
    private ArrayList<Appointment> appointments;
    private Boolean onCall;
    private String Description;

    public void setOnCall(Boolean onCall) {
        this.onCall = onCall;
    }

    /**
     * The only parameter for this doctor will be the string description
     * that contains their qualifications and other information about them.
     *
     * The other information will be set by the department or the hospital.
     *
     * @param description
     */
    public Doctor(String description) {
        this.onCall = false;
        this.Description = description;
    }

}
