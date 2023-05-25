package com.yearup.finance;

import java.util.Scanner;

public class FinanceApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a portfolio
        Portfolio portfolio = new Portfolio("My Portfolio", "John");

        while (true) {
            System.out.println("Enter the type of asset (Jewelry, Gold, Vehicle, BankAccount, CreditCard) or 'quit' to exit:");
            String assetType = scanner.nextLine();

            if (assetType.equalsIgnoreCase("quit")) {
                break;
            }

            switch (assetType.toLowerCase()) {
                case "jewelry":
                    System.out.println("Enter the karat value:");
                    double karat = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Jewelry jewelry = new Jewelry(karat);
                    portfolio.add(jewelry);
                    break;
                case "gold":
                    System.out.println("Enter the weight:");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    Gold gold = new Gold(weight);
                    portfolio.add(gold);
                    break;
                case "vehicle":
                    System.out.println("Enter the year:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter the make:");
                    String make = scanner.nextLine();
                    System.out.println("Enter the model:");
                    String model = scanner.nextLine();
                    System.out.println("Enter the condition:");
                    String condition = scanner.nextLine();
                    Vehicle vehicle = new Vehicle(year, make, model, condition);
                    portfolio.add(vehicle);
                    break;
                case "bankaccount":
                    System.out.println("Enter the account ID:");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("Enter the owner name:");
                    String owner = scanner.nextLine();
                    System.out.println("Enter the balance:");
                    double bankAccountBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    BankAccount bankAccount = new BankAccount(id, owner, bankAccountBalance);
                    portfolio.add(bankAccount);
                    break;
                case "creditcard":
                    System.out.println("Enter the card number:");
                    String cardNumber = scanner.nextLine();
                    System.out.println("Enter the balance:");
                    double creditCardBalance = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character
                    CreditCard creditCard = new CreditCard(cardNumber, creditCardBalance);
                    portfolio.add(creditCard);
                    break;
                default:
                    System.out.println("Invalid asset type. Please try again.");
                    break;
            }
        }

        // Print the portfolio value
        double portfolioValue = portfolio.getValue();
        System.out.println("Portfolio Value: $" + portfolioValue);

        // Get the most valuable asset
        Valuable mostValuableAsset = portfolio.getMostValuable();
        System.out.println("Most Valuable Asset(Value: " + mostValuableAsset.getValue() + "): " + mostValuableAsset);

        // Get the least valuable asset
        Valuable leastValuableAsset = portfolio.getLeastValuable();
        System.out.println("Least Valuable Asset(Value: " + leastValuableAsset.getValue() + "): " + leastValuableAsset);
    }
}
