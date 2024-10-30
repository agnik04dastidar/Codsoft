import java.util.Random;
import java.util.Scanner;

class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int correctNumber = r.nextInt(100) + 1; 
            int a = 0;
            System.out.println("Enter the maximum number of attempts: ");
            int maxAttempts = sc.nextInt(); 
            int totalScore = 0;
            boolean correctGuess = false;

            System.out.println("The game starts!");
            System.out.println("A number between 1 and 100 has been selected.");

            while (a < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                a++;

                if (guess == correctNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + correctNumber);
                    correctGuess = true;
                    totalScore += (maxAttempts - a + 1);
                } else if (guess < correctNumber) {
                    System.out.println("Lower than the correct number! Try again.");
                } else {
                    System.out.println("Higher than the correct number! Try again.");
                }

                System.out.println("Remaining attempts: " + (maxAttempts - a));
            }

            if (!correctGuess) {
                System.out.println("Game Over! The number was: " + correctNumber);
            }
            
            System.out.println("Your score: " + totalScore);
            System.out.print("Would you like to play again? (yes/no): ");
            String response = sc.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Goodbye!");
    }
}
