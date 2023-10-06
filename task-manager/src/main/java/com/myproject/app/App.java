package com.myproject.app;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Creating a task object
        TaskItem task1 = new TaskItem("This project", "Good intro practice", TaskItem.Status.IN_PROGRESS);
        //getting task status
        System.out.println("Status: " + task1.getStatus());
    }

}
