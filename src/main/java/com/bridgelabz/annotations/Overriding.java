package com.bridgelabz.annotations;

class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}

public class Overriding{
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
    }
}

