package pl.maciejapanowicz.taskreminder.models.services;

import pl.maciejapanowicz.taskreminder.models.User;

import java.io.IOException;
import java.util.List;

public class RegisterService {
    private FileService fileService;

    public RegisterService(){
        fileService = new FileService();
    }

    public boolean userRegistration(User user) throws IOException{
        if (checkIfLoginIsFree(user.getUsername())){
            return false;
        }
        fileService.addUserToFile(user);
        return true;
    }

    public boolean checkIfLoginIsFree(String username) throws IOException {
        List<User> users = fileService.readUsers();
        return users.stream().anyMatch(s -> s.getUsername().equals(username));
    }
}
