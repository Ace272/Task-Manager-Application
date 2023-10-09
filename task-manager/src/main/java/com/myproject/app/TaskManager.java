package com.myproject.app;

import java.util.*;
import java.io.*;

public class TaskManager{
    public static List<TaskItem> allTaskItems = new ArrayList<>();

    TaskManager(){
        //placeholder
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

    //method to create a task group
    public TaskGroup createTaskGroup(TaskGroup taskGroupObj, String name, String desc){
        taskGroupObj = new TaskGroup(name, desc);
        return taskGroupObj;
    }

    //method to create a task Item
    public TaskItem createTaskItem(TaskItem taskItemobj, String name, String desc, TaskItem.Status stat){
        taskItemobj = new TaskItem(name, desc, stat);
        return taskItemobj;
    }

    // add new item to task group list
    public void addNewToTGList(TaskGroup tg, TaskItem taskItemobj, String name, String desc, TaskItem.Status stat ){
        taskItemobj = new TaskItem(name, desc, stat);
        tg.addToTL(taskItemobj);
        tg.viewTaskList();
    }

    //add existing taskItem to task group list
    public void addToTGList(TaskGroup tg, TaskItem ti){
        tg.addToTL(ti);
        tg.viewTaskList();
    }
    //File time

    //creating Task Group File
    public void createTaskGroupFile(File file, TaskGroup tg, String name, String desc){
        createTaskGroup(tg, name, desc);
        String fileName = tg.getName() + ".xml";
        try{
            file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}