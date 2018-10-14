package pl.maciejapanowicz.taskreminder.models.services;

import pl.maciejapanowicz.taskreminder.models.User;
import java.io.IOException;
import java.util.List;

public class LoginService {
    private FileService fileService;

    public LoginService(){
        fileService = new FileService();
    }

    public boolean tryToLogin (String username, String password) throws IOException{
        List<User> userList = fileService.readUsers();
        return userList.stream().anyMatch
                (s -> s.getUsername().equals(username) && s.getPassword().equals(password));
    }
}
