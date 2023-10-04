package com.myproject.app;

public class Task{

    public enum Status{
        TODO,
        IN_PROGRESS,
        DONE
    }
    private String name;
    private String description;
    private Status status;

    Task(String name, String description, Status status){
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Status getStatus(){
        return status;
    }
}