package com.sangsoo.contact.vo;

public class PhoneInfo {
    private String name;
    private String phoneNumber;

    //constructor
    public PhoneInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void showPhoneInfo(){
        System.out.println("name : " + this.name);
        System.out.println("phoneNumber : " + this.phoneNumber);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
