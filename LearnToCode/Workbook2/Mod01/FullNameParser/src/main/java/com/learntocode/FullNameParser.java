package com.learntocode;

import java.util.Scanner;

public class FullNameParser {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt user to enter name
        System.out.print("Please enter your name: ");
        String name = input.nextLine().trim(); // Trim leading/trailing spaces

        // Split name into parts
        String[] parts = name.split(" "); // Split by whitespace

        // Determine number of parts and extract first/last name
        String firstName = parts[0];
        String lastName = parts[parts.length - 1];
        String middleName = "";

        if (parts.length == 3) { // First, middle, last name format
            middleName = parts[1];
        }

        // Display name parts
        System.out.println("First name: " + firstName);
        System.out.println("Middle name: " + middleName);
        System.out.println("Last name: " + lastName);
    }
}

