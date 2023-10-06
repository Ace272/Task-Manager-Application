package com.myproject.app;

import java.util.*;
import java.io.*;

public class TaskManager{
    private List<TaskItem> tasks;
    //path to the file where the tasks are stored
    private String filePath;
    public static List<TaskItem> allTaskItems = new ArrayList<>();

    TaskManager(String filePath){
        this.filePath = filePath;
        tasks = new ArrayList<>();
    }

    // method adding to allTaskItems
    public static void addToAll(TaskItem newItem){
        allTaskItems.add(newItem);
    }
    //method to remove from allTaskItems
    public static void delToAll(TaskItem delItem){
        allTaskItems.remove(delItem);
    }
    //method to view allTaskItems
    public static void viewAllTasks(){
        for(TaskItem task: allTaskItems){
            System.out.println(task);
        }
    }
}