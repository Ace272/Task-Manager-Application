package com.myproject.app;

import static org.junit.Assert.assertEquals;
// import static org.junit.Before;
// import static org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue; // Keep this one

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
//...
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TaskManagerTest {
    private TaskManager taskManager;

    @Mock
    private TaskGroup taskGroup;

    @BeforeEach
    public void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    public void testObjectToXml() {
        // Create a sample TaskGroup and specify the name and description
        String name = "Sample Task Group";
        String desc = "A sample task group";

        // Define the expected file path
        String expectedFilePath = "src/main/resources/Task-Group/Sample Task Group.xml";

        // Mock behavior of the taskGroup object
        Mockito.when(taskGroup.getName()).thenReturn(name);
        Mockito.when(taskGroup.getDescription()).thenReturn(desc);

        // Call the objectToXml method
        taskManager.objectToXml(taskGroup, name, desc);

        // Check if the file exists in the expected path
        File file = new File(expectedFilePath);
        assertTrue(file.exists());
    }
}
