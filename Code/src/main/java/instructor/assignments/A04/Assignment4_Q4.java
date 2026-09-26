package instructor.assignments.A04;

import java.util.Scanner;

public class Assignment4_Q4 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) THE CRASH -- paste the first line of the exception (class name and
    //     message only) and explain what it's telling you went wrong.
    //
    //
    // (c) FIVE RUNS -- record all five runs after fixing part (b), before
    //     touching the second bug.
    //       499:
    //       500:
    //       900:
    //       901:
    //       1000:
    //
    //     Which one doesn't match the table in the assignment?
    //
    //
    // (d) EXPLANATION AND CORRECTED RUNS -- what was wrong with the original
    //     condition, and why did that specific input expose it? Then record
    //     all five runs again after the fix.
    //       499:
    //       500:
    //       900:
    //       901:
    //       1000:
    //
    //
    // (e) THE SNIPPET -- name both syntax errors (line and what's wrong),
    //     then write the corrected snippet.
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the furnace temperature (F): ");
        double temperature = input.nextDouble();

        String status;
        if (temperature < 500) {
            status = "Normal";
        } else if (temperature < 900) {
            status = "Elevated - increase monitoring";
        } else {
            status = "Critical - shutdown required";
        }

        // TODO (b): This line throws an exception on every run. printf fills
        //           in its format specifiers with the arguments that follow,
        //           in the same order, and each argument has to be a type
        //           that specifier can format. Fix the ordering/typing
        //           problem without changing what information is printed.
        System.out.printf("Furnace at %.1f degrees F -> %s%n", status, temperature);

        input.close();
    }
}
