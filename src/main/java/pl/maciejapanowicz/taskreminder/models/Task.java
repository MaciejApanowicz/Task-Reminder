package pl.maciejapanowicz.taskreminder.models;

import java.time.LocalDate;

public class Task {
    private String owner;
    private String content;
   // private LocalDate deadline;
    private boolean isDone;

    public Task(String owner, String content,boolean isDone){
        this.owner = owner;
        this.content = content;
      //  this.deadline = deadline;
        this.isDone = isDone;
    }



}
