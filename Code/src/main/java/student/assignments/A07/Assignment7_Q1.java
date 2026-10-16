package instructor.assignments.A07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment7_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (f) THE RUN: record the full console output below, then the header
    //     and the first three rows of output/a07_cycleReport.txt.
    //
    //
    //     Right after you create slowFlag with new int[n], and before any
    //     loop touches it, what does Arrays.toString(slowFlag) show? Which
    //     rule from the T13 Arrays chapter tells you that?
    //
    //
    //     Why can't the deviations be computed in a single pass through the
    //     file, the way a running total can? What does the array let you do?
    //
    //
    //     In the "longer than the one before" loop, what index would
    //     cycle[k - 1] ask for if the loop started at k = 0? What happens
    //     when the program reaches it? What did you start k at instead?
    //
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        final double SLOW_MARGIN = 4.0;     // a cycle is SLOW if it is more than this many seconds above the mean

        // TODO (a): Create a Scanner on data/a07_cycleTimes.txt. The first
        //           value in the file is the number of cycles, n. Read it
        //           with nextInt(), create a double array cycle with exactly
        //           n elements, and fill it from the file with a while loop
        //           driven by hasNextDouble() and a separate index counter
        //           (declare int i = 0 before the loop, store with cycle[i],
        //           and do i++ inside the loop). Close the Scanner. Then
        //           print to the console, with the number of cycles read
        //           taken from your counter i:
        //             Cycles read: 25
        //           followed by the array printed with Arrays.toString.

        Scanner in = new Scanner(new FileInputStream("data/a07_cycleTimes.txt"));
        int n = in.nextInt();                    // first value = number of cycles
        double[] cycle = new double[n];          // array sized to match the file
        int i = 0;                               // separate index counter
        while (in.hasNextDouble()) {
            cycle[i] = in.nextDouble();          // store the next time
            i++;                                 // move to the next slot
        }
        in.close();
        System.out.println("Cycles read: " + i);
        System.out.println(Arrays.toString(cycle));

        // TODO (b): Using a for loop over cycle.length, find the mean cycle
        //           time (store it in a double variable mean; you need it
        //           again in (c)). Print:
        //             Mean cycle time: 43.22 seconds       (2 decimals)

        double sum = 0;
        for (int k = 0; k < cycle.length; k++) {
            sum += cycle[k];                     // running total
        }
        double mean = sum / cycle.length;        // total divided by count
        System.out.printf("Mean cycle time: %.2f seconds%n", mean);

        // TODO (c): Create a double array dev and an int array slowFlag,
        //           each with n elements. Print Arrays.toString(slowFlag)
        //           once, right after you create it, then delete that
        //           line. Never put a 0 into slowFlag; the array already
        //           holds zeros. Then, in a for loop, set
        //             dev[k] = cycle[k] - mean
        //           and, if dev[k] is greater than SLOW_MARGIN, set
        //           slowFlag[k] to 1.

        double[] dev = new double[n];            // deviation from the mean
        int[] slowFlag = new int[n];             // all zeros by default
        // (temporary Arrays.toString(slowFlag) print removed after checking)
        for (int k = 0; k < n; k++) {
            dev[k] = cycle[k] - mean;
            if (dev[k] > SLOW_MARGIN) {
                slowFlag[k] = 1;                 // only set the slow ones
            }
        }

        // TODO (d): Create a PrintWriter for output/a07_cycleReport.txt.
        //           Write the header line:
        //             Cycle  Time (s)  Deviation  Flag
        //           Then one row per cycle using
        //             "%5d %9.1f %10.2f  %s%n"
        //           with the cycle NUMBER (the first cycle is 1), its time,
        //           its deviation, and the flag text: "SLOW" if
        //           slowFlag is 1, otherwise "ok". Close the PrintWriter.

        PrintWriter out = new PrintWriter("output/a07_cycleReport.txt");
        out.println("Cycle  Time (s)  Deviation  Flag");
        for (int k = 0; k < n; k++) {
            String flag = (slowFlag[k] == 1) ? "SLOW" : "ok";
            out.printf("%5d %9.1f %10.2f  %s%n", k + 1, cycle[k], dev[k], flag);  // k + 1 = cycle number
        }
        out.close();

        // TODO (e): Find the slowest cycle (largest deviation; ties go to the
        //           earlier cycle) and the number of slow cycles. Start your
        //           "best" index at 0 and loop from k = 1, comparing
        //           dev[k] > dev[best]. Count the slow cycles over ALL k,
        //           from 0 (the 1s in slowFlag), in a separate loop. Also
        //           count the cycles that took longer than the cycle just
        //           before them: cycle[k] > cycle[k - 1], looping from
        //           k = 1 (cycle 1 has no cycle before it, so it cannot be
        //           counted). Print:
        //             Slow cycles: 4 of 25
        //             Slowest cycle: 14 (51.8 s, 8.58 s above the mean)
        //             Cycles longer than the one before: 13

        int best = 0;                            // index of the largest deviation so far
        for (int k = 1; k < n; k++) {
            if (dev[k] > dev[best]) {            // strictly greater, so ties keep the earlier one
                best = k;
            }
        }

        int slowCount = 0;
        for (int k = 0; k < n; k++) {            // from 0: every cycle can be slow
            if (slowFlag[k] == 1) {
                slowCount++;
            }
        }

        int longer = 0;
        for (int k = 1; k < n; k++) {            // from 1: cycle[k - 1] must exist
            if (cycle[k] > cycle[k - 1]) {
                longer++;
            }
        }

        System.out.println("Slow cycles: " + slowCount + " of " + n);
        System.out.printf("Slowest cycle: %d (%.1f s, %.2f s above the mean)%n",
                best + 1, cycle[best], dev[best]);
        System.out.println("Cycles longer than the one before: " + longer);
    }
}