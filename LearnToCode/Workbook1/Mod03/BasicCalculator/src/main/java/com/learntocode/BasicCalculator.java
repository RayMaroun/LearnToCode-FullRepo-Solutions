package com.learntocode;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // read in the two numbers
        System.out.print("Enter the first number: ");
        double num1 = input.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = input.nextDouble();

        // ask the user for the operation
        System.out.print("Enter the operation (+, -, *, /): ");
        String operation = input.next();

        // perform the operation
        double result = 0;
        if (operation.equals("+")) {
            result = num1 + num2;
        } else if (operation.equals("-")) {
            result = num1 - num2;
        } else if (operation.equals("*")) {
            result = num1 * num2;
        } else if (operation.equals("/")) {
            result = num1 / num2;
        } else {
            System.out.println("Invalid operation.");
            return;
        }

        // display the result
        System.out.println("The result is: " + result);
    }
}

