package com.ashokrv95gmail.csse483androidfinalproject;

import com.google.firebase.database.Exclude;

public class User {
    private String ssn;
    private String fullName;
    private String contactNumber;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public void setSsn(String ssn) {

        this.ssn = ssn;
    }

    private String key;
    private String hospital;

    public User() {}
    public User(String fullName, String ssn,String contactNumber,String hospital) {
        this.fullName = fullName;
        this.ssn = ssn;

        this.contactNumber = contactNumber;
        this.hospital = hospital;
    }
    public String getssn() {
        return ssn;
    }
    public String getFullName() {
        return fullName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getHospital() {
        return hospital;
    }

    @Exclude
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValues(User user) {
        this.fullName = user.fullName;
        this.ssn = user.ssn;

        this.contactNumber = user.contactNumber;
        this.hospital = user.hospital;
    }


}
