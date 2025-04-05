package com.bridgelabz.annotations;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveService {
    private static HashMap<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeSquare(int num) {
        if (cache.containsKey(num)) {
            System.out.println("Returning cached result for: " + num);
            return cache.get(num);
        }

        System.out.println("Computing result for: " + num);
        int result = num * num;
        cache.put(num, result);
        return result;
    }
}

public class CustomAnnotationPractise6 {
    public static void main(String[] args) throws Exception {
        ExpensiveService service = new ExpensiveService();

        Method method = service.getClass().getMethod("computeSquare", int.class);

        int[] inputs = {5, 5, 7, 7, 5};
        for (int input : inputs) {
            if (method.isAnnotationPresent(CacheResult.class)) {
                System.out.println("Result: " + method.invoke(service, input));
            }
        }
    }
}
