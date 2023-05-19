package com.example.api_cats;

public class CatBreed {
    private String name;
    private String origin;
    private int intelligence;
    private String image;

    public CatBreed(String name, String origin, int intelligence, String image) {
        this.name = name;
        this.origin = origin;
        this.intelligence = intelligence;
        this.image = image;
    }

    // Constructor, getters y setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}