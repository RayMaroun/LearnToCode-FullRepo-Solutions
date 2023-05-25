package com.yearup.finance;

public class Vehicle extends Asset {
    private int year;
    private String make;
    private String model;
    private String condition;

    public Vehicle(int year, String make, String model, String condition) {
        super("Vehicle", 0); // Set initial value to 0 for Vehicle
        this.year = year;
        this.make = make;
        this.model = model;
        this.condition = condition;
    }

    @Override
    public double getValue() {
        // Add your specific calculation for Vehicle value here
        double baseValue = 0; // Set the base value for Vehicle
        // Calculate the value based on year, make, model, condition, etc.
        return baseValue + 10000; // Dummy value for illustration
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
