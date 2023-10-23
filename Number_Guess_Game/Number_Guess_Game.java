import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Number_Guess_Game {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int ATTEMPTS_LIMIT = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            playRound(random, scanner);
            if (!askToPlayAgain(scanner)) {
                break;
            }
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }

    private static void playRound(Random random, Scanner scanner) {
        int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
        int remainingAttempts = ATTEMPTS_LIMIT;

        System.out.println("Guess a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ":");
        System.out.println("You have "+ATTEMPTS_LIMIT+ " Attempts to guess Correct number");


        while (remainingAttempts > 0) {
            int userGuess = getUserGuess(scanner);

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You guessed the number.");
                return;
            } else if (userGuess > targetNumber) {
                System.out.println("Your guess is too high.  " );
            } else {
                System.out.println("Your guess is too low.  " );
            }

            remainingAttempts--;
        }

        System.out.println("Sorry, you're out of attempts. The correct number was " + targetNumber + ".");
    }

    private static int getUserGuess(Scanner scanner) {
        int userGuess = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                userGuess = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume the invalid input
            }
        }

        return userGuess;
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Would you like to play again? (Yes/No):");

        while (true) {
            String response = scanner.next().toLowerCase();

            if (response.equals("yes")) {
                return true;
            } else if (response.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
            }
        }
    }
}
