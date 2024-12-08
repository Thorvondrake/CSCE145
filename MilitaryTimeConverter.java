// Conner Wiley CSCE-145 Section 009 //
import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String repeat;

        do {
            try {
                // First scenario: Input hours, minutes, seconds
                System.out.println("Convert military time into 12-hour clock time!!!");
                System.out.print("Enter the hours on the military clock: ");
                int hours = scanner.nextInt();
                System.out.print("Enter the minutes on the military clock: ");
                int minutes = scanner.nextInt();
                System.out.print("Enter the seconds on the military clock: ");
                int seconds = scanner.nextInt();
                TimeConverter time1 = new TimeConverter(hours, minutes, seconds);
                System.out.print("12-hour clock time → ");
                time1.displayTime();

                // Second scenario: Input time in "hours:minutes:seconds" format
                System.out.print("Enter 24-hour clock time in the format “hours:minutes:seconds”: ");
                scanner.nextLine(); // Consume newline left-over
                String timeString = scanner.nextLine();
                TimeConverter time2 = new TimeConverter();
                time2.updateTime(timeString);
                System.out.print("12-hour clock time → ");
                time2.displayTime();

            } catch (TimeException e) {
                System.out.println(e.getMessage());
            }

            // Ask to repeat
            System.out.print("Would you like to do this again? Enter 'Yes' or 'No': ");
            repeat = scanner.nextLine();
        } while (repeat.equalsIgnoreCase("Yes"));

        System.out.println("Exiting the program!");
        scanner.close();
    }
}


class TimeException extends Exception {
 public TimeException() {
     super("EXCEPTION: Invalid time entered");
 }

 public TimeException(String message) {
     super(message);
 }
}

//Class for Time Conversion Logic
class TimeConverter {
 private int hours;
 private int minutes;
 private int seconds;
 private boolean notPM; // true if AM, false if PM

 // Default constructor
 public TimeConverter() {
     this.hours = 0;
     this.minutes = 0;
     this.seconds = 0;
     this.notPM = true;
 }

 // Parameterized constructor
 public TimeConverter(int hours, int minutes, int seconds) throws TimeException {
     updateTime(hours, minutes, seconds);
 }

 // Accessors
 public int getHours() {
     return hours;
 }

 public int getMinutes() {
     return minutes;
 }

 public int getSeconds() {
     return seconds;
 }

 public boolean isNotPM() {
     return notPM;
 }

 // Mutators
 public void setHours(int hours) throws TimeException {
     if (hours < 0 || hours > 23) throw new TimeException("Invalid hour value");
     this.hours = hours;
 }

 public void setMinutes(int minutes) throws TimeException {
     if (minutes < 0 || minutes > 59) throw new TimeException("Invalid minute value");
     this.minutes = minutes;
 }

 public void setSeconds(int seconds) throws TimeException {
     if (seconds < 0 || seconds > 59) throw new TimeException("Invalid second value");
     this.seconds = seconds;
 }

 public void setNotPM(boolean notPM) {
     this.notPM = notPM;
 }

 // Update time with individual values
 public void updateTime(int hours, int minutes, int seconds) throws TimeException {
     if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
         throw new TimeException();
     }

     this.hours = (hours == 0 || hours == 12) ? 12 : hours % 12;
     this.minutes = minutes;
     this.seconds = seconds;
     this.notPM = hours < 12;
 }

 // Overloaded updateTime method with String input
 public void updateTime(String time) throws TimeException {
     try {
         String[] parts = time.split(":");
         int hours = Integer.parseInt(parts[0]);
         int minutes = Integer.parseInt(parts[1]);
         int seconds = Integer.parseInt(parts[2]);
         updateTime(hours, minutes, seconds);
     } catch (Exception e) {
         throw new TimeException("Invalid time format: " + time);
     }
 }

 // Display time in 12-hour format
 public void displayTime() {
     String period = notPM ? "AM" : "PM";
     System.out.printf("%d:%02d:%02d %s%n", hours, minutes, seconds, period);
 }
}
