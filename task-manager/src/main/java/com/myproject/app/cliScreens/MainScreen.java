package com.myproject.app.cliScreens;

import java.util.Scanner;

public class MainScreen {
    public static int screen(){
        System.out.println("1- View all tasks");
        System.out.println("2- View Task Groups");
        System.out.println();
        System.out.println();
        System.out.println("<--- Press 0 to return to Main  Menu");
        int num;
        Scanner scan = new Scanner(System.in);
        num = scan.nextInt();
        return(num);

    };
}
