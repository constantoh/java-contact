package com.sangsoo.contact.vo;

import java.util.Objects;

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

    /**
     * v 0.7 hashset을 위한 equals와 hashcode overriding
     * */
    @Override
    public boolean equals(Object o) {
        if(this.getName().compareTo(((PhoneInfo)o).getName()) == 0){
            //param의 name과 this의 name이 같으면 같은 것으로 간주한다.
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        // PhoneInfo의  hash value는 이름으로 정한다.
        return name.hashCode();
    }
}
