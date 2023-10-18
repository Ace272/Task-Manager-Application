package com.myproject.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
    }

    // @Test
    // public void testObjectToXml() {
    //     // Create a sample TaskGroup and specify the name and description
    //     TaskGroup tg = new TaskGroup();
    //     String name = "Sample Task Group";
    //     String desc = "A sample task group";

    //     // Define the expected file path
    //     String expectedFilePath = "src/main/resources/Task-Group/Sample Task Group.xml";

    //     // Call the objectToXml method
    //     taskManager.objectToXml(tg, name, desc);

    //     // Check if the file exists in the expected path
    //     File file = new File(expectedFilePath);
    //     assertTrue(file.exists());
    // }
}
