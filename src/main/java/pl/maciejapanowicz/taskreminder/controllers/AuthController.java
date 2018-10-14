package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.models.User;
import pl.maciejapanowicz.taskreminder.models.services.LoginService;
import pl.maciejapanowicz.taskreminder.models.services.RegisterService;
import pl.maciejapanowicz.taskreminder.views.LoginView;
import java.io.IOException;
import java.util.Scanner;

public class AuthController {
    private LoginView loginView;
    private Scanner scanner;
    private RegisterService registerService;
    private LoginService loginService;

    public AuthController(){
        loginView = new LoginView();
        scanner = new Scanner(System.in);
        registerService = new RegisterService();
        loginService = new LoginService();
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
            try {
                isLogin = loginService.tryToLogin(username,password);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        while (!isLogin);
        loginView.showMessageAfterLogIn(username);
        //todo  Here, the user has been successfully logged in. Create user's main menu and user's view.
    }

    private void getRegisterData(){
        String username, password, passwordRepeated;
        boolean isRegister = false;

        do {
        scanner = new Scanner(System.in);
        loginView.askForLogin();
        username = scanner.nextLine();
        loginView.askForPassword();
        password = scanner.nextLine();
        loginView.askForPasswordToBeRepeated();
        passwordRepeated = scanner.nextLine();

        if (!password.equals(passwordRepeated)){
            loginView.informThatPasswordsAreNotEqual();
            continue;
        }
        User user = new User(username,password);

        try { isRegister = registerService.userRegistration(user);
            loginView.confirmThatNewUserHasBeenAdded(username);
        }
        catch (IOException e) {
            loginView.showErrorMessageWhileLoginProcess();
            e.printStackTrace();
            System.exit(-1);
        }
        if (!isRegister){
            loginView.informThatLoginIsBusy();
        }
        }
        while (!isRegister);
    }
}
