package com.myproject.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskManagerTest {
    
    private TaskManager taskManager;

    @BeforeEach
    void setUp(){
        taskManager = new TaskManager();
    }

    @Test
    void testAddToAll() {
        // Create a sample TaskItem
        TaskItem taskItem = new TaskItem("SampleTask", "SampleDescription", TaskItem.Status.TODO);

        // Add the sample TaskItem to allTaskItems using the addToAll method
        TaskManager.addToAll(taskItem);

        // Retrieve the allTaskItems list from TaskManager
        List<TaskItem> allTaskItems = TaskManager.getAllTaskItems();

        // Verify that the sample TaskItem was added to the allTaskItems list
        assertEquals(1, allTaskItems.size());
        assertEquals(taskItem, allTaskItems.get(0));

        // You might want to assert other conditions based on your specific requirements
        // For instance, check if the logger was called or not, based on your logging setup.
    }
}