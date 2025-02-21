import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;
        while (playAgain) 
        {
            int numberToGuess = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("A new round has started! Guess the number between 1 and 100. You have " + maxAttempts + " attempts.");
            while (attempts < maxAttempts && !guessedCorrectly) 
            {
                System.out.println("Enter your guess:");
                int userGuess = scanner.nextInt();
                attempts++;
                if (userGuess == numberToGuess) 
                {
                    guessedCorrectly = true;
                    roundsWon++;
                    System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                } 
                else if (userGuess < numberToGuess) 
                {
                    System.out.println("Too low! Try again.");
                } 
                else 
                {
                    System.out.println("Too high! Try again.");
                }
            }
            if (!guessedCorrectly) 
            {
                System.out.println("You've run out of attempts! The correct number was " + numberToGuess + ".");
            }
            System.out.println("Do you want to play another round? (yes/no)");
            scanner.nextLine();
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
            if (!playAgain) 
            {
                System.out.println("Thanks for playing! You won " + roundsWon + " rounds.");
            }
        }
        scanner.close();
    }
}
