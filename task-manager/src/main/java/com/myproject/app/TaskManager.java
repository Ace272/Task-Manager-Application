package com.myproject.app;

import java.util.*;
import java.io.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

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

        // Marshal the TaskGroup to the XML file
        marshallerObj.marshal(tg, new File(fileName));
    } catch (JAXBException e) {
        e.printStackTrace();
        System.out.println("JAXB Error");
    } catch (Exception e) {
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
            return (TaskGroup) unmarshaller.unmarshal(new File(xmlFileName));
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("JAXB Unmarshalling Error");
            return null; 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some general problem occurred");
            return null;
        }
    }

}