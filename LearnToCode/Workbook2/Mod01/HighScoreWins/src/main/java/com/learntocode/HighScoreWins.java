package com.learntocode;

import java.util.Scanner;

public class HighScoreWins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a score: ");
        String input = scanner.nextLine();

        // Split the input string into team names and scores
        String[] parts = input.split("\\|");
        String homeTeam = parts[0].split(":")[0];
        String visitorTeam = parts[0].split(":")[1];
        int homeScore = Integer.parseInt(parts[1].split(":")[0]);
        int visitorScore = Integer.parseInt(parts[1].split(":")[1]);

        // Determine the winning team and display its name
        String winner = homeScore > visitorScore ? homeTeam : visitorTeam;

        System.out.println("Winner: " + winner);
    }
}

