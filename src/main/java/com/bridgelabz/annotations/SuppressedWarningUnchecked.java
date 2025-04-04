package com.bridgelabz.annotations;

import java.util.ArrayList;

public class SuppressedWarningUnchecked {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // No generics
        list.add("Java"); list.add(100); list.add(45.6);

        System.out.println((String) list.get(0));
        System.out.println((Integer) list.get(1));
        System.out.println((Double) list.get(2));
    }
}

