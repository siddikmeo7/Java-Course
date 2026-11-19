import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String[] CHOICES = {"Rock", "Paper", "Scissors"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("=================================");
        System.out.println("  Welcome to Rock Paper Scissors!");
        System.out.println("=================================");
        System.out.println();

        while (true) {
            System.out.print("Choose (Rock, Paper, Scissors) or 'quit' to exit: ");
            String playerInput = scanner.nextLine().trim();

            if (playerInput.equalsIgnoreCase("quit")) {
                break;
            }

            // Validate input
            boolean valid = false;
            for (String choice : CHOICES) {
                if (playerInput.equalsIgnoreCase(choice)) {
                    valid = true;
                    break;
                }
            }

            if (!valid) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.\n");
                continue;
            }

            // Normalize player choice
            String playerChoice = CHOICES[0];
            for (String choice : CHOICES) {
                if (playerInput.equalsIgnoreCase(choice)) {
                    playerChoice = choice;
                    break;
                }
            }

            // Computer choice
            String computerChoice = CHOICES[random.nextInt(CHOICES.length)];

            System.out.println("You: " + playerChoice);
            System.out.println("Computer: " + computerChoice);

            // Determine result
            if (playerChoice.equals(computerChoice)) {
                System.out.println("Result: It's a draw!\n");
                draws++;
            } else if (winsAgainst(playerChoice, computerChoice)) {
                System.out.println("Result: You win!\n");
                wins++;
            } else {
                System.out.println("Result: You lose!\n");
                losses++;
            }
        }

        // Final score
        System.out.println("=================================");
        System.out.println("  Final Score");
        System.out.println("=================================");
        System.out.println("Wins:   " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws:  " + draws);
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static boolean winsAgainst(String a, String b) {
        return (a.equals("Rock") && b.equals("Scissors")) ||
               (a.equals("Paper") && b.equals("Rock")) ||
               (a.equals("Scissors") && b.equals("Paper"));
    }
}
