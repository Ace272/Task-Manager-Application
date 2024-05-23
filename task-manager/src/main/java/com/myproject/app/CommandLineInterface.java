package com.myproject.app;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLineInterface {
    private static final Logger logger = LogManager.getLogger(CommandLineInterface.class);
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main() {
        logger.info("Task Manager CLI started");
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createTaskGroup();
                    break;
                case 2:
                    viewAllTaskGroups();
                    break;
                case 3:
                    manageTaskGroup();
                    break;
                case 4:
                    saveTaskGroups();
                    break;
                case 5:
                    loadTaskGroups();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    logger.warn("Invalid choice entered: {}", choice);
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        logger.info("Task Manager CLI stopped");
    }

    private static void printMainMenu() {
        System.out.println("\nTask Manager CLI");
        System.out.println("1. Create Task Group");
        System.out.println("2. View All Task Groups");
        System.out.println("3. Manage Task Group");
        System.out.println("4. Save Task Groups");
        System.out.println("5. Load Task Groups");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createTaskGroup() {
        logger.info("Creating new task group");
        System.out.print("Enter task group name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task group description: ");
        String description = scanner.nextLine();

        TaskGroup taskGroup = new TaskGroup();
        taskGroup.setName(name);
        taskGroup.setDescription(description);

        taskManager.addTaskGroup(taskGroup);
        logger.info("Task group '{}' created successfully", name);
        System.out.println("Task group created successfully.");
    }

    private static void viewAllTaskGroups() {
        logger.info("Viewing all task groups");
        List<TaskGroup> allTaskGroups = taskManager.getAllTaskGroups();
        for (TaskGroup tg : allTaskGroups) {
            System.out.println("Task Group: " + tg.getName());
            tg.viewTaskList();
        }
    }

    private static void manageTaskGroup() {
        logger.info("Managing task group");
        System.out.print("Enter task group name to manage: ");
        String name = scanner.nextLine();
        TaskGroup taskGroup = null;

        for (TaskGroup tg : taskManager.getAllTaskGroups()) {
            if (tg.getName().equalsIgnoreCase(name)) {
                taskGroup = tg;
                break;
            }
        }

        if (taskGroup == null) {
            logger.warn("Task group '{}' not found", name);
            System.out.println("Task group not found.");
            return;
        }

        boolean managing = true;
        while (managing) {
            printTaskGroupMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTaskToGroup(taskGroup);
                    break;
                case 2:
                    viewTasksInGroup(taskGroup);
                    break;
                case 3:
                    removeTaskFromGroup(taskGroup);
                    break;
                case 0:
                    managing = false;
                    break;
                default:
                    logger.warn("Invalid choice entered in task group management: {}", choice);
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void printTaskGroupMenu() {
        System.out.println("\nManage Task Group");
        System.out.println("1. Add Task to Group");
        System.out.println("2. View Tasks in Group");
        System.out.println("3. Remove Task from Group");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    private static void addTaskToGroup(TaskGroup taskGroup) {
        logger.info("Adding task to group");
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        TaskItem.Status status = TaskItem.Status.TODO; // Default status

        TaskItem taskItem = new TaskItem(name, description, status);
        taskGroup.addToTL(taskItem);
        logger.info("Task '{}' added to group '{}'", name, taskGroup.getName());
        System.out.println("Task added successfully.");
    }

    private static void viewTasksInGroup(TaskGroup taskGroup) {
        logger.info("Viewing tasks in group");
        taskGroup.viewTaskList();
    }

    private static void removeTaskFromGroup(TaskGroup taskGroup) {
        logger.info("Removing task from group");
        System.out.print("Enter task name to remove: ");
        String name = scanner.nextLine();

        TaskItem taskToRemove = null;
        for (TaskItem task : taskGroup.getTaskList()) {
            if (task.getName().equalsIgnoreCase(name)) {
                taskToRemove = task;
                break;
            }
        }

        if (taskToRemove != null) {
            taskGroup.removeFromTL(taskToRemove);
            logger.info("Task '{}' removed from group '{}'", name, taskGroup.getName());
            System.out.println("Task removed successfully.");
        } else {
            logger.warn("Task '{}' not found in group '{}'", name, taskGroup.getName());
            System.out.println("Task not found.");
        }
    }

    private static void saveTaskGroups() {
        logger.info("Saving task groups to file");
        System.out.print("Enter filename prefix to save task groups: ");
        String filenamePrefix = scanner.nextLine();
        taskManager.objectToXml(taskManager.getAllTaskGroups(), filenamePrefix);
        System.out.println("Task groups saved successfully.");
    }

    private static void loadTaskGroups() {
        logger.info("Loading task groups from file");
        System.out.print("Enter filename to load task groups: ");
        String filename = scanner.nextLine();
        List<TaskGroup> loadedGroups = taskManager.xmlToObject(filename);
        if (loadedGroups != null) {
            for (TaskGroup tg : loadedGroups) {
                taskManager.addTaskGroup(tg);
            }
            logger.info("Task groups loaded successfully from file: {}", filename);
            System.out.println("Task groups loaded successfully.");
        } else {
            logger.warn("Failed to load task groups from file: {}", filename);
            System.out.println("Failed to load task groups.");
        }
    }
}
