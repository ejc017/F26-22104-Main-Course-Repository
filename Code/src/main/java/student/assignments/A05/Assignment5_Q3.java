package instructor.assignments.A05;

import java.util.Scanner;

public class Assignment5_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) TWO RUNS -- record both full runs below.
    //       Run 1, entering 10, then 25, then 12, then -1:
    //
    //       Run 2, entering -1 immediately:
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt with
        //           "Enter downtime duration in minutes (-1 to end shift): "
        //           and read the first value, into an int, before the loop
        //           starts. Assume every value typed is a valid whole
        //           number -- the only special value is -1.

        System.out.print("Enter downtime duration in minutes (-1 to end shift): ");
        int duration = input.nextInt(); // reads first downtime value

        int totalDowntime = 0; // total downtime minutes
        int eventCount = 0; // number of downtime events
        int longestDuration = 0; // longest event seen

        // TODO (b): Keep reading additional durations until -1 is entered.
        //           -1 itself is a signal to stop, not a downtime event, and
        //           should not be counted or added to any total. You will
        //           need to prompt and read again at the bottom of the loop
        //           body so the next value is ready for the condition to
        //           check.
        //
        //           For every duration that is NOT the stop value, accumulate:
        //             - a running total of downtime minutes (an int)
        //             - a count of how many events were entered (an int)
        //             - the single longest duration seen so far, a running
        //               maximum (an int)

        while (duration != -1) {

            totalDowntime += duration; // adds to total
            eventCount++; // counts the event

            if (duration > longestDuration) {
                longestDuration = duration; // updates longest event
            }

            System.out.print("Enter downtime duration in minutes (-1 to end shift): ");
            duration = input.nextInt(); // reads next value
        }

        // TODO (c): After the stop value is entered, report all three values
        //           with a single printf in the form:
        //           Shift downtime: 47 minutes across 3 events (longest single event: 25 minutes)
        //
        //           This has to work correctly even if -1 is entered
        //           immediately (zero events) -- decide what the running
        //           maximum should start out as so that case doesn't require
        //           special-casing in your printf.

        System.out.printf(
                "Shift downtime: %d minutes across %d events (longest single event: %d minutes)%n",
                totalDowntime, eventCount, longestDuration);

        input.close();
    }
}