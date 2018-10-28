package pl.maciejapanowicz.taskreminder.models;

public class Task {
    private String owner;
    private String content;
    private boolean isDone;

    public Task(String owner, String content,boolean isDone){
        this.owner = owner;
        this.content = content;
        this.isDone = isDone;
    }

    public String getOwner(){
        return owner;
    }
    public String getContent(){
        return content;
    }
    public boolean isItDone(){
        return isDone;
    }

    @Override
    public String toString() {
        return "Task{" +
                "owner='" + owner + '\'' +
                ", content='" + content + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}