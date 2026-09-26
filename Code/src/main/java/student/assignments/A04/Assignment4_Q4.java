package student.assignments.A04;

import java.util.Scanner;

public class Assignment4_Q4 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) THE CRASH -- paste the first line of the exception (class name and
    //     message only) and explain what it's telling you went wrong.
    //
    //     java.util.IllegalFormatConversionException: f != java.lang.String
    //
    //     This means printf tried to use the %f format specifier with a
    //     String value. The first format specifier was %.1f, but the first
    //     argument provided was status, which is a String.
    //
    //
    // (c) FIVE RUNS -- record all five runs after fixing part (b), before
    //     touching the second bug.
    //       499:
    //       Furnace at 499.0 degrees F -> Normal
    //
    //       500:
    //       Furnace at 500.0 degrees F -> Elevated - increase monitoring
    //
    //       900:
    //       Furnace at 900.0 degrees F -> Critical - shutdown required
    //
    //       901:
    //       Furnace at 901.0 degrees F -> Critical - shutdown required
    //
    //       1000:
    //       Furnace at 1000.0 degrees F -> Critical - shutdown required
    //
    //     Which one doesn't match the table in the assignment?
    //
    //     900 does not match the table.
    //
    //
    // (d) EXPLANATION AND CORRECTED RUNS -- what was wrong with the original
    //     condition, and why did that specific input expose it? Then record
    //     all five runs again after the fix.
    //
    //     The original condition used temperature < 900, which did not
    //     include exactly 900. The value 900 exposed the problem because
    //     900 should still be included in the Elevated range.
    //
    //       499:
    //       Furnace at 499.0 degrees F -> Normal
    //
    //       500:
    //       Furnace at 500.0 degrees F -> Elevated - increase monitoring
    //
    //       900:
    //       Furnace at 900.0 degrees F -> Elevated - increase monitoring
    //
    //       901:
    //       Furnace at 901.0 degrees F -> Critical - shutdown required
    //
    //       1000:
    //       Furnace at 1000.0 degrees F -> Critical - shutdown required
    //
    //
    // (e) THE SNIPPET -- name both syntax errors (line and what's wrong),
    //     then write the corrected snippet.
    //
    //     Line 139 is missing a semicolon at the end of the Scanner declaration.
    //     Line 146 is missing a closing parenthesis in the else if condition.
    //
    //     Scanner input = new Scanner(System.in);
    //     System.out.print("Enter shift number (1, 2, or 3): ");
    //     int shift = input.nextInt();
    //
    //     String shiftName;
    //     if (shift == 1) {
    //         shiftName = "Day Shift";
    //     } else if (shift == 2) {
    //         shiftName = "Swing Shift";
    //     } else {
    //         shiftName = "Night Shift";
    //     }
    //
    //     System.out.printf("Welcome to %s%n", shiftName);
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the furnace temperature (F): "); // asks for furnace temperature
        double temperature = input.nextDouble(); // stores the entered temperature

        String status; // stores the furnace status
        if (temperature < 500) { // temperatures below 500 are normal
            status = "Normal";
        } else if (temperature <= 900) { // includes 500 through 900
            status = "Elevated - increase monitoring";
        } else {
            status = "Critical - shutdown required";
        }

        // TODO (b): This line throws an exception on every run. printf fills
        //           in its format specifiers with the arguments that follow,
        //           in the same order, and each argument has to be a type
        //           that specifier can format. Fix the ordering/typing
        //           problem without changing what information is printed.
        System.out.printf("Furnace at %.1f degrees F -> %s%n", temperature, status); // prints temperature and status

        input.close();
    }
}