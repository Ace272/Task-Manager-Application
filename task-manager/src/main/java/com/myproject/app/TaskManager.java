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

    /* 
    //Adding tasks to task list in taskgroup
    public void addnewToTGList(TaskGroup tg, TaskItem taskId, String taskName, String taskDesc, TaskItem.Status stat){
        createTaskItem(taskId, taskName, taskDesc, stat);
    }

    public void addNewToTGList(TaskGroup tg, String taskName, String taskDesc, TaskItem.Status stat) {
        TaskItem newTask = createTaskItem(taskName, taskDesc, stat);
        
    }
*/
    //File time
}