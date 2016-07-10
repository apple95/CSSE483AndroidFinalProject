package com.ashokrv95gmail.csse483androidfinalproject;

import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.util.Log;


/**
 * Created by andersva on 7/9/2016.
 */
public class Appointment {

    private int month;
    private int day;
    private int year;
    private Boolean isOpen;
    private Doctor doctor;


    /**
     * With this constructor, there is an underlying assumption
     * that all of the appointments are open until they are filled
     * at a later date, thus: isOpen will tell you wether or not an
     * appointment is open, or available, and defaults to true;
     *
     * @param doc   The doctor for the appointment (Doctor)
     * @param month Month of the appointment (String -> int)
     * @param day   Numerical day of the appointment (String -> int)
     * @param year  Year of the appointment (String -> int)
     */
    public Appointment(Doctor doc, String month, String day, String year){
        this.isOpen = true;

        if(doc.getClass() != Doctor.class) {
            Log.d("TTT", "Doctor doc parameter was not of correct class type");
        } else {
            this.doctor = doc;
        }

        try { this.day = Integer.parseInt(day); }
        catch (Exception e) { Log.d("TTT", "Day was not successfully loaded"); }

        try { this.month = Integer.parseInt(month); }
        catch (Exception e) { Log.d("TTT", "Month was not successfully loaded"); }

        try { this.year = Integer.parseInt(year); }
        catch (Exception e) { Log.d("TTT", "Year was not successfully loaded"); }

    }
}
