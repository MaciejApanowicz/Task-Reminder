package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.views.LoginView;
import java.util.Scanner;

public class AuthController {
    private LoginView loginView;
    private Scanner scanner;

    public AuthController(){
        loginView = new LoginView();
        scanner = new Scanner(System.in);
    }

    public void start(){
        loginView.printMenu();
        createMenu();
    }

    private void createMenu(){
        loginView.askForMenuChoose();
         int choose = scanner.nextInt();

        switch (choose){
            case 1: {
                getLoginData();
                break;
            }
            case 2: {

                break;
            }
            default:{

            }
        }
    }

    private void getLoginData() {
        String username, password;
        boolean isLogin = false;

        do {
            scanner = new Scanner(System.in);
            loginView.askForLogin();
            username = scanner.nextLine();
            loginView.askForPassword();
            password = scanner.nextLine();

            //todo add login service
            isLogin = true;
        }
        while (!isLogin);
        System.out.println("Login completed");
    }

}
