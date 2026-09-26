package student.assignments.A04;

import java.util.Scanner;

public class Assignment4_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (e) TWO RUNS -- record both runs below.
    //       Run 1, entered 4.75:
    //
    //       Run 2, entered abc:
    //
    //     What specifically does the method you used in part (b) check
    //     before your program ever tries to read anything, and why does
    //     checking first avoid the crash that reading "abc" directly as a
    //     double would cause?
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt with "Enter the sensor voltage reading: ".

        System.out.print("Enter the sensor voltage reading: "); // asks user for voltage

        // TODO (b): Before reading anything else, call the appropriate
        //           hasNextXXX method -- where XXX names the data type
        //           you're checking for -- and use its result as the
        //           condition of an if/else.

        if (input.hasNextDouble()) { // checks if the next input can be read as a double

            // TODO (c): In the if branch, read the value into a double named
            //           voltage, then report it with a printf in the form:
            //           Voltage reading accepted: 4.75 V

            double voltage = input.nextDouble(); // reads the valid voltage
            System.out.printf("Voltage reading accepted: %.2f V%n", voltage); // prints accepted voltage

        } else {

            // TODO (d): In the else branch, print
            //           "Error: voltage reading must be numeric". Do not attempt
            //           to read the value as a double in this branch. Make sure
            //           you still consume whatever token was actually typed, so
            //           it doesn't sit unread in the Scanner's buffer.

            System.out.println("Error: voltage reading must be numeric"); // displays error message
            input.next(); // removes the invalid token from the Scanner
        }

        input.close();
    }
}