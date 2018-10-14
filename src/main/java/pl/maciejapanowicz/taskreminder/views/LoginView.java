package pl.maciejapanowicz.taskreminder.views;

public class LoginView {

    public void askForLogin(){
        System.out.println("Enter login: ");
    }
    public void askForPassword(){
        System.out.println("Enter password: ");
    }
    public void printMenu(){
        System.out.println("1. login");
        System.out.println("2. register");
    }
    public void askForMenuChoose(){
        System.out.println("Type the number of your choice");
    }
    public void askForPasswordToBeRepeated(){
        System.out.println("Please re-enter the password");
    }
    public void informThatPasswordsAreNotEqual(){
        System.out.println("Passwords are not equal");
    }
    public void informAboutWrongCommand(){
        System.out.println("Wrong command.");
    }
}
