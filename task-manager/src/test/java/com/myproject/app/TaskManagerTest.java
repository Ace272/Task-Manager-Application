package com.myproject.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    }

    @Test
    void testCreateTaskItem() {

        // Call createTaskItem to create a sample TaskItem
        TaskItem createdTaskItem = taskManager.createTaskItem(null, "TaskName", "TaskDescription", TaskItem.Status.TODO);

        // Verify that the created TaskItem is not null
        assertNotNull(createdTaskItem);

        // Verify that the attributes of the created TaskItem match the input values
        assertEquals("TaskName", createdTaskItem.getName());
        assertEquals("TaskDescription", createdTaskItem.getDescription());
        assertEquals(TaskItem.Status.TODO, createdTaskItem.getStatus());
    }
}