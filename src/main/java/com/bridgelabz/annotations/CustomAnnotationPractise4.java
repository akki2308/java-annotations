package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

// Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class
class User {

    @MaxLength(10)
    String username;

    User(String username) {
        this.username = username;
        for (Field field : this.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                field.setAccessible(true);
                try {
                    String value = (String) field.get(this);
                    int limit = field.getAnnotation(MaxLength.class).value();
                    if (value.length() > limit) {
                        throw new IllegalArgumentException(field.getName() + " too long (max " + limit + ")");
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

// Main class
public class CustomAnnotationPractise4 {
    public static void main(String[] args) {
        new User("ShortName");
        new User("ThisNameIsTooLong");
    }
}
