package com.myproject.app;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //Creating a task object
        Task task1 = new Task("This project", "Good intro practice", Task.Status.IN_PROGRESS);
        //getting task status
        System.out.println("Status: " + task1.getStatus())
    }

}
