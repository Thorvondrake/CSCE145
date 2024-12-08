// Conner Wiley CSCE-145 Section 009 //

import java.util.*; //imports scanner and any other objects I may need
public class Homework03 {

    public static void main(String[] args) {
    	//Declare variables
    	
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean play;

        do {
            int playerScore = 0;
            int computerScore = 0;

            // Best 2 out of 3
            while (playerScore < 2 && computerScore < 2) {
                System.out.println("\nEnter your choice (rock, paper, or scissors): ");
                String input = scanner.nextLine().toLowerCase();
                
                // Generate computer choice
                int computerRandom = random.nextInt(3); // Random number between 0 and 2
                String computer = "";
                switch (computerRandom) {
                    case 0: computer = "rock"; break;
                    case 1: computer = "paper"; break;
                    case 2: computer = "scissors"; break;
                }

                System.out.println("Computer chose: " + computer);

                // Determine round winner
                if (input.equals(computer)) {
                    System.out.println("It's a draw!");
                } else if (input.equals("rock")) {
                    if (computer.equals("scissors")) {
                        System.out.println("Rock beats Scissors! You win this round.");
                        playerScore++;
                    } else {
                        System.out.println("Paper beats Rock! Computer wins this round.");
                        computerScore++;
                    }
                } else if (input.equals("paper")) {
                    if (computer.equals("rock")) {
                        System.out.println("Paper beats Rock! You win this round.");
                        playerScore++;
                    } else {
                        System.out.println("Scissors cuts Paper! Computer wins this round.");
                        computerScore++;
                    }
                } else if (input.equals("scissors")) {
                    if (computer.equals("paper")) {
                        System.out.println("Scissors beats Paper! You win this round.");
                        playerScore++;
                    } else {
                        System.out.println("Rock beats Scissors! Computer wins this round.");
                        computerScore++;
                    }
                } else {
                    System.out.println("Invalid choice! Computer gets the point.");
                    computerScore++;
                }

                System.out.println("Current Score -> You: " + playerScore + " | Computer: " + computerScore);
            }

            // Determine overall winner
            if (playerScore == 2) {
                System.out.println("\nCongratulations! You won the game!");
            } else {
                System.out.println("\nComputer wins the game. Better luck next time!");
            }

            System.out.println("Do you want to play again? (yes/no)");
            play = scanner.nextLine().equalsIgnoreCase("yes");

        } while (play);

        scanner.close();
    }
}
