package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Task {
    @ImportantMethod
    public void processTask() {
        System.out.println("Processing task...");
    }

    @ImportantMethod(level = "MEDIUM")
    public void validateTask() {
        System.out.println("Validating task...");
    }
}

public class CustomAnnotationPractise1 {
    public static void main(String[] args) {
        for (Method method : Task.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Important Method: " + method.getName() + " (Level: " + annotation.level() + ")");
            }
        }
    }
}
