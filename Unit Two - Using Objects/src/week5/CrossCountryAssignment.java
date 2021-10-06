package week5;

import java.util.Scanner;

public class CrossCountryAssignment {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        processRunner(in);
        processRunner(in);
        processRunner(in);
        in.close();
    }

    private static void processRunner(Scanner in) {
        String firstName, lastName;
        String mileOne, mileTwo, finish;
        String splitTwo, splitThree;
        /**
         * Get first & last name of runner Get the mileOne, mileTwo, and finish times
         * for the runner
         */
        System.out.print("Please enter your first name: ");
        firstName = in.nextLine();

        System.out.print("Please enter your last name: ");
        lastName = in.nextLine();

        System.out.print("Please enter your 1 mile time: ");
        mileOne = in.nextLine();

        System.out.print("Please enter your 2 mile time: ");
        mileTwo = in.nextLine();

        System.out.print("Please enter your finishing time: ");
        finish = in.nextLine();

        splitTwo = subtractTimes(mileTwo, mileOne);
        splitThree = subtractTimes(finish, mileTwo);

        // Prints out all of the runner's information
        System.out.println("Runner " + firstName + " " + lastName + "'s times are as follows.");
        System.out.println("First split: " + mileOne);
        System.out.println("Second split: " + splitTwo);
        System.out.println("Third split: " + splitThree);
        System.out.println("Finishing time: " + finish);
        System.out.println("\n--------------------------------------------------------------------------\n ");
    }

    private static String subtractTimes(String endTime, String startTime) {
        double endTimeInSeconds = convertToSeconds(endTime);
        double startTimeInSeconds = convertToSeconds(startTime);

        double diffInSeconds = endTimeInSeconds - startTimeInSeconds;

        return convertToTime(diffInSeconds);
    }

    private static String convertToTime(double diffInSeconds) {
        // Converts from seconds, into the standard format 0:00.000
        int minutes = (int) diffInSeconds / 60; // Getting minutes as an int
        double seconds = diffInSeconds % 60; // Seconds as a double

        if (seconds < 10) { // Checks if the seconds is less than 10
            return minutes + ":" + "0" + String.format("%.3f", seconds); // Adds a zero in front, also formatting for
                                                                         // decimal places
        } else { // If it's bigger than 10
            return minutes + ":" + String.format("%.3f", seconds); // No zero added, just formatting and colon
        }

    }

    private static double convertToSeconds(String endTime) {
        double seconds;
        int seconds1;
        // Checks index of the colon in the time
        if (endTime.indexOf(":") == 1) {
            // Parses the strings excluding the colon, based it's index
            seconds = Double.parseDouble(endTime.substring(2)); // Parses the second(s)
            seconds1 = Integer.parseInt(endTime.substring(0, 1)); // Parses the minute(s)
        } else if (endTime.indexOf(":") == 2) { // If the colon is not at index 1 (which would mean double digit
                                                // minutes)
            seconds = Double.parseDouble(endTime.substring(3));
            seconds1 = Integer.parseInt(endTime.substring(0, 2));
        } else { // If the colon is at index 3, no code for 4 and further
            seconds = Double.parseDouble(endTime.substring(4));
            seconds1 = Integer.parseInt(endTime.substring(0, 3));
        }
        // Returns the combined value of both variables
        return (seconds1 * 60) + seconds;
    }
}
