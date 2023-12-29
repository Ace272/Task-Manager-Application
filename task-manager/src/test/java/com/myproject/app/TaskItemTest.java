package com.myproject.app;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaskItemTest {

    @Test
    public void testTaskItemCreation() {
        // Create a task item
        TaskItem taskItem = new TaskItem("Task 1", "Description 1", TaskItem.Status.TODO);

        // Check if the values are set correctly
        assertEquals("Task 1", taskItem.getName());
        assertEquals("Description 1", taskItem.getDescription());
        assertEquals(TaskItem.Status.TODO, taskItem.getStatus());
    }

    @Test
    public void testTaskItemModification() {
        // Create a task item
        TaskItem taskItem = new TaskItem("Task 1", "Description 1", TaskItem.Status.TODO);

        // Modify the task item
        taskItem.setName("Updated Task");
        taskItem.setDescription("Updated Description");
        taskItem.setStatus(TaskItem.Status.DONE);

        // Check if the values are modified correctly
        assertEquals("Updated Task", taskItem.getName());
        assertEquals("Updated Description", taskItem.getDescription());
        assertEquals(TaskItem.Status.DONE, taskItem.getStatus());
    }

    @Test
    void testTaskItemValueRetrieval(){
        // Create Field Values
        String taskName = "Tested Task";
        String taskDesc = "Description of tested task";
        Status taskStat = TaskItem.Status.IN_PROGRESS;

        // Create task item with the variables made
        TaskItem t1 = new TaskItem(taskName, taskDesc, taskStat);

        // Check if the values are input correctly
        asserEquals(taskName,t1.getName());
        asserEquals(taskDesc, t1.getDescription());
        asserEquals(taskStat, t1.getStatus());
    }
}
