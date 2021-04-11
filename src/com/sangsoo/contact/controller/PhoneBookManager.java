package com.sangsoo.contact.controller;

import com.sangsoo.contact.vo.PhoneCompanyInfo;
import com.sangsoo.contact.vo.PhoneInfo;
import com.sangsoo.contact.vo.PhoneUnivInfo;

import java.util.Scanner;

public class PhoneBookManager {

    // class variables
    private static MenuViewer menuViewer = new MenuViewer();    // 메뉴 출력용 class -> instance 필요없음. static 선언
                                                                // main에서 쓰려면 같은 패키지안에 있어야 하는데, 다른 패키지이기에 변수로 선언해서 메소드로 접근
    public static PhoneBookManager manager = null;

    // instance variables
    final static int MAX_FRIEND = 100;
    private PhoneInfo[] friends = new PhoneInfo[MAX_FRIEND];
    private int friendNumber = 0;

    //constructor -> private 처리 후 singleton
    private PhoneBookManager() {

    }

    // class method
    public static PhoneBookManager createManagerInstance(){
        if(manager == null){
            manager = new PhoneBookManager();
        }
        return manager;
    }
    public static void showMenu(){
        menuViewer.showMenu();
    }
    public static Scanner getScanner(){
        return menuViewer.sc;
    }

    // instance method
    /**
     * 1. INSERT
     * */
    public void insertFriend() throws WrongInputException{
        System.out.println  ("데이터 입력을 시작합니다.");
        System.out.println  ("1. 일반, 2. 대학, 3.회사");
        System.out.print    ("선택>>");
        int choice = menuViewer.sc.nextInt();
        menuViewer.sc.nextLine();

        if(choice == INPUT_SELECT.NORMAL){
            System.out.print("이름 : ");
            String name = menuViewer.sc.nextLine();
            System.out.print("전화번호 : ");
            String phoneNumber = menuViewer.sc.nextLine();

            friends[friendNumber++] = new PhoneInfo(name, phoneNumber);
        }else if(choice == INPUT_SELECT.UNIV){
            System.out.print("이름 : ");
            String name = menuViewer.sc.nextLine();
            System.out.print("전화번호 : ");
            String phoneNumber = menuViewer.sc.nextLine();
            System.out.print("전공 : ");
            String major = menuViewer.sc.nextLine();
            System.out.print("학년 : ");
            int year = menuViewer.sc.nextInt();

            friends[friendNumber++] = new PhoneUnivInfo(name, phoneNumber, major, year);
        }else if(choice == INPUT_SELECT.COMPANY){
            System.out.print("이름 : ");
            String name = menuViewer.sc.nextLine();
            System.out.print("전화번호 : ");
            String phoneNumber = menuViewer.sc.nextLine();
            System.out.print("회사 : ");
            String company = menuViewer.sc.nextLine();

            friends[friendNumber++] = new PhoneCompanyInfo(name, phoneNumber, company);
        }else{
            throw new WrongInputException(choice);
        }

        System.out.println("데이터 입력이 완료되었습니다.");
    }
    /**
     * 2. SEARCH
     * */
    public void findFriend(){
        System.out.println("데이터 검색을 시작합니다.");

        System.out.print("이름 : ");
        String name = menuViewer.sc.nextLine();

        int index = find(name);
        if(index < 0){
            System.out.println("해당 데이터는 존재하지 않습니다.");
        }else{
            friends[index].showPhoneInfo();
        }
    }
    /**
     * 3. DELETE
     * */
    public void deleteFriend(){
        System.out.println("데이터 삭제를 시작합니다.");

        System.out.print("이름 : ");
        String name = menuViewer.sc.nextLine();

        int index = find(name);
        if(index < 0){
            System.out.println("해당 데이터는 존재하지 않습니다.");
        }else{
            for(int i=index; i<friendNumber-1; i++){
                friends[i] = friends[i+1];
            }
        }
        friendNumber--;
        System.out.println("데이터 삭제를 완료되었습니다.");
    }
    /**
     * 4. ETC ..
     * */
    public int find(String name){
        int returnIdx = -1;

        for(int i=0; i<friendNumber; i++){
            if(name.compareTo(friends[i].getName()) == 0){
                return i;
            }
        }
        return returnIdx;
    }
}
class MenuViewer{
    // class variables
    public static Scanner sc = new Scanner(System.in);

    // class method
    public static void showMenu() {
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택 : ");
    }
}