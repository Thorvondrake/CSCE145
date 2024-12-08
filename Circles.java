// Conner Wiley CSCE-145 Section 009 //

import java.util.*; //imports scanner and any other objects I may need
public class Homework04 {

	public static void main(String[] args) {
        // Constant for PI value
        final double PI = 3.14;
        Scanner scanner = new Scanner(System.in);
        double[] circles = null; // Stores the areas of the circles
        boolean running = true; // Controls the program loop

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Enter the number of circles and their radii.");
            System.out.println("2. Sort and display areas (smallest to largest).");
            System.out.println("3. Sort and display areas (largest to smallest).");
            System.out.println("4. Display all unique areas.");
            System.out.println("5. Quit.");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                // Option 1: Enter circle data
            case 1:
                int numCircles;
                // Ensure valid input
                while (true) {
                    System.out.print("Enter the number of circles: ");
                    numCircles = scanner.nextInt();
                    if (numCircles > 0) {
                        break;
                    } else {
                        System.out.println("Invalid number. Please enter a positive integer.");
                    }
                }

                circles = new double[numCircles];

                // Get the radius of each circle
                for (int i = 0; i < numCircles; i++) {
                    System.out.print("Enter the radius of circle " + (i + 1) + ": ");
                    double radius = scanner.nextDouble();
                    circles[i] = PI * radius * radius;
                }
                break;

                // Option 2: Sort and display areas from smallest to largest
                case 2:
                    if (circles == null) {
                        System.out.println("No circles in the collection. Please enter circles first.");
                    } else {
                        // Sort array in ascending order
                        for (int i = 0; i < circles.length - 1; i++) {
                            for (int j = i + 1; j < circles.length; j++) {
                                if (circles[i] > circles[j]) {
                                    double temp = circles[i];
                                    circles[i] = circles[j];
                                    circles[j] = temp;
                                }
                            }
                        }
                        // Display sorted areas
                        System.out.println("Areas from smallest to largest:");
                        for (double area : circles) {
                            System.out.printf("%.2f ", area);
                        }
                        System.out.println();
                    }
                    break;

                // Option 3: Sort and display areas from largest to smallest
                case 3:
                    if (circles == null) {
                        System.out.println("No circles in the collection. Please enter circles first.");
                    } else {
                        // Sort array in descending order
                        for (int i = 0; i < circles.length - 1; i++) {
                            for (int j = i + 1; j < circles.length; j++) {
                                if (circles[i] < circles[j]) {
                                    double temp = circles[i];
                                    circles[i] = circles[j];
                                    circles[j] = temp;
                                }
                            }
                        }
                        // Display sorted areas
                        System.out.println("Areas from largest to smallest:");
                        for (double area : circles) {
                            System.out.printf("%.2f ", area);
                        }
                        System.out.println();
                    }
                    break;

                // Option 4: Display unique circle areas
                case 4:
                    if (circles == null) {
                        System.out.println("No circles in the collection. Please enter circles first.");
                    } else {
                        System.out.println("Unique circle areas:");
                        // Loop through areas to find and display unique ones
                        for (int i = 0; i < circles.length; i++) {
                            boolean foundDuplicate = false;
                            for (int j = 0; j < circles.length; j++) {
                                if (i != j && circles[i] == circles[j]) {
                                    foundDuplicate = true;
                                    break;
                                }
                            }
                            if (!foundDuplicate) {
                                System.out.printf("%.2f ", circles[i]);
                            }
                        }
                        System.out.println();
                    }
                    break;

                // Option 5: Quit the program
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}