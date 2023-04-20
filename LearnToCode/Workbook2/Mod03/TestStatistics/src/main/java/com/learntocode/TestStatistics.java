package com.learntocode;

public class TestStatistics {
    public static void main(String[] args) {
        // Create an array of 10 test scores
        int[] scores = {87, 91, 65, 98, 75, 82, 90, 79, 88, 94};

        // Initialize variables to calculate average, high score, and low score
        int sum = 0;
        int highScore = scores[0];
        int lowScore = scores[0];

        // Loop through each score in the array
        for (int i = 0; i < scores.length; i++) {
            // Calculate the sum of all scores
            sum += scores[i];
            // Check if the current score is higher than the previous high score
            if (scores[i] > highScore) {
                highScore = scores[i];
            }
            // Check if the current score is lower than the previous low score
            if (scores[i] < lowScore) {
                lowScore = scores[i];
            }
        }

        // Calculate the average score by dividing the sum by the number of scores
        double average = (double) sum / scores.length;

        // Print out the average, high score, and low score
        System.out.printf("Average: %.2f\n", average);
        System.out.println("High score: " + highScore);
        System.out.println("Low score: " + lowScore);

        // Bonus: Calculate and display the mean value
        double sumOfSquaredDifferences = 0;
        // Loop through each score in the array again
        for (int i = 0; i < scores.length; i++) {
            // Calculate the sum of the squared differences between each score and the average
            sumOfSquaredDifferences += Math.pow(scores[i] - average, 2);
        }
        // Calculate the variance by dividing the sum of squared differences by the number of scores
        double variance = sumOfSquaredDifferences / scores.length;
        // Calculate the standard deviation by taking the square root of the variance
        double standardDeviation = Math.sqrt(variance);
        // Calculate the mean value by subtracting 1.645 times the standard deviation from the average
        System.out.printf("Mean value: %.2f\n", average - 1.645 * standardDeviation);
    }
}

