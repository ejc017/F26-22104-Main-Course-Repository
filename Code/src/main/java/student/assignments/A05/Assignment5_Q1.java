package instructor.assignments.A05;

import java.util.Scanner;

public class Assignment5_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) TWO RUNS -- record both full runs (every line printed, plus the
    //     final total) below.
    //       Run 1, rows = 4:
    //
    //       Run 2, rows = 6:
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt with "Enter the number of rows for the display: "
        //           and read a positive whole number named rows. Assume the
        //           value typed is valid.

        System.out.print("Enter the number of rows for the display: ");
        int rows = input.nextInt(); // stores number of rows

        // TODO (b): Using a for loop nested inside another for loop, print
        //           the display -- row 1 prints one "* " pallet, row 2
        //           prints two, and so on up through rows. In the same
        //           nested loop, accumulate a running total of how many
        //           pallets were printed across every row.

        int total = 0; // keeps track of total pallets

        for (int i = 1; i <= rows; i++) { // controls each row

            for (int j = 1; j <= i; j++) { // prints pallets in each row
                System.out.print("* ");
                total++; // adds one pallet to the total
            }

            System.out.println(); // moves to the next row
        }

        // TODO (c): Report the total with a single printf in the form:
        //           Total pallets: 10

        System.out.printf("Total pallets: %d%n", total);

        input.close();
    }
}