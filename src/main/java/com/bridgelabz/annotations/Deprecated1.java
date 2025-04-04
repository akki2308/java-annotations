package com.bridgelabz.annotations;

class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Warning: This is an old feature.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature.");
    }
}

// Main class to test the methods
public class Deprecated1 {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        api.oldFeature();
        api.newFeature();
    }
}

