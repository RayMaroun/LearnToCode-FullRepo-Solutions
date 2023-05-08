package com.learntocode;

public class Person {
    String firstName;
    private String lastName;
    private int age;
    private int height;
    private String eyeColor;

    public Person(String firstName, String lastName, int age, int height, String eyeColor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    public String getFullNameAndAge(){
        return this.firstName + " " + this.lastName + " " + this.age;
    }

    public String getFirstNameCapital(){
        return this.firstName.toUpperCase();
    }

    public void walk(int distance){
        System.out.println("This person has walked " + distance + " km");
    }

    public void changeEyeColor(String newColor){
        this.eyeColor = newColor;
    }

    public boolean isAdult(){
        return this.age > 18;
    }

}
