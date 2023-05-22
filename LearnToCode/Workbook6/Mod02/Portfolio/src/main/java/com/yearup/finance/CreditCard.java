package com.yearup.finance;

public class CreditCard implements Valuable {
    private String cardNumber;
    private double balance;

    public CreditCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void charge(double amount) {
        balance += amount;
    }

    public void pay(double amount) {
        balance -= amount;
    }

    public double getValue() {
        return -balance; // Negative balance represents debt on credit card
    }
}
