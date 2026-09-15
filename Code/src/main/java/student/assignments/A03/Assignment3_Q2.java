package instructor.assignments.A03;

import java.util.ArrayList;
import java.util.Random;

public class Assignment3_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) TEN RUNS -- paste the printf line from each of ten runs.
    //       run  1: A 2 lb package going 57 miles ships via Courier - Same Day
    //       run  2: A 6 lb package going 716 miles ships via Courier - Same Day
    //       run  3: A 65 lb package going 2258 miles ships via Freight - LTL
    //       run  4: A 12 lb package going 1271 miles ships via Courier - Same Day
    //       run  5: A 31 lb package going 1223 miles ships via Courier - Same Day
    //       run  6: A 12 lb package going 57 miles ships via Courier - Same Day
    //       run  7: A 37 lb package going 2968 miles ships via Air - Standard
    //       run  8: A 42 lb package going 1409 miles ships via Courier - Same Day
    //       run  9: A 11 lb package going 1753 miles ships via Air - Standard
    //       run 10: A 55 lb package going 69 miles ships via Freight - Local Truck
    //
    //     Which shipping method showed up most often, and which ones showed
    //     up once or not at all? Explain using the ranges the two values are
    //     drawn from and the cutoffs in your branching. One of the six is far
    //     rarer than the rest because it takes two narrow conditions at once --
    //     name it and say what both conditions are.
    //           Courier showed up the most, ground did not show up, it had a
    //           range of 1199 possible values out of 3000 possible so it shows
    //           up very little, ground is very rare it is between 300 < x < 1500
    //
    //
    // (e) SEEDED RUNS -- change to new Random(2026) and run twice.
    //       run 1: A 28 lb package going 302 miles ships via Courier - Same Day
    //       run 2: A 52 lb package going 302 miles ships via Freight - Local Truck
    //
    //     Only one of the two values settles down. Which one now repeats,
    //     which one still changes, and why did seeding the Random object have
    //     no effect on the other?
    //
    //     The seed 2026 chooses an indivdual value from random that is the same
    //     every time making distanceTraveled never changes
    //     (Change it back to new Random() before you submit.)
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<Integer> test = new ArrayList<>();

        // TODO (a): Generate the two values, using a different tool for each.
        //           packageWeight -- an int from 1 to 70 inclusive, from
        //             Math.random(), scaled and cast, with no Random object.
        //           distanceMiles -- an int from 10 to 3000 inclusive, from
        //             rand, using min + rand.nextInt(max - min + 1).
        //           Print both before anything else.

        int packageWeight = (int) (Math.random() * 70) + 1;

        int distanceMiles = 10 + rand.nextInt(3000 - 10 + 1);

        System.out.println("packageWeight = " + packageWeight);
        System.out.println("distanceMiles = " + distanceMiles);

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

        if (packageWeight > 50) {

            if (distanceMiles > 500) {
                shippingMethod = "Freight - LTL";
            } else {
                shippingMethod = "Freight - Local Truck";
            }

        } else {

            if (distanceMiles > 1500) {

                if (packageWeight <= 5) {
                    shippingMethod = "Air - Express";
                } else {
                    shippingMethod = "Air - Standard";
                }

            } else if (distanceMiles > 300) {

                shippingMethod = "Ground - Regional";

            } else {

                shippingMethod = "Courier - Same Day";
            }
        }

        // TODO (c): Report the result with a single printf, in the form:
        //           A 62 lb package going 1840 miles ships via Freight - LTL

        System.out.printf(
                "A %d lb package going %d miles ships via %s%n",
                packageWeight,
                distanceMiles,
                shippingMethod
        );
    }
}