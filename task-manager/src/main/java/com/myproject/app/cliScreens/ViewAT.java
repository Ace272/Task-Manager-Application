package com.myproject.app.cliScreens;

import com.myproject.app.TaskManager;

public class ViewAT {
    public static void screen(){
        System.out.println("All tasks:");
        TaskManager.viewAllTasks();
        System.out.println();
        System.out.println();
        System.out.println("<--- Press 0 to return to Main Menu");
    };
}
