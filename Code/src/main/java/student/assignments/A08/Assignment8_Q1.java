package instructor.assignments.A08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment8_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (f) THE RUN: record the full console output of the finished
    //     program below, including the lines printed for part g.
    //
    //
    // (g) WRITTEN ANSWERS
    //
    //     (1) BEFORE running: the call overtimePay(46.0, LIMIT, BASE_RATE)
    //         is correct. Predict what the "Swapped order" line from TODO
    //         (g1) in main prints, where overtimePay(46.0, BASE_RATE, LIMIT)
    //         has the last two arguments swapped. Then run both and record
    //         what happened. Did the compiler complain? Why or why not?
    //
    //           predicted:
    //           actual:
    //           why:
    //
    //     (2) BEFORE running: predict the two lines printed by the
    //         resetHours / resetFirst test in main. Then run it and record
    //         the output. Explain in a sentence or two why the double is
    //         unchanged but the array's first element changed. (See the
    //         T15 primer, section "Arrays and Methods", for what a method
    //         receives when it is passed an array.)
    //
    //           predicted:
    //           actual:
    //           why:
    //
    //     (3) premiumRate is private; the other methods are public. Why is
    //         private a reasonable choice for premiumRate?
    //
    //
    //     (4) Suppose the company changes overtime from time-and-a-half to
    //         double time. Which method would you change, and which would
    //         you leave alone? Why does that work?
    //
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        final double LIMIT = 40.0;          // hours worked in a week before overtime starts
        final double BASE_RATE = 20.00;     // regular pay in dollars per hour

        double[] crewA = readHours("data/a08_crewA.txt");
        double[] crewB = readHours("data/a08_crewB.txt");

        printReport("Crew A", crewA, LIMIT, BASE_RATE);
        printReport("Crew B", crewB, LIMIT, BASE_RATE);

        // TODO (e): Use totalOvertimePay to get the overtime pay for each
        //           crew (store them in double variables), then print which
        //           crew costs more, using printf:
        //             Higher overtime pay: Crew B ($750.00 vs $630.00)
        //           Put the crew with more first, and the larger amount
        //           first, e.g. if Crew A were higher:
        //             Higher overtime pay: Crew A ($900.00 vs $300.00)
        //           (two branches that each print their own crew name are
        //           fine). If the amounts are equal, print
        //             Both crews have overtime pay of $510.00
        //           (with the shared amount; comparing the two amounts with
        //           == is fine here). Use an if / else if / else.

        // TODO (g1): Write these two lines in main, after you have written
        //            your prediction for written answer (1):
        //              System.out.println("Correct order: " + overtimePay(46.0, LIMIT, BASE_RATE));
        //              System.out.println("Swapped order: " + overtimePay(46.0, BASE_RATE, LIMIT));

        // TODO (g2): Predict the two lines below first (written answer 2).
        //            Then call resetHours(testHours) and print
        //              testHours after resetHours: ...
        //            and call resetFirst(testCrew) and print
        //              testCrew[0] after resetFirst: ...
        //            (use println with + to join the label and the value).
        double testHours = 46.0;
        double[] testCrew = {46.0, 38.0};

    }

    // TODO (a): Create a Scanner on the file whose name is passed in. The
    //           first value in the file is the number of workers, n. Read it
    //           with nextInt(), create a double array with n elements, and fill
    //           it with a for loop that reads one nextDouble() per element
    //           (the hours worked that week). Close the Scanner and return
    //           the array. (Notice the throws clause: the method that creates
    //           the FileInputStream has to declare it, and so does every
    //           method that calls it, here main.)
    //           parameters: String     returns: double[]
    public static double[] readHours(String fileName) throws FileNotFoundException {
        return null;
    }

    // TODO (b): Return true if the hours worked are MORE than the limit,
    //           otherwise false. Exactly the limit is not overtime. (A
    //           comparison such as  x > y  is itself a boolean value, so it
    //           can be returned directly, or you can use an if.)
    //           parameters: double, double     returns: boolean
    public static boolean isOvertime(double hours, double limit) {
        return false;
    }

    // TODO (b): Return how many overtime hours were worked: the hours above
    //           the limit, or 0.0 if there are none. Call isOvertime to
    //           decide; do not repeat its comparison here.
    //           parameters: double, double     returns: double
    public static double overtimeHours(double hours, double limit) {
        return 0.0;
    }

    // TODO (c): Return the pay rate for overtime hours, which is time and a
    //           half: the base rate times 1.5.
    //           parameters: double     returns: double
    private static double premiumRate(double baseRate) {
        return 0.0;
    }

    // TODO (c): Return the overtime pay for one worker: the overtime hours
    //           times the overtime pay rate. Call overtimeHours and
    //           premiumRate; do not repeat their work here.
    //           parameters: double, double, double     returns: double
    public static double overtimePay(double hours, double limit, double baseRate) {
        return 0.0;
    }

    // TODO (c): Return the total overtime pay for a whole crew: the sum of
    //           the overtime pay of every worker in the array. Call
    //           overtimePay for each worker.
    //           parameters: double[], double, double     returns: double
    public static double totalOvertimePay(double[] hours, double limit, double baseRate) {
        return 0.0;
    }

    // TODO (d): Return the INDEX of the worker with the most hours (the
    //           first one, if two tie).
    //           parameters: double[]     returns: int
    public static int indexOfMost(double[] hours) {
        return 0;
    }

    // TODO (d): Print one line for the label and array passed in, using
    //           printf. Call totalOvertimePay and indexOfMost to get the
    //           numbers:
    //             Crew A: 8 workers, overtime pay $630.00, most hours: worker 6 (47.5 h)
    //           The number of workers comes from the array, not a typed 8.
    //           Worker numbers start at 1 (the first worker is worker 1),
    //           the pay has 2 decimal places, and the hours have 1.
    //           parameters: String, double[], double, double     returns: nothing (void)
    public static void printReport(String label, double[] hours, double limit, double baseRate) {
    }

    // ---- Provided for written answer (g2). Do not change these two methods. ----

    public static void resetHours(double h) {
        h = 0.0;
    }

    public static void resetFirst(double[] hours) {
        hours[0] = 0.0;
    }
}
