package pl.maciejapanowicz.taskreminder.controllers;

import pl.maciejapanowicz.taskreminder.models.Task;
import pl.maciejapanowicz.taskreminder.models.UserLoggedIn;
import pl.maciejapanowicz.taskreminder.models.services.TaskService;
import pl.maciejapanowicz.taskreminder.views.UserView;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
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

    void startMainMenu()  {
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
                    showUserTask();
                    break;
                }
                case "3":{
                    showUserTask();
                    markTaskAsDone();
                    showUserTask();
                    break;
                }
                case "4":{
                    new AuthController().start();
                    break;
                }
                case "5":{
                        userView.sayGoodbyeToTheUser(UserLoggedIn.getINSTANCE().getUsername());
                    break;
                }
                default: {
                    userView.informAboutWrongCommand();
                }
            }
        }
        while (!userAnswer.equals("5"));
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

    private List<Task> getUserTasks(){
        List<Task> userTaskList;
        try {
            if (taskService.getUserTasks(UserLoggedIn.getINSTANCE().getUsername()).size()==0)
                userView.informAboutLuckOfTask();
            userTaskList = taskService.getUserTasks(UserLoggedIn.getINSTANCE().getUsername());
        } catch (IOException e) {
            userTaskList = Collections.emptyList();
            e.printStackTrace();
        }
        return userTaskList;
    }

    private void markTaskAsDone () {
        List<Task> userTasks = getUserTasks();
        userView.askWhichTaskMarkAsDone();
        String taskId = scanner.nextLine();

        Task chosenTask = userTasks.get(Integer.valueOf(taskId));
        if (!chosenTask.isItDone()){
            chosenTask.setDone(true);
            try {
                taskService.update(chosenTask);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("no przecież jest już done");
        }
    }

    private void showUserTask (){
        for (Task task : getUserTasks()){
            System.out.println(task);
        }
    }
}

