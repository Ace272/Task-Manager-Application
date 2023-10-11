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
    public void viewTaskList() {
    try {
        for (TaskItem task : taskList) {
            if (task != null && task.getName() != null) {
                System.out.println(task.getName());
            } else {
                System.out.println("Invalid or missing task information.");
            }
        }
    } catch (Exception e) {
        // Handle any unexpected exceptions that may occur during the loop.
        e.printStackTrace(); // You can replace this with a more appropriate error-handling strategy.
    }
}

    // Add to task list
    public void addToTL(TaskItem newTaskItem) {
    try {
        taskList.add(newTaskItem);
        TaskManager.addToAll(newTaskItem);
    } catch (NullPointerException e) {
        // Handle a possible NullPointerException if taskList or TaskManager is not properly initialized.
        e.printStackTrace(); 
        System.out.println("TaskManager or taskList not properly initialised");
    } catch (Exception e) {
        // Handle other exceptions that may occur during the execution of the method.
        e.printStackTrace(); 
    }
}

    // Remove from tasklist
    public void removeFromTL(TaskItem remTaskItem) {
    try {
        taskList.remove(remTaskItem);
        TaskManager.delToAll(remTaskItem);
    } catch (NullPointerException e) {
        // Handle a possible NullPointerException if taskList or TaskManager is not properly initialized.
        e.printStackTrace(); 
        System.out.println("TaskManager or taskList not properly initialised");
    } catch (Exception e) {
        // Handle other exceptions that may occur during the execution of the method.
        e.printStackTrace(); 
    }
}


}