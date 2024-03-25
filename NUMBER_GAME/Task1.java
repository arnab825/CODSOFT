package NUMBER_GAME;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomGenerator = new Random();
        
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 7;
        int totalScore = 0;
        
        System.out.println("<----Welcome to the Number Guessing Game!---->\n");
        boolean playAnotherRound = true;
        
        while (playAnotherRound) {
            int secretNumber = randomGenerator.nextInt(maxNumber - minNumber + 1) + minNumber;
            System.out.printf("Round - Range: %d to %d\n", minNumber, maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.\n");
            
            int attempts = 0;
            boolean correctlyGuessed = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                attempts++;
                
                if (userGuess == secretNumber) {
                    System.out.printf("Correct! You  have guessed the number in %d attempts.\n", attempts);
                    totalScore += attempts;
                    correctlyGuessed = true;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.\n");
                } else {
                    System.out.println("Too high! Try again.\n");
                }
            }
            
            if (!correctlyGuessed) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + secretNumber);
                System.out.println("Please try again later.\n");
            }
            
            System.out.println("Your current score is " + totalScore + "\n");
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAnotherRound = true;
                maxAttempts-=1;
            }
        }
        
        System.out.println("Thank you for playing! Your final score is " + totalScore);
        
        scanner.close();
    }
}
