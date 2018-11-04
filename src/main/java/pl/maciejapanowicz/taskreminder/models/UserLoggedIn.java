package pl.maciejapanowicz.taskreminder.models;

public class UserLoggedIn {
    private static UserLoggedIn INSTANCE = new UserLoggedIn();
    private UserLoggedIn(){}

    public static UserLoggedIn getINSTANCE() {
        return INSTANCE;
    }

    private boolean isUserLogin;
    private String username;

    public boolean isUserLogin() {
        return isUserLogin;
    }
    public String getUsername(){
        return username;
    }

    public void setUserLogin(boolean userLogin) {
        isUserLogin = userLogin;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
