package com.sangsoo.contact;

import com.sangsoo.contact.controller.PhoneBookManager;
import com.sangsoo.contact.controller.INIT_MENU;
import com.sangsoo.contact.controller.WrongInputException;

public class ContactMain {
    public static void main(String[] args) {
        /**
         *  v 0.5 에서 singleton
         * */
//        PhoneBookManager manager = new PhoneBookManager();
        PhoneBookManager manager = PhoneBookManager.createManagerInstance();

        while (true) {
            /**
             *  v 0.6 Exception 추가
             * */
            try {
                manager.showMenu();
                int choice = manager.getScanner().nextInt();
                manager.getScanner().nextLine();

                switch (choice) {
                    case INIT_MENU.INPUT:
                        manager.insertFriend();
                        break;
                    case INIT_MENU.SEARCH:
                        manager.findFriend();
                        break;
                    case INIT_MENU.DELETE:
                        manager.deleteFriend();
                        break;
                    case INIT_MENU.EXIT:
                        return;
                    default:
                        throw new WrongInputException(choice);
                }
            } catch (WrongInputException e) {
               e.showWrongChoice();
               System.out.println("처음부터 다시 진행합니다.");
            } catch (Exception e) {

            }
        }
    }
}
