package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.models.UserLoggedIn;
import pl.maciejapanowicz.taskreminder.views.UserView;
import java.util.Scanner;

class UserController {
    private UserView userView;
    private Scanner scanner;

    UserController(){
        userView = new UserView();
        scanner = new Scanner(System.in);
    }

    void startMainMenu(){
        userView.showWelcomeMessage(UserLoggedIn.getINSTANCE().getUsername());
        userView.showUserMenu();
        String userAnswer;

        do {
            userView.getUserAnswer();
            userAnswer = scanner.nextLine();

            switch (userAnswer){
                case "1": {
                    //todo  Create add task logic
                    break;
                }
                case "2": {
                    //todo Create marking task as completed logic
                    break;
                }
                case "3":{
                    break;
                }
                default: {
                    userView.informAboutWrongCommand();
                }
            }
        }
        while (!userAnswer.equals("3"));
    }
}
