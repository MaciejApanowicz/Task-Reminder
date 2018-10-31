package pl.maciejapanowicz.taskreminder.models.services;

import pl.maciejapanowicz.taskreminder.models.Task;
import pl.maciejapanowicz.taskreminder.models.User;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    void addUserToFile(User user) throws IOException{
        File file = new File("Users.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String userToWrite = user.getUsername() + "|" + user.getPassword() + "\r\n";
        Files.write(file.toPath(),userToWrite.getBytes(),StandardOpenOption.APPEND);
    }

     List<User> readUsers() throws IOException{
        File file = new File("Users.txt");
         try {
             if (!file.exists()) file.createNewFile();
             } catch (IOException e) {
                e.printStackTrace();
             }
        List<String> listOfString = Files.readAllLines(file.toPath());
        List<User> users = new ArrayList<>();
        for (String s: listOfString){
            String[] usernameAndPassword = s.split("\\|");
            users.add(new User(usernameAndPassword[0],usernameAndPassword[1]));
        }
        return users;
    }

    public void addTaskToFile (Task task) throws IOException{
        File file = new File("Tasks.txt");

        String taskString = task.getOwner() + "|" + task.getContent() + "|" + task.isItDone() + "\r\n";
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Files.write(file.toPath(),taskString.getBytes(),StandardOpenOption.APPEND);
    }
    public List<Task> readAllTasks()throws IOException {
        File file = new File("Tasks.txt");

        List<String> listOfLines = Files.readAllLines(file.toPath());
        List<Task> tasks = new ArrayList<>();
        for (String line: listOfLines){
            String [] splitedTaskData = line.split("\\|");
            tasks.add(new Task(splitedTaskData[0],splitedTaskData[1],Boolean.getBoolean(splitedTaskData[2])));
        }
        return tasks;
    }
}

