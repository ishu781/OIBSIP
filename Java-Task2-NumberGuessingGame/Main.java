import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        char playAgain = 'Y';

        do {

            System.out.println("====================================");
            System.out.println("      NUMBER GUESSING GAME");
            System.out.println("====================================");
            System.out.println("Choose Difficulty Level");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            int randomNumber;
            int maxAttempts;

            switch (choice) {
                case 1:
                    randomNumber = random.nextInt(50) + 1;
                    maxAttempts = 10;
                    System.out.println("\nEasy Mode (1 - 50)");
                    break;

                case 2:
                    randomNumber = random.nextInt(100) + 1;
                    maxAttempts = 7;
                    System.out.println("\nMedium Mode (1 - 100)");
                    break;

                case 3:
                    randomNumber = random.nextInt(200) + 1;
                    maxAttempts = 5;
                    System.out.println("\nHard Mode (1 - 200)");
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            int attempts = 0;
            boolean guessed = false;

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == randomNumber) {
                    guessed = true;
                    System.out.println("\nCongratulations! You guessed the number.");
                    break;
                } else if (guess > randomNumber) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nGame Over!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("\n========== Round Summary ==========");
            System.out.println("Attempts Used : " + attempts);
            System.out.println("Result        : " + (guessed ? "Won" : "Lost"));
            System.out.println("==================================");

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

            System.out.println();

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("Thank you for playing!");

        sc.close();
    }
}
