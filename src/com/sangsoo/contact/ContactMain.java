package com.sangsoo.contact;


import com.sangsoo.contact.controller.PhoneBookManager;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ContactMain {
    public static void main(String[] args){
        PhoneBookManager manage = new PhoneBookManager();

        while(true){
            manage.showMenu();
            int choice = manage.getScanner().nextInt();
            manage.getScanner().nextLine();

            switch (choice){
                case 1:
                    manage.insertFriend();
                    break;
                case 2:
                    manage.findFriend();
                    break;
                case 3:
                    manage.deleteFriend();
                    break;
                case 4: default:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }
    }
}
