package instructor.assignments.A07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment7_Q2 {

    // TODO (a): START HERE: PSEUDOCODE FIRST. Do this before any Java.
    //           Create the plain-text file Assignment7_Q2_pseudocode.txt
    //           in student.assignments.A07 (the package you copied, NOT
    //           instructor). Write: INPUT / OUTPUT, a DATA list (arrays
    //           with type, size, index meaning, starting values), then
    //           numbered STEPS in the course keywords (SET, READ, WRITE,
    //           FOR ... END FOR, WHILE ... END WHILE, IF ... THEN ... ELSE IF
    //           ... ELSE ... END IF; the table in the assignment lists
    //           them all). Then trace 4 or 5 readings by hand and record
    //           the result in # lines at the bottom. The assignment text
    //           ("Planning With Pseudocode") has the style guide and the
    //           steps for creating and submitting the file.
    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (f) THE RUN: record the full console output below, then the header
    //     and the first three rows of output/a07_fillHistogram.txt.
    //
    //     Console output:
    //       Readings: 300
    //       Below 490.0: 3
    //       At or above 510.0: 4
    //       [1, 6, 14, 36, 91, 82, 44, 13, 5, 1]
    //       Fullest bin: 498.0-500.0 (91 readings)
    //       Histogram written to output/a07_fillHistogram.txt
    //
    //     Header and first three rows of output/a07_fillHistogram.txt:
    //       Volume (mL)    Count  Percent
    //       490.0-492.0        1     0.33
    //       492.0-494.0        6     2.00  *
    //       494.0-496.0       14     4.67  **
    //
    //     Is the histogram centered on the nominal 500.0 mL? Is it roughly
    //     symmetric? One sentence.
    //
    //     Yes, the tallest bins are 498.0-500.0 and 500.0-502.0, right
    //     around 500.0, and the counts taper off about evenly on both sides.
    //
    //     What does (int) ((489.6 - 490.0) / 2.0) evaluate to? Which bin
    //     would a reading of 489.6 be wrongly counted in if you skipped the
    //     "below LOW" test, and why does a reading of 487.3 behave
    //     differently from it?
    //
    //     It evaluates to 0, because (-0.4) / 2.0 is -0.2 and the (int)
    //     cast truncates toward zero. Without the below-LOW test, 489.6
    //     would be wrongly counted in bin 0 (490.0-492.0). A reading of
    //     487.3 gives (int) (-1.35), which is -1, so counts[-1] would
    //     crash with an ArrayIndexOutOfBoundsException instead of being
    //     silently miscounted.
    //
    //     What happens, and on which kind of reading, if you leave out the
    //     test for readings at or above the top of the last bin?
    //
    //     Any reading of 510.0 or more gives an index of 10 or higher
    //     (510.0 gives exactly 10), which is past the end of counts, so the
    //     program crashes with an ArrayIndexOutOfBoundsException on the
    //     first such reading.
    //
    //     Suppose the plant wanted 40 bins instead of 10. Which lines of
    //     your program would have to change? Why would doing this without
    //     an array be a poor choice?
    //
    //     Only the constants: NUM_BINS becomes 40, and WIDTH becomes 0.5 to
    //     keep the 490-510 range (BAR_SCALE could change so the bars stay
    //     readable). Everything else is driven by those constants. Without
    //     an array I would need 40 separate counter variables and a
    //     40-branch if/else chain, which is long, error-prone, and would
    //     have to be rewritten for any other number of bins.
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        final double LOW = 490.0;       // bottom edge of bin 0 (mL)
        final double WIDTH = 2.0;       // width of every bin (mL)
        final int NUM_BINS = 10;        // bins cover 490.0 up to (not including) 510.0
        final int BAR_SCALE = 5;        // one * in the bar for every 5 readings
        final double HIGH = LOW + NUM_BINS * WIDTH;   // top edge of last bin (510.0)

        // TODO (b): Create two arrays, each with NUM_BINS elements:
        //             int[]    counts   the number of readings in each bin
        //             double[] binLow   the lower edge of each bin
        //           Fill binLow with a for loop: binLow[b] = LOW + b * WIDTH.
        //           Do not fill counts; it starts at 0.
        int[] counts = new int[NUM_BINS];        // all start at 0
        double[] binLow = new double[NUM_BINS];
        for (int b = 0; b < NUM_BINS; b++) {
            binLow[b] = LOW + b * WIDTH;         // lower edge of bin b
        }

        // TODO (c): Create a Scanner on data/a07_fillVolumes.txt (one volume
        //           per line, no count at the top) and read every value
        //           with a while loop driven by hasNextDouble(). For each
        //           reading:
        //             - count it in total
        //             - if it is less than LOW, add one to below
        //             - else if it is HIGH or more (HIGH = LOW + NUM_BINS *
        //               WIDTH, which is 510.0), add one to above
        //             - otherwise it belongs in bin (int) ((v - LOW) / WIDTH);
        //               add one to counts at that index
        //           Declare int total = 0, below = 0, above = 0 before the
        //           loop. Do NOT store the readings, and close the Scanner.
        int total = 0, below = 0, above = 0;
        Scanner in = new Scanner(new FileInputStream("data/a07_fillVolumes.txt"));
        while (in.hasNextDouble()) {
            double v = in.nextDouble();
            total++;                             // every reading counts toward total
            if (v < LOW) {
                below++;                         // under the first bin
            } else if (v >= HIGH) {
                above++;                         // past the last bin
            } else {
                counts[(int) ((v - LOW) / WIDTH)]++;   // bin index from the volume
            }
        }
        in.close();

        // TODO (d): Create a PrintWriter for output/a07_fillHistogram.txt.
        //           Write the header line:
        //             Volume (mL)    Count  Percent
        //           Then one row per bin with the format
        //             "%5.1f-%5.1f %8d %8.2f  %s%n"
        //           giving the bin's low edge, high edge (low + WIDTH),
        //           count, percent of ALL readings, and a bar of "*"
        //           characters: "*".repeat(counts[b] / BAR_SCALE).
        //           The first row of a correct file begins
        //             490.0-492.0        1     0.33
        //           Close the PrintWriter.
        PrintWriter out = new PrintWriter("output/a07_fillHistogram.txt");
        out.println("Volume (mL)    Count  Percent");
        for (int b = 0; b < NUM_BINS; b++) {
            out.printf("%5.1f-%5.1f %8d %8.2f  %s%n",
                    binLow[b], binLow[b] + WIDTH,      // low and high edge
                    counts[b],
                    100.0 * counts[b] / total,         // percent of ALL readings
                    "*".repeat(counts[b] / BAR_SCALE)); // bar of stars
        }
        out.close();

        // TODO (e): Find the fullest bin (largest count; ties go to the
        //           lower bin; start your "best" index at 0 and loop from
        //           b = 1, comparing counts[b] > counts[best]) and print to
        //           the console (edges with %.1f, one decimal):
        //             Readings: 300
        //             Below 490.0: 3
        //             At or above 510.0: 4
        //             [1, 6, 14, 36, 91, 82, 44, 13, 5, 1]      <- Arrays.toString(counts)
        //             Fullest bin: 498.0-500.0 (91 readings)
        //             Histogram written to output/a07_fillHistogram.txt
        //           Use your variables; do not hard-code any of these values.
        int best = 0;
        for (int b = 1; b < NUM_BINS; b++) {
            if (counts[b] > counts[best]) {      // strict > so ties keep the lower bin
                best = b;
            }
        }
        System.out.println("Readings: " + total);
        System.out.printf("Below %.1f: %d%n", LOW, below);
        System.out.printf("At or above %.1f: %d%n", HIGH, above);
        System.out.println(Arrays.toString(counts));
        System.out.printf("Fullest bin: %.1f-%.1f (%d readings)%n",
                binLow[best], binLow[best] + WIDTH, counts[best]);
        System.out.println("Histogram written to output/a07_fillHistogram.txt");

    }
}