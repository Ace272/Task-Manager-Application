package com.myproject.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

public class TaskManager{
    public static List<TaskItem> allTaskItems = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(TaskManager.class);

    TaskManager(){
        //placeholder
    }

    // method adding to allTaskItems
    public static void addToAll(TaskItem newItem){
        allTaskItems.add(newItem);
        logger.info("Added task item to allTaskItems: " + newItem.getName());
    }
    //method to remove from allTaskItems
    public static void delToAll(TaskItem delItem){
        allTaskItems.remove(delItem);
        logger.info("Removed task item from allTaskItems: " + delItem.getName());
    }
    //method to view allTaskItems
    public static void viewAllTasks(){
        for(TaskItem task: allTaskItems){
            logger.info("Task: " + task.getName());
            System.out.println(task);
        }
    }

    //method to create a task Item
    public TaskItem createTaskItem(TaskItem taskItemobj, String name, String desc, TaskItem.Status stat){
        taskItemobj = new TaskItem(name, desc, stat);
        logger.info("Created a new task item: " + name);
        return taskItemobj;
    }

    // add new item to task group list
    public void addNewToTGList(TaskGroup tg, TaskItem taskItemobj, String name, String desc, TaskItem.Status stat ){
        taskItemobj = new TaskItem(name, desc, stat);
        tg.addToTL(taskItemobj);
        tg.viewTaskList();
        logger.info("Added task item to task group list: " + taskItemobj.getName());
    }

    //add existing taskItem to task group list
    public void addToTGList(TaskGroup tg, TaskItem ti){
        tg.addToTL(ti);
        tg.viewTaskList();
        logger.info("Added an existing task item to task group list: " + ti.getName());
    }
    //File time

    //Marshalling
    public void objectToXml(TaskGroup tg, String name, String desc) {
    try {
        // Create a JAXB context for the TaskGroup class
        JAXBContext contextObj = JAXBContext.newInstance(TaskGroup.class);

        // Create a marshaller
        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Set the name and description for the TaskGroup
        tg.setName(name);
        tg.setDescription(desc);


        // Create the output XML file
        String taskGroupDirectoryPath = "src/main/resources/Task-Group/";
        String fileName = taskGroupDirectoryPath + tg.getName() + ".xml";

        // Ensure the directory exists, creating it if necessary
        File directory = new File(taskGroupDirectoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Marshal the TaskGroup to the XML file
        marshallerObj.marshal(tg, new File(fileName));
        logger.info("Marshalled TaskGroup to XML file: " + fileName);
    } catch (JAXBException e) {
        logger.error("JAXB Error: " + e.getMessage());
        e.printStackTrace();
        System.out.println("JAXB Error");
    } catch (Exception e) {
        logger.error("General Error: " + e.getMessage());
        e.printStackTrace();
        System.out.println("General Error");
    }
}

    //Unmarshalling
    public TaskGroup xmlToObject(String xmlFileName) {
        try {
            // Create a JAXB context for the TaskGroup class
            JAXBContext contextObj = JAXBContext.newInstance(TaskGroup.class);

            // Create an unmarshaller
            Unmarshaller unmarshaller = contextObj.createUnmarshaller();

            // Unmarshal the XML file and cast it to a TaskGroup object
            logger.info("Unmarshalled XML file to TaskGroup object: " + xmlFileName);
            return (TaskGroup) unmarshaller.unmarshal(new File(xmlFileName));
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