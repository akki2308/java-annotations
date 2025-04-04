package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.time.Duration;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Task1 {
    @LogExecutionTime
    public void fastTask() {
        for (int i = 0; i < 1000; i++); // Simulating fast task
    }

    @LogExecutionTime
    public void slowTask() {
        for (int i = 0; i < 1_000_000; i++); // Simulating slow task
    }
}

// Step 3: Measure Execution Time Dynamically
public class CustomAnnotationPractise3 {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        for (Method method : Task.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(task);
                long end = System.nanoTime();
                System.out.println(method.getName() + " took " + Duration.ofNanos(end - start).toMillis() + " ms");
            }
        }
    }
}
