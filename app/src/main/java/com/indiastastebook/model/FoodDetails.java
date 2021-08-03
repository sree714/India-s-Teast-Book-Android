package com.indiastastebook.model;

public class FoodDetails {
    private String name;
    private String image;
    private String process;

    public FoodDetails() {
    }

    public FoodDetails(String name, String image, String process) {
        this.name = name;
        this.image = image;
        this.process = process;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getProcess() {
        return process;
    }
}
