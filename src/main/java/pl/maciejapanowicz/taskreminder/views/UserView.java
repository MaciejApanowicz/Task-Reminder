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
        System.out.println("Type your choice");
    }
    public void informAboutWrongCommand(){
        System.out.println("Wrong command.");
    }

}
