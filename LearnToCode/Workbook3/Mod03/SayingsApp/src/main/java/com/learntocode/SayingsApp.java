package com.learntocode;

import java.util.Scanner;

public class SayingsApp {
    public static void main(String[] args) {
        String[] sayings = {
                "All that glitters is not gold",
                "A stitch in time saves nine",
                "Actions speak louder than words",
                "Honesty is the best policy",
                "You can't have your cake and eat it too",
                "The early bird catches the worm",
                "An apple a day keeps the doctor away",
                "There's no place like home",
                "When in Rome, do as the Romans do",
                "You reap what you sow"
        };

        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            try {
                System.out.print("Enter the number of the saying you want to see (1-10): ");
                int index = scanner.nextInt();

                String saying = sayings[index - 1];
                System.out.println(saying);

                System.out.print("Do you want to see another saying? (Y/N): ");
                String answer = scanner.next();

                if (answer.equalsIgnoreCase("N")) {
                    continueLoop = false;
                }
            } catch (Exception exception) {
                System.out.println("Invalid index, please enter a number between 1 and 10");
                scanner.next();
            }
        }
    }
}
