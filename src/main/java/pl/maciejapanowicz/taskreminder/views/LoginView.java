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
    public void informThatLoginIsBusy(){
        System.out.println("Sorry, this login is already used by another user.");
    }
    public void showErrorMessageWhileLoginProcess(){
        System.out.println("something went wrong");
    }
    public void confirmThatNewUserHasBeenAdded (String username) {
        System.out.println("Hello " + username + ". Thank you for registering!.");
        System.out.println("You can now log in and enjoy all the benefits of TaskReminder.");
    }
    public void showMessageAfterLogIn (String username) {
        System.out.println("Hello " + username +"! You are now logged in.");
    }
}
