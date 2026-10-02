package instructor.assignments.A05;

import java.util.Scanner;

public class Assignment5_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (e) ONE RUN -- record the full run below, entering these five weights
    //     in order: 18.5, 42.0, 12.25, 51.2, 30.0
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int NUM_PACKAGES = 5;
        final double WEIGHT_LIMIT = 40.0;

        // TODO (a): Using a for loop that runs exactly NUM_PACKAGES times,
        //           prompt for and read each package's weight as a double,
        //           in the form:
        //           Enter weight for package 1 (lbs): 18.5

        double totalWeight = 0.0; // stores total weight
        int overweightCount = 0; // counts overweight packages

        for (int i = 1; i <= NUM_PACKAGES; i++) {

            System.out.print("Enter weight for package " + i + " (lbs): ");
            double weight = input.nextDouble(); // reads package weight

            // TODO (b): Inside the same loop, use an if/else to classify each
            //           package against WEIGHT_LIMIT and print one line per
            //           package:
            //             - if the weight is over the limit:
            //               Package 1: OVERWEIGHT (18.5 lbs)
            //             - otherwise:
            //               Package 1: OK (18.5 lbs)

            if (weight > WEIGHT_LIMIT) {
                System.out.printf("Package %d: OVERWEIGHT (%.1f lbs)%n", i, weight);
                overweightCount++; // adds to overweight count
            } else {
                System.out.printf("Package %d: OK (%.1f lbs)%n", i, weight);
            }

            // TODO (c): In the same loop, accumulate two running totals: the sum
            //           of every package's weight (a double), and a count of how
            //           many packages were overweight (an int).

            totalWeight += weight; // adds weight to total
        }

        // TODO (d): After the loop ends, report both totals with a single
        //           printf in the form:
        //           Total weight: 154.0 lbs (2 overweight)

        System.out.printf("Total weight: %.1f lbs (%d overweight)%n",
                totalWeight, overweightCount);

        input.close();
    }
}