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
}
