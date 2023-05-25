package com.learntocode;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int lastNameComparison = this.lastName.compareTo(otherPerson.lastName);
        // return lastNameComparison == 0 ? this.firstName.compareTo(otherPerson.firstName) : lastNameComparison;
        if (lastNameComparison != 0) {
            return lastNameComparison;  // Sort by last name
        } else {
            return this.firstName.compareTo(otherPerson.firstName);  // Sort by first name if last names are the same
        }
    }

    @Override
    public String toString() {
        return lastName + ", " + firstName + ", " + age;
    }
}
