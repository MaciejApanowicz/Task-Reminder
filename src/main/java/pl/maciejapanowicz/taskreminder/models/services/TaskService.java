package pl.maciejapanowicz.taskreminder.models.services;

import pl.maciejapanowicz.taskreminder.models.Task;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private FileService fileService;

    public TaskService () {
        fileService = new FileService();
    }
    public void addTask(Task task) throws IOException{
        fileService.addTaskToFile(task);
    }
    public List<Task> getUserTasks (String username) throws IOException{
        return fileService.readAllTasks().stream()
                .filter(s -> s.getOwner().equals(username))
                .collect(Collectors.toList());
    }
}