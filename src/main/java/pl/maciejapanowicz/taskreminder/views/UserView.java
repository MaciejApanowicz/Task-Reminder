package pl.maciejapanowicz.taskreminder.views;

public class UserView {

    public void showWelcomeMessage(String username){
        System.out.println("Hello " + username +"! You are now logged in." + '\n');
    }
    public void showUserTasks (String username){
        System.out.println(username + ", those are your tasks:" + '\n');
    }
    public void informAboutLuckOfTask() {
        System.out.println("You don't have any tasks yet");
    }
    public void showUserMenu(){
        System.out.println("1. Add new task");
        System.out.println("2. Show my all tasks");
        System.out.println("3. Mark task as completed");
        System.out.println("4. Logout");
        System.out.println("5. Exit Task Reminder");
    }
    public void getUserAnswer(){
        System.out.println("\nType the operation of your choice:");
    }
    public void informAboutWrongCommand(){
        System.out.println("Wrong command.");
    }
    public void askForContentOfTheTask(){
        System.out.println("Enter the content of the task");
    }
    public void sayGoodbyeToTheUser(String username){
        System.out.println("Goodbye " + username + '\n');
    }
    public void confirmTaskAdded (String username, String taskAdded){
        System.out.println("Good " + username + "! This task: '" + taskAdded +
                "' has been successfully added to you schedule. Good luck! :) " );
    }
}
