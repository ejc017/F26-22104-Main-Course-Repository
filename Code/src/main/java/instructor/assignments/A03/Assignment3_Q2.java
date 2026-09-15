package instructor.assignments.A03;

import java.util.Random;

public class Assignment3_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) TEN RUNS -- paste the printf line from each of ten runs.
    //       run  1:
    //       run  2:
    //       run  3:
    //       run  4:
    //       run  5:
    //       run  6:
    //       run  7:
    //       run  8:
    //       run  9:
    //       run 10:
    //
    //     Which shipping method showed up most often, and which ones showed
    //     up once or not at all? Explain using the ranges the two values are
    //     drawn from and the cutoffs in your branching. One of the six is far
    //     rarer than the rest because it takes two narrow conditions at once --
    //     name it and say what both conditions are.
    //
    //
    // (e) SEEDED RUNS -- change to new Random(2026) and run twice.
    //       run 1:
    //       run 2:
    //
    //     Only one of the two values settles down. Which one now repeats,
    //     which one still changes, and why did seeding the Random object have
    //     no effect on the other?
    //     (Change it back to new Random() before you submit.)
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Random rand = new Random();

        // TODO (a): Generate the two values, using a different tool for each.
        //           packageWeight -- an int from 1 to 70 inclusive, from
        //             Math.random(), scaled and cast, with no Random object.
        //           distanceMiles -- an int from 10 to 3000 inclusive, from
        //             rand, using min + rand.nextInt(max - min + 1).
        //           Print both before anything else.

        // TODO (b): Use a NESTED if structure to set shippingMethod.
        //             over 50 lb:
        //                 over 500 mi                -> "Freight - LTL"
        //                 otherwise                  -> "Freight - Local Truck"
        //             50 lb or less:
        //                 over 1500 mi:
        //                     5 lb or less           -> "Air - Express"
        //                     otherwise              -> "Air - Standard"
        //                 over 300 mi, up to 1500 mi -> "Ground - Regional"
        //                 otherwise                  -> "Courier - Same Day"
        String shippingMethod = "";

        // TODO (c): Report the result with a single printf, in the form:
        //           A 62 lb package going 1840 miles ships via Freight - LTL

    }
}
