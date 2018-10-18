package pl.maciejapanowicz.taskreminder.models.services;

import pl.maciejapanowicz.taskreminder.models.Task;

import java.io.IOException;

public class TaskService {
    private FileService fileService;

    public TaskService () {
        fileService = new FileService();
    }
    public void addTask(Task task) throws IOException{
        fileService.addTaskToFile(task);
    }
}
