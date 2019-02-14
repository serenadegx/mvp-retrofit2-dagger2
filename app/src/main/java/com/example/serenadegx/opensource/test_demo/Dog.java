package com.example.serenadegx.opensource.test_demo;

public class Dog {
    private String breed;
    private String name;
    private String gender;

    public Dog(String breed, String name, String gender) {
        this.breed = breed;
        this.name = name;
        this.gender = gender;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {

        return breed;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }
}
