package com.ashokrv95gmail.csse483androidfinalproject;

public class User {
    private String ssn;
    private String fullName;
    private String contactNumber;
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



}
