package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.models.User;
import pl.maciejapanowicz.taskreminder.models.services.RegisterService;
import pl.maciejapanowicz.taskreminder.views.LoginView;

import java.io.IOException;
import java.util.Scanner;

public class AuthController {
    private LoginView loginView;
    private Scanner scanner;
    private RegisterService registerService;

    public AuthController(){
        loginView = new LoginView();
        scanner = new Scanner(System.in);
        registerService = new RegisterService();
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
                getRegisterData();
                break;
            }
            default:{
                loginView.informAboutWrongCommand();
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
        System.out.println("If log in correctly -> go to the user main panel. This module is not ready yet.");
    }

    private void getRegisterData(){
        String username, password, passwordRepeted;
        boolean isRegister = false;

        do {
        scanner = new Scanner(System.in);
        loginView.askForLogin();
        username = scanner.nextLine();
        loginView.askForPassword();
        password = scanner.nextLine();
        loginView.askForPasswordToBeRepeated();
        passwordRepeted = scanner.nextLine();

        if (!password.equals(passwordRepeted)){
            loginView.informThatPasswordsAreNotEqual();
            continue;
        }
            User user = new User(username,password);

        try {
                isRegister = registerService.userRegistration(user);
        } catch (IOException e) {
            System.out.println("something went wrong");
            e.printStackTrace();
            System.exit(-1);
        }
            if (!isRegister){
                System.out.println("Sorry, this login is busy.");
            }
        }while (!isRegister);
    }
}
