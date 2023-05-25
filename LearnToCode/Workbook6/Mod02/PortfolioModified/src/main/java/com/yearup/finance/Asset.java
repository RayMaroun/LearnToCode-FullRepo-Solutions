package com.yearup.finance;

public abstract class Asset implements Valuable {
    private String name;
    private double value;

    public Asset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public abstract double getValue();
}
