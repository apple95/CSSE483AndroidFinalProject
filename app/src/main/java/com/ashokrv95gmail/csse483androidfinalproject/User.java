package com.ashokrv95gmail.csse483androidfinalproject;

public class User {
    private int birthYear;
    private String fullName;
    private String contactNumber;
    private String CardNumber;

    public User() {}
    public User(String fullName, int birthYear,String contactNumber,String cardNumber) {
        this.fullName = fullName;
        this.birthYear = birthYear;

        this.contactNumber = contactNumber;
        this.CardNumber = cardNumber;
    }
    public long getBirthYear() {
        return birthYear;
    }
    public String getFullName() {
        return fullName;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public String getCardNumber() {
        return CardNumber;
    }



}
