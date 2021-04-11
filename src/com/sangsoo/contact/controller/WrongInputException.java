package com.sangsoo.contact.controller;

// 잘못된 input일때 exception 처리
public class WrongInputException extends Exception{

    int wrongChoice;

    public WrongInputException(int choice){//String errorMessage){
        super("잘못된 입력");
        wrongChoice = choice;
    }

    public void showWrongChoice(){
        System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
    }
}
