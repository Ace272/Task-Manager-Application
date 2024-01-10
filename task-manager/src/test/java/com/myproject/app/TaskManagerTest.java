package com.myproject.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TaskManagerTest {
    
    private TaskManager taskManager;

    @BeforeEach
    void setUp(){
        taskManager = new TaskManager();
        TaskManager.allTaskItems.clear();
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

        for(TaskItem task: allTaskItems){
            System.out.println(task.getName());
        }
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

    @Test
    void testAddNewToTGList() {
        // Create a sample TaskItem
        TaskItem taskItem = new TaskItem("SampleTask", "SampleDescription", TaskItem.Status.TODO);

        // Create a mock TaskGroup
        TaskGroup mockTaskGroup = mock(TaskGroup.class);

        // Add the sample TaskItem to the task group list using addNewToTGList method
        taskManager.addNewToTGList(mockTaskGroup, null, "TaskName", "TaskDescription", TaskItem.Status.TODO);

        // Verify that addToTL method of the mock TaskGroup was called
        verify(mockTaskGroup).addToTL(taskItem);

        // Verify that the task group list was viewed
        verify(mockTaskGroup).viewTaskList();
    }
}