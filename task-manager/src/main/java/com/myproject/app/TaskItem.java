package com.myproject.app;

public class TaskItem{

    public enum Status{
        TODO,
        IN_PROGRESS,
        DONE
    }
    private String name;
    private String description;
    private Status status;

    TaskItem(String name, String description, Status status){
        this.name = name;
        this.description = description;
        this.status = status;
    }

    //getter methods
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Status getStatus(){
        return status;
    }

    //setter methods
    public void setName(String newName){
        this.name = newName;
    }
    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    public void setStatus(Status newStatus){
        this.status = newStatus;
    }

    
}