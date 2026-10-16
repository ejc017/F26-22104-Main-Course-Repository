package instructor.assignments.A07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment7_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (f) THE RUN: record the full console output below, then the
    //     header line and the Total line of output/a07_downtimeReport.txt.
    //
    //
    // (g) WRITTEN ANSWERS
    //
    //     One machine stands out from the others, and one day stands out
    //     from the other days. Which are they? Describe in a sentence or
    //     two what each pattern looks like in the numbers, and suggest one
    //     physical cause for each.
    //
    //
    //     The grid has 8 rows and 10 columns. In the loop that adds up the
    //     columns, suppose you used the wrong bound in each of these ways.
    //     For each one, say whether the program crashes or quietly gives
    //     wrong totals, and why:
    //       (1) the inner loop runs  j < down.length          (8, not 10)
    //       (2) the day-total array is created as  new int[rows]  and the
    //           loops still run to 10 columns
    //
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        // TODO (a): First create a String array named machines using a braces
        //           list with these 8 names, in this order: Lathe 1,
        //           Lathe 2, Mill 1, Mill 2, Drill 1, Drill 2, Press 1,
        //           Press 2 (they match the rows of the file).
        //           Then create a Scanner on data/a07_downtime.txt. The first two
        //           values in the file are the number of rows (machines)
        //           and the number of columns (days). Read them, create an
        //           int[][] named down with that many rows and columns, and
        //           fill it with nested for loops (rows outside, columns
        //           inside) that read one nextInt() per cell. The numbers
        //           in the file are minutes of downtime, one line per
        //           machine. Close the Scanner.

        String[] machines = {"Lathe 1", "Lathe 2", "Mill 1", "Mill 2",
                "Drill 1", "Drill 2", "Press 1", "Press 2"};
        Scanner in = new Scanner(new FileInputStream("data/a07_downtime.txt"));
        int rows = in.nextInt();                 // number of machines
        int cols = in.nextInt();                 // number of days
        int[][] down = new int[rows][cols];
        for (int r = 0; r < rows; r++) {         // rows outside
            for (int c = 0; c < cols; c++) {     // columns inside
                down[r][c] = in.nextInt();       // one value per cell
            }
        }
        in.close();

        // TODO (b): Print to the console, using down.length and Arrays.toString:
        //             Machines: 8, days: 10
        //             Lathe 1 row: [28, 48, 20, 21, 23, 62, 38, 24, 22, 26]
        //             Press 2 row: [36, 37, 27, 30, 36, 57, 25, 28, 34, 2]
        //           The two row lines are the FIRST and the LAST row of the
        //           grid: use machines[...] and down[...] with an index
        //           built from the number of rows, not 0 and 7 typed in
        //           for the last one. (down[0] is itself a 1D array.)

        System.out.println("Machines: " + down.length + ", days: " + down[0].length);
        System.out.println(machines[0] + " row: " + Arrays.toString(down[0]));
        System.out.println(machines[down.length - 1] + " row: "
                + Arrays.toString(down[down.length - 1]));   // last row, no typed-in 7

        // TODO (c): Create int arrays rowTotals (one element per machine)
        //           and colTotals (one element per day). With ONE set of
        //           nested loops, add every cell into its machine's total,
        //           its day's total, and a grand total.

        int[] rowTotals = new int[rows];         // one total per machine
        int[] colTotals = new int[cols];         // one total per day
        int grandTotal = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                rowTotals[r] += down[r][c];      // machine total
                colTotals[c] += down[r][c];      // day total
                grandTotal += down[r][c];        // everything
            }
        }

        // TODO (d): Create a PrintWriter for output/a07_downtimeReport.txt
        //           and write a table:
        //             - header line: "%-8s" for the word Machine, then
        //               "%5s" for D1, D2, ... (build "D" + (j + 1) in a
        //               loop), then "%7s" for Total and a line break
        //             - one line per machine: "%-8s" for its name, "%5d"
        //               for each day, "%7d" for its row total
        //             - a last line: "%-8s" for the word Total, "%5d" for
        //               each column total, "%7d" for the grand total
        //           The first lines of a correct file are
        //             Machine    D1   D2   D3   D4   D5   D6   D7   D8   D9  D10  Total
        //             Lathe 1    28   48   20   21   23   62   38   24   22   26    312
        //           Close the PrintWriter.

        PrintWriter out = new PrintWriter("output/a07_downtimeReport.txt");
        out.printf("%-8s", "Machine");             // header
        for (int c = 0; c < cols; c++) {
            out.printf("%5s", "D" + (c + 1));
        }
        out.printf("%7s%n", "Total");

        for (int r = 0; r < rows; r++) {           // one line per machine
            out.printf("%-8s", machines[r]);
            for (int c = 0; c < cols; c++) {
                out.printf("%5d", down[r][c]);
            }
            out.printf("%7d%n", rowTotals[r]);
        }

        out.printf("%-8s", "Total");                // column totals line
        for (int c = 0; c < cols; c++) {
            out.printf("%5d", colTotals[c]);
        }
        out.printf("%7d%n", grandTotal);
        out.close();

        // TODO (e): Find the worst machine (largest row total) and the worst
        //           day (largest column total); ties go to the earlier
        //           one. Print:
        //             Grand total downtime: 2840 minutes
        //             Worst machine: Press 1 (581 minutes)
        //             Worst day: D6 (567 minutes)

        int worstMachine = 0;                    // index of the largest row total so far
        for (int r = 1; r < rows; r++) {
            if (rowTotals[r] > rowTotals[worstMachine]) {   // strictly greater keeps the earlier tie
                worstMachine = r;
            }
        }
        int worstDay = 0;                        // index of the largest column total so far
        for (int c = 1; c < cols; c++) {
            if (colTotals[c] > colTotals[worstDay]) {
                worstDay = c;
            }
        }

        System.out.println("Grand total downtime: " + grandTotal + " minutes");
        System.out.println("Worst machine: " + machines[worstMachine]
                + " (" + rowTotals[worstMachine] + " minutes)");
        System.out.println("Worst day: D" + (worstDay + 1)
                + " (" + colTotals[worstDay] + " minutes)");
    }
}