package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement user authentication", assignedTo = "Akshit", priority = "HIGH")
    public void userAuth() {
        System.out.println("User authentication logic...");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Srishti")
    public void optimizeDB() {
        System.out.println("Database optimization logic...");
    }
}

public class CustomAnnotationPractise2 {
    public static void main(String[] args) {
        for (Method method : Project.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("----------------------");
            }
        }
    }
}
