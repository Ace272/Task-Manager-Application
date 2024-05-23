package com.myproject.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    public static List<TaskItem> allTaskItems = new ArrayList<>();
    private List<TaskGroup> allTaskGroups;
    private static final Logger logger = LogManager.getLogger(TaskManager.class);

    public TaskManager() {
        allTaskGroups = new ArrayList<>();
    }

    // method adding to allTaskItems
    public static void addToAll(TaskItem newItem) {
        allTaskItems.add(newItem);
        logger.info("Added task item to allTaskItems: " + newItem.getName());
    }

    // method to remove from allTaskItems
    public static void delToAll(TaskItem delItem) {
        allTaskItems.remove(delItem);
        logger.info("Removed task item from allTaskItems: " + delItem.getName());
    }

    // method to return allTaskItems
    public static List<TaskItem> getAllTaskItems() {
        return new ArrayList<>(allTaskItems); // Return a copy to avoid external modifications
    }

    // method to view allTaskItems
    public static void viewAllTasks() {
        int num = 1;
        for (TaskItem task : allTaskItems) {
            System.out.println("Task " + num + ":");
            System.out.println(task);
            num++;
        }
        logger.info("All Tasks were displayed");
    }

    // method to create a task Item
    public TaskItem createTaskItem(TaskItem taskItemobj, String name, String desc, TaskItem.Status stat) {
        taskItemobj = new TaskItem(name, desc, stat);
        logger.info("Created a new task item: " + name);
        return taskItemobj;
    }

    // add new item to task group list
    public void addNewToTGList(TaskGroup tg, TaskItem taskItemobj, String name, String desc, TaskItem.Status stat) {
        taskItemobj = new TaskItem(name, desc, stat);
        tg.addToTL(taskItemobj);
        tg.viewTaskList();
        logger.info("Added task item to task group list: " + taskItemobj.getName());
    }

    // add existing taskItem to task group list
    public void addToTGList(TaskGroup tg, TaskItem ti) {
        tg.addToTL(ti);
        tg.viewTaskList();
        logger.info("Added an existing task item to task group list: " + ti.getName());
    }

    // TaskGroup Managing Functions
    public void addTaskGroup(TaskGroup taskGroup) {
        allTaskGroups.add(taskGroup);
        logger.info("Added task group: {}", taskGroup.getName());
    }

    public List<TaskGroup> getAllTaskGroups() {
        logger.info("Retrieving all task groups");
        return allTaskGroups;
    }

    // File handling
    // Marshalling
    public void objectToXml(List<TaskGroup> taskGroups, String filenamePrefix) {
        try {
            // Create a JAXB context for the TaskGroup class
            JAXBContext contextObj = JAXBContext.newInstance(TaskGroup.class);

            // Create a marshaller
            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Create the output XML file directory
            String taskGroupDirectoryPath = "src/main/resources/Task-Group/";
            File directory = new File(taskGroupDirectoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Marshal each TaskGroup in the list to separate XML files
            for (TaskGroup taskGroup : taskGroups) {
                String fileName = taskGroupDirectoryPath + filenamePrefix + "_" + taskGroup.getName() + ".xml";
                marshallerObj.marshal(taskGroup, new File(fileName));
                logger.info("Marshalled TaskGroup to XML file: {}", fileName);
            }
        } catch (JAXBException e) {
            logger.error("JAXB Error: {}", e.getMessage());
            e.printStackTrace();
            System.out.println("JAXB Error");
        } catch (Exception e) {
            logger.error("General Error: {}", e.getMessage());
            e.printStackTrace();
            System.out.println("General Error");
        }
    }

    // Unmarshalling
    public List<TaskGroup> xmlToObject(String xmlFileName) {
        try {
            // Create a JAXB context for the TaskGroup class
            JAXBContext contextObj = JAXBContext.newInstance(TaskGroup.class);

            // Create an unmarshaller
            Unmarshaller unmarshaller = contextObj.createUnmarshaller();

            // Unmarshal the XML file and cast it to a TaskGroup object
            TaskGroup taskGroup = (TaskGroup) unmarshaller.unmarshal(new File(xmlFileName));
            logger.info("Unmarshalled XML file to TaskGroup object: " + xmlFileName);
            List<TaskGroup> taskGroups = new ArrayList<>();
            taskGroups.add(taskGroup);

            return taskGroups;
        } catch (JAXBException e) {
            logger.error("JAXB Unmarshalling Error: " + e.getMessage());
            e.printStackTrace();
            System.out.println("JAXB Unmarshalling Error");
            return null;
        } catch (Exception e) {
            logger.error("Some general problem occurred: " + e.getMessage());
            e.printStackTrace();
            System.out.println("Some general problem occurred");
            return null;
        }
    }
}
