import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        // Random object to generate random numbers
        Random random = new Random();
        // Variable to control playing again
        String playAgain;
        // Variable to store the user's score
        int score = 0;

        do {
            // Generate a random number between 1 and 100
            int numberToGuess = random.nextInt(100) + 1;
            // Number of attempts allowed
            int attempts = 10;
            // Flag to check if the user has guessed correctly
            boolean hasGuessedCorrectly = false;

            System.out.println("------------------------------------");
            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + attempts + " attempts to guess it. Good luck!");
            System.out.println("------------------------------------");


            // Loop for the current round's attempts
            while (attempts > 0) {
                System.out.print("Enter your guess (" + attempts + " attempts left): ");
                
                // Validate that the input is an integer
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    // Clear the invalid input from the scanner
                    scanner.next(); 
                    continue; // Skip the rest of the loop and ask for input again
                }
                
                int userGuess = scanner.nextInt();
                attempts--;

                // Compare the user's guess with the generated number
                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the correct number!");
                    hasGuessedCorrectly = true;
                    // Award points based on remaining attempts
                    score += (attempts + 1); 
                    break; // Exit the loop since the guess is correct
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            // If the user ran out of attempts without guessing correctly
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            // Display the current score
            System.out.println("Your current score is: " + score);

            // Ask the user if they want to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // Thank the user for playing and show the final score
        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}
