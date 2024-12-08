// Conner Wiley CSCE-145 Section 009 //

import java.util.*; // Imports scanner and any other objects I may need

public class Homework02 {

    public static void main(String[] args) {
        // Declare variables
        Scanner scanner = new Scanner(System.in);
        int loop = 0;
        int story;
        String input = "";
        int numInput;

        System.out.println("Welcome to my Dungeon Crawler Adventure Game!");
        System.out.println("Make decisions carefully as they will affect your fate.");
        System.out.println("Press Enter to begin...");
        scanner.nextLine();

        while (loop == 0) {
            story = 0;  // Start the game at story point 0

            // Main game loop controlled by the story variable
            while (story != -1) {
                switch (story) {
                case 0:
                    System.out.println("You wake up in a dark, cold dungeon with no memory of how you got here.");
                    System.out.println("In front of you, there is a wooden door and a torch burning on the wall.");
                    System.out.println("Do you take the torch before opening the door? Yes or No?");
                    input = scanner.next();

                    // Torch decision branch
                    if (input.equalsIgnoreCase("Yes")) {
                        System.out.println("You grab the torch, providing light for your journey.");
                        story = 1;  // Proceed with the torch
                    } else {
                        System.out.println("You decide not to take the torch. The darkness is overwhelming.");
                        story = 2;  // Proceed without the torch
                    }
                    break;

                case 1:
                    // Player took the torch
                    System.out.println("You open the door and find a long, narrow hallway.");
                    System.out.println("At the end of the hallway, there is a strange puzzle on the floor.");
                    System.out.println("The puzzle asks: 'What is 9 + 10?' Enter your answer:");
                    numInput = scanner.nextInt();

                    if (numInput == 19 && input.equalsIgnoreCase("Yes")) {
                        System.out.println("Correct! The floor opens up, revealing a staircase going down.");
                        story = 3;  // Correct puzzle answer
                    } else if (numInput == 21) {
                        System.out.println("It seems like the right answer... but suddenly, a trap springs!");
                        System.out.println("You fall into a hidden pit.");
                        story = 10;  // Hidden pit ending
                    } else {
                        System.out.println("Incorrect! The floor beneath you collapses, and you fall into a trap.");
                        story = 4;  // Wrong answer, fall into a trap
                    }
                    break;

                case 2:
                    // Player did not take the torch
                    System.out.println("Without light, you step forward carefully. But you quickly lose your footing.");
                    System.out.println("You fall into a deep pit. The adventure ends here.");
                    story = -1;  // Ending 1
                    break;

                case 3:
                    // Correct puzzle answer
                    System.out.println("You descend the staircase and find yourself in a dimly lit room.");
                    System.out.println("In front of you, there are three doors: one red, one blue, and one green.");
                    System.out.println("Which door do you choose? Red, Blue, or Green?");
                    input = scanner.next();

                    // Branch based on the chosen door
                    if (input.equalsIgnoreCase("Red")) {
                        story = 5;  // Red door leads to danger
                    } else if (input.equalsIgnoreCase("Blue")) {
                        story = 6;  // Blue door leads to treasure
                    } else {
                        story = 7;  // Green door leads to mystery
                    }
                    break;

                case 4:
                    // Player fell into a trap
                    System.out.println("You find yourself in a dark pit with no way out.");
                    System.out.println("Do you try to climb out? Yes or No?");
                    input = scanner.next();
                    if (input.equalsIgnoreCase("Yes")) {
                        System.out.println("You attempt to climb, but the walls are too steep. You fall to your death.");
                        story = -1;  // Ending 7
                    } else {
                        System.out.println("You scream for help, but no one answers. This is the end.");
                        story = -1;  // Ending 2
                    }
                    break;

                case 5:
                    // Red door: danger
                    System.out.println("The red door leads you into a room filled with fire!");
                    System.out.println("There is no escape. You perish in the flames.");
                    story = -1;  // Ending 3
                    break;

                case 6:
                    // Blue door: treasure
                    System.out.println("The blue door leads to a treasure room filled with gold and jewels!");
                    System.out.println("Congratulations! You have won the game and found the treasure!");
                    story = -1;  // Ending 4
                    break;

                case 7:
                    // Green door: mystery
                    System.out.println("The green door leads to a mysterious forest, and you wander into the unknown.");
                    System.out.println("As you walk deeper into the forest, you encounter a strange figure offering you two choices.");
                    System.out.println("Do you follow the figure, run away, or refuse to choose? (Follow, Run, or Refuse)");
                    input = scanner.next();

                    if (input.equalsIgnoreCase("Follow")) {
                        story = 8;  // Follow the figure
                    } else if (input.equalsIgnoreCase("Run")) {
                        story = 9;  // Run away from the figure
                    } else {
                        System.out.println("You stand frozen, and the figure traps you in a magical net.");
                        story = 11;  // Net ending
                    }
                    break;

                case 8:
                    // Follow the figure
                    System.out.println("The figure leads you to a hidden sanctuary where you live the rest of your days in peace.");
                    System.out.println("You have found a new home in this strange place. The game ends here.");
                    story = -1;  // Ending 5
                    break;

                case 9:
                    // Run away from the figure
                    System.out.println("You run deeper into the forest, but get lost and cannot find your way out.");
                    System.out.println("Eventually, you succumb to exhaustion. The game ends here.");
                    story = -1;  // Ending 6
                    break;

                case 10:
                    // Hidden pit ending
                    System.out.println("The hidden pit swallows you, and you are lost in the darkness forever. You can't help but feel stupid.");
                    story = -1;  // New Ending 8
                    break;

                case 11:
                    // Magical net trap
                    System.out.println("The magical net tightens, and you are trapped forever in the forest.");
                    story = -1;  // New Ending 9
                    break;
                }
            }

            // Ask if the player wants to play again
            System.out.println("Play again? Yes or No?");
            input = scanner.next();
            if (!input.equalsIgnoreCase("Yes")) {
                loop = 1;  // Exit the outer game loop
            }
        }

        // Close the scanner when the game is over
        scanner.close();
    }
}
