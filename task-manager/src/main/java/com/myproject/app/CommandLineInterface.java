package com.myproject.app;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLineInterface {

    private Scanner scanner;
    private String username;
    private static final Logger logger = LogManager.getLogger(CommandLineInterface.class);

    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
    }
    

    public void go(){
        System.out.println("Welcome to the Task Manager app");
        System.out.println("What is your name?");
        username = scanner.nextLine();
        logger.info("Name of user received: "+ username);
        System.out.println("Hello, " + username);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
