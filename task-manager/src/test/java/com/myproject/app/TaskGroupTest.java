package com.myproject.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TaskGroupTest {
    TaskItem ti1 = new TaskItem("joe", "For the doe", TaskItem.Status.IN_PROGRESS);
    TaskItem ti2 = new TaskItem("Location", "For the opportunity", TaskItem.Status.DONE);
    TaskItem ti3 = new TaskItem("Row", "Square it in", TaskItem.Status.TODO);

    @Test
    public void createTaskGroupObj(){
        TaskGroup tg1 = new TaskGroup();
        tg1.setName("Hello");
        tg1.setDescription("First one");

        assertEquals("Hello", tg1.getName());
        assertEquals("First one", tg1.getDescription());
    };

    @Test
    public void testGetTaskList(){
        //create a task group obj
        TaskGroup tgl = new TaskGroup();
        tgl.setName("yolo");
        tgl.setDescription("This and that");

        //Add task items to the task list
        tgl.addToTL(ti1);
        tgl.addToTL(ti2);

        //test if these task items have been added
        assertTrue(tgl.getTaskList().contains(ti1));
        assertTrue(tgl.getTaskList().contains(ti2));
    };

    @Test
    public void testViewTasklist(){
        //create a task group obj
        TaskGroup tvl = new TaskGroup();
        tvl.setName("holo");
        tvl.setDescription("to and fro");

        //Add task items to the task list
        tvl.addToTL(ti1);
        tvl.addToTL(ti3);

        // Use view task list to view it on console
        tvl.viewTaskList();
    }
}
