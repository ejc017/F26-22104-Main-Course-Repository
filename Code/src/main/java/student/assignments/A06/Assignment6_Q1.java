package instructor.assignments.A06;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Assignment6_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (f) The file contains a header, 24 hourly rows, a blank line,
    //     and three summary lines.
    //
    //     Running the program again produces the same file because
    //     the Random object uses the same seed, 2210.
    //     Changing the seed would make each run produce a different log.
    //
    //     Swapping the two random draws would change the row for hour 1
    //     because each draw would use a different random value.
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        Random rand = new Random(2210); // Creates repeatable random values

        final int NUM_HOURS = 24;
        final int BASE_UNITS = 90;
        final int UNIT_RANGE = 21;
        final double STOP_CHANCE = 0.15;

        // Creates the output file and writes its header
        PrintWriter writer = new PrintWriter("output/a06_shiftLog.txt");
        writer.printf("%-8s %-8s %-8s%n", "Hour", "Units", "Status");

        int totalUnits = 0; // Tracks all cases filled
        int hoursDown = 0; // Counts hours the line was stopped
        int bestHour = 1; // Stores the most productive hour
        int bestUnits = 0; // Stores the highest hourly output

        // Processes each hour of the shift
        for (int hour = 1; hour <= NUM_HOURS; hour++) {

            int units = BASE_UNITS + rand.nextInt(UNIT_RANGE);
            double stopDraw = rand.nextDouble(); // Checks for a stoppage
            String status; // Stores the line's status

            if (stopDraw < STOP_CHANCE) {
                units = 0;
                status = "DOWN";
                hoursDown++;
            } else {
                status = "RUN";
            }

            // Writes the current hour's results
            writer.printf("%-8d %-8d %-8s%n", hour, units, status);

            totalUnits += units; // Adds this hour's production

            // Updates the best hour only when output is higher
            if (units > bestUnits) {
                bestUnits = units;
                bestHour = hour;
            }
        }

        writer.println(); // Adds a blank line before the summary
        writer.printf("Total units: %d%n", totalUnits);
        writer.printf("Hours down: %d of %d%n", hoursDown, NUM_HOURS);
        writer.printf("Best hour: %d (%d units)%n", bestHour, bestUnits);
        writer.close(); // Saves and closes the file

        // Confirms that the log was written
        System.out.println("Shift log written to output/a06_shiftLog.txt");
    }
}

