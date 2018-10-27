package pl.maciejapanowicz.taskreminder.views;

public class UserView {

    public void showWelcomeMessage(String username){
        System.out.println("Hello " + username +". You are now logged in.");
    }
    public void showUserMenu(){
        System.out.println("1. Add new task");
        System.out.println("2. Mark task as completed");
        System.out.println("3. Exit");
    }
    public void getUserAnswer(){
        System.out.println("Now, type your choice from options available in menu");
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
