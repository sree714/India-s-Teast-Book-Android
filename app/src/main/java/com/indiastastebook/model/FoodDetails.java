package com.indiastastebook.model;

public class FoodDetails {
    private String id;
    private String name;
    private String image;
    private String process;

    public FoodDetails() {
    }

    public FoodDetails(String id, String name, String image, String process) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.process = process;
    }

    public String getId() {
        return id;
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
