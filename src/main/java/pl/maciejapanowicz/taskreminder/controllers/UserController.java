package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.models.Task;
import pl.maciejapanowicz.taskreminder.models.UserLoggedIn;
import pl.maciejapanowicz.taskreminder.models.services.TaskService;
import pl.maciejapanowicz.taskreminder.views.UserView;
import java.io.IOException;
import java.util.Scanner;

class UserController {
    private UserView userView;
    private Scanner scanner;
    private TaskService taskService;

    UserController(){
        userView = new UserView();
        scanner = new Scanner(System.in);
        taskService = new TaskService();
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
                    addNewTask();
                    break;
                }
                case "2": {
                    //todo Create logic for marking task as completed
                    break;
                }
                case "3":{
                    userView.sayGoodbyeToTheUser(UserLoggedIn.getINSTANCE().getUsername());
                    break;
                }
                default: {
                    userView.informAboutWrongCommand();
                }
            }
        }
        while (!userAnswer.equals("3"));
    }

    private void addNewTask(){
        String taskContent;
        userView.askForContentOfTheTask();
        taskContent = scanner.nextLine();
        Task task = new Task(UserLoggedIn.getINSTANCE().getUsername(),taskContent,false);

        try {
           taskService.addTask(task);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        userView.confirmTaskAdded(UserLoggedIn.getINSTANCE().getUsername(),taskContent);
    }
}

