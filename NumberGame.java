import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;  // Track number of rounds won
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have a limited number of attempts to guess the correct number.");

        while (playAgain) {
            int min = 1;
            int max = 100;
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attemptsLeft = 7;  // Limit number of attempts
            boolean guessedCorrectly = false;
            int userGuess;

            System.out.println("\nA new number has been generated between " + min + " and " + max + ".");
            System.out.println("You have " + attemptsLeft + " attempts to guess the correct number.");

            // User guessing loop
            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();

                // Compare the guess with the generated number
                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    roundsWon++;  // Increment rounds won
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
                
                attemptsLeft--;
                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            // If user didn't guess correctly
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've run out of attempts. The correct number was " + randomNumber);
            }

            // Ask if the user wants to play another round
            System.out.print("\nWould you like to play another round? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        // Display the user's score (number of rounds won)
        System.out.println("\nGame Over! You won " + roundsWon + " round(s).");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
