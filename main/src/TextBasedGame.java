import java.util.Scanner;

public class TextBasedGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int secretNumber = (int) (Math.random() * 50) + 1;
            int attempts = 0;
            boolean isGameOver = false;
            String playerName;

            System.out.println("Welcome to Eric's Guessing Game!");
            System.out.print("What's your name?");
            playerName = scanner.nextLine();
            System.out.println("Hello, " + playerName + "! Let's play!");
            System.out.println("I'm thinking of a number between 1 and 50.");

            while (!isGameOver) {
                System.out.print("Take your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == (secretNumber + 2)) {
                    System.out.println("Just a little lower!");
                } else if (guess == (secretNumber - 2)) {
                    System.out.println("Just a little higher!");
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Guess a higher number!");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! Guess lower...");
                } else {
                    System.out.println("Congratulations, " + playerName + "! You guessed the right number " + secretNumber + " correctly!");
                    System.out.println("Number of attempts: " + attempts);
                    isGameOver = true;
                }

                if (attempts >= 5) {
                    System.out.println("Sorry, " + playerName + "! You've reached the maximum number of attempts.");
                    System.out.println("The secret number was " + secretNumber + ". Better luck next time!");
                    isGameOver = true;
                }
            }

            int score = calculateScore(attempts);
            displayScore(score);


            playAgain();
        }
    }

    public static int calculateScore(int attempts) {
        int score = 5 - (attempts);
        return score;
    }

    public static void displayScore(int score) {
        System.out.println("Your score: " + score);
    }



    public static void playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.println("Let's play again!");
            main(null);
        } else {
            System.out.println("Aw ok, thank you for playing. Goodbye!");
        }
    }
}