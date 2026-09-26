package student.assignments.A04;

import java.util.Scanner;

public class Assignment4_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) TWO RUNS -- record both full runs (every line printed, plus the
    //     final totals) below.
    //       Run 1, unitsProduced = 5:
    //
    //       Run 2, unitsProduced = 12:
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt for and read a positive whole number named
        //           unitsProduced (assume the value typed is valid).

        System.out.print("Enter the number of units produced: "); // asks how many units were made
        int unitsProduced = input.nextInt(); // stores the number of units

        // TODO (b): Using a while loop, process every whole number from 1 to
        //           unitsProduced. For each one:
        //             - if it's a multiple of 4, print "Unit N pulled for recheck"
        //             - otherwise, print "Unit N complete"
        //           In the same loop, accumulate two running totals: the sum
        //           of every unit number, and a count of how many were
        //           pulled for recheck.

        int unit = 1; // starts with unit 1
        int sum = 0; // keeps the running total of unit numbers
        int recheckCount = 0; // counts units pulled for recheck

        while (unit <= unitsProduced) { // processes each unit

            sum += unit; // adds current unit number to the total

            if (unit % 4 == 0) { // checks if the unit is a multiple of 4
                System.out.printf("Unit %d pulled for recheck%n", unit);
                recheckCount++; // adds one to the recheck count
            } else {
                System.out.printf("Unit %d complete%n", unit);
            }

            unit++; // moves to the next unit
        }

        // TODO (c): After the loop ends, report both totals with a single
        //           printf in the form:
        //           Sum of units 1 through 8: 36 (2 pulled for recheck)

        System.out.printf("Sum of units 1 through %d: %d (%d pulled for recheck)%n",
                unitsProduced, sum, recheckCount); // prints the final totals

        input.close();
    }
}