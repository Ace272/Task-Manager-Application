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
}
