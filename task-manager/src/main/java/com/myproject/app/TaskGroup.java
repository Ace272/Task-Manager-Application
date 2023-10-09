package com.myproject.app;

import java.util.*;
// import java.io.*;

public class TaskGroup{
    private String name;
    private String description;
    private List<TaskItem> taskList;

    TaskGroup(String name, String description){
        this.name = name;
        this.description = description;
        taskList= new ArrayList<> ();
    }

    //getter methods
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<TaskItem> getTasks() {
        if (taskList.isEmpty()){
            System.out.println("Task list is empty");
            }
        return taskList;
    }

    //setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /* ******************Task List Manipulation *********************************/ 
    //View the task list
    public void viewTaskList(){
        for(TaskItem task:taskList){
            System.out.println(task.getName());
        }
    }

    // Add to task list
    public void addToTL(TaskItem newTaskItem){
        taskList.add(newTaskItem);
        TaskManager.addToAll(newTaskItem);
    }

    // Remove from tasklist
    public void removeFromTL(TaskItem remTaskItem){
        taskList.remove(remTaskItem);
        TaskManager.delToAll(remTaskItem);
    }

}