package com.myproject.app;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class TaskGroupTest {

    @Test
    public void testAddToTL() {
        // Create an instance of TaskGroup
        TaskGroup taskGroup = new TaskGroup();

        // Create a sample TaskItem
        TaskItem taskItem = new TaskItem("Sample Name", "Sample Description", TaskItem.Status.TODO);

        // Add the sample TaskItem to the TaskGroup using the addToTL method
        taskGroup.addToTL(taskItem);

        // Retrieve the task list from the TaskGroup
        List<TaskItem> taskList = taskGroup.getTaskList();

        // Assert that the task list contains the added task
        assertTrue(taskList.contains(taskItem));
    }

    @Test
    public void testRemoveFromTL() {
        // Create a TaskGroup and add some TaskItems to its taskList
        TaskGroup taskGroup = new TaskGroup();
        TaskItem task1 = new TaskItem("Task 1", "Description 1", TaskItem.Status.TODO);
        TaskItem task2 = new TaskItem("Task 2", "Description 2", TaskItem.Status.IN_PROGRESS);
        taskGroup.addToTL(task1);
        taskGroup.addToTL(task2);

        // Remove a TaskItem
        taskGroup.removeFromTL(task1);

        // Assert that the taskList no longer contains task1
        assertFalse(taskGroup.getTaskList().contains(task1));

        // Assert that the taskList still contains task2
        assertTrue(taskGroup.getTaskList().contains(task2));
    }

}
