package com.sangsoo.contact.vo;

public class PhoneCompanyInfo extends PhoneInfo {

    private String company;

    public PhoneCompanyInfo(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("company : " + this.company);
    }
}
