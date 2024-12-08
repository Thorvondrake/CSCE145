// Conner Wiley CSCE-145 Section 009 //

import java.util.*; //imports scanner and any other objects I may need

public class Homework05 {
    public static class Coffee {
        // Declare variables
        private String name;
        private int caffeineContent;

        public Coffee() {
            this.name = "none";
            this.caffeineContent = 50;
        }

        public Coffee(String name, int caffeineContent) {
            setName(name);
            setCaffeineContent(caffeineContent);
        }

        public String getName() {
            return name;
        }

        public int getCaffeineContent() {
            return caffeineContent;
        }

        public void setName(String name) {
            if (name != null) {
                this.name = name;
            }
        }

        public void setCaffeineContent(int caffeineContent) {
            if (caffeineContent >= 50 && caffeineContent <= 300) {
                this.caffeineContent = caffeineContent;
            }
        }

        // Calculate the risky amount of coffee
        public double riskyAmount() {
            return 180.0 / ((caffeineContent / 100.0) * 6.0);
        }

        // Check if Coffee objects are equal
        public boolean equals(Coffee other) {
            return this.name.equals(other.name) && this.caffeineContent == other.caffeineContent;
        }

        // toString method
        @Override
        public String toString() {
            return "Name: " + name + "\nCaffeine Amount: " + caffeineContent;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runProgram = true;

        System.out.println("Welcome to the Coffee Hour!!!");

        while (runProgram) {
            // Create two Coffee objects
            Coffee coffee1 = createCoffee(scanner, "first");
            Coffee coffee2 = createCoffee(scanner, "second");

            // Output
            System.out.println(coffee1.toString());
            System.out.printf("It would take %.1f cups of %s before it’s dangerous to drink more.%n",
                    coffee1.riskyAmount(), coffee1.getName());

            System.out.println(coffee2.toString());
            System.out.printf("It would take %.1f cups of %s before it’s dangerous to drink more.%n",
                    coffee2.riskyAmount(), coffee2.getName());

            // Check if objects are the same
            System.out.println("Are both coffee’s the same? " + coffee1.equals(coffee2));

            System.out.print("Do you want to create more coffee objects? Enter \"Yes\" or \"No\": ");
            runProgram = scanner.next().equalsIgnoreCase("Yes");
            scanner.nextLine(); 
        }

        scanner.close();
        System.out.println("Thank you for using the Coffee Hour!");
    }

    // Method to create Coffee object
    private static Coffee createCoffee(Scanner scanner, String coffeeNumber) {
        System.out.printf("What’s the name of the %s coffee?%n", coffeeNumber);
        String name = scanner.nextLine();

        int caffeineContent;
        while (true) {
            System.out.printf("What’s the caffeine content of the %s coffee? (50 - 300 mg)%n", coffeeNumber);
            caffeineContent = scanner.nextInt();
            scanner.nextLine(); 
            if (caffeineContent >= 50 && caffeineContent <= 300) {
                break;
            }
            System.out.println("Invalid caffeine content. Please enter a value between 50 and 300.");
        }

        return new Coffee(name, caffeineContent);
    }
}
