package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class CustomAnnottaion {

    // Define Custom Annotation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface TaskInfo {
        int priority();
        String assignedTo();
    }

    // Apply Annotation
    static class TaskManager {
        @TaskInfo(priority = 1, assignedTo = "John Doe")
        public void completeTask() {
            System.out.println("Task completed!");
        }
    }

    // Retrieve Annotation Details Using Reflection
    public static void main(String[] args) {
        Method method = TaskManager.class.getMethods()[0]; // Directly access the first method

        if (method.isAnnotationPresent(TaskInfo.class)) {
            TaskInfo task = method.getAnnotation(TaskInfo.class);
            System.out.println("Priority: " + task.priority());
            System.out.println("Assigned To: " + task.assignedTo());
        }
    }
}

