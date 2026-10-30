package instructor.assignments.A08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment8_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PSEUDOCODE -- create Assignment8_Q3_pseudocode.txt in this
    //     package BEFORE you write any method (see "Planning With
    //     Pseudocode" in the handout). It must plan all five methods:
    //     a DEFINE line for each (name, parameters with plain-word types,
    //     what it gives back), the steps with exact loop bounds, and a
    //     trace of your own small example at the bottom. Work the
    //     headers out from how main calls each method and from the
    //     descriptions at the bottom of this file. This must be your own
    //     work, with no AI of any kind. Nothing to type here.
    //
    // (e) THE RUN: record the full console output below.
    //
    //
    //     WRITTEN ANSWERS
    //
    //     (1) Every window is scored on the same weeks, starting at week
    //         index MAX_WINDOW (6). Try changing the third argument of
    //         meanAbsoluteError in main to  w  so each window is scored from
    //         its own first forecast week. What is window 1's error now?
    //         Why is that comparison not fair? Put the 6 back afterward.
    //
    //
    //     (2) Window 1 is the "naive" forecast: next week equals this
    //         week. Demand here rises about 3 units a week, yet the best
    //         window is not 6. Why does a longer window stop helping?
    //         Why does it not help to use window 1 either?
    //
    //
    //     (3) absoluteValue is private. movingAverageForecast calls
    //         averageOf, and meanAbsoluteError calls absoluteValue. Name
    //         one benefit of building the bigger methods out of small ones.
    //
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        final int MAX_WINDOW = 6;       // windows 1 through 6 are tried

        double[] demand = readData("data/a08_demand.txt");
        System.out.println("Weeks read: " + demand.length);
        System.out.printf("Mean weekly demand: %.1f units%n", averageOf(demand, 0, demand.length));
        System.out.println();

        double[] mae = new double[MAX_WINDOW + 1];      // mae[w] is the error of window w; mae[0] is not used
        int best = 1;
        for (int w = 1; w <= MAX_WINDOW; w++) {
            double[] forecast = movingAverageForecast(demand, w);
            mae[w] = meanAbsoluteError(demand, forecast, MAX_WINDOW);
            System.out.printf("Window %d: MAE %.2f units%n", w, mae[w]);
            if (mae[w] < mae[best]) {
                best = w;
            }
        }
        System.out.println();
        System.out.println("Best window: " + best);

        // TODO (d): Recompute the forecast array for the best window.
        //           Then add ONE element to the END of that forecast array
        //           with Arrays.copyOf (assign the result back): the
        //           forecast for the week after the data ends, which is the
        //           average of the last  best  weeks of demand. Use
        //           averageOf for it. Then print, with printf:
        //             Forecast for week 27: 260.5 units
        //           (the week number is demand.length + 1, not a typed
        //           27), and the last three weeks of actual demand against
        //           their forecasts, one line each:
        //             Week 24: actual 242, forecast 252.8
        //             Week 25: actual 268, forecast 252.0
        //             Week 26: actual 272, forecast 256.3
        //           (actual with %.0f, forecast with %.1f; week = index + 1)

    }

    // TODO (b): Write the five methods from your pseudocode, in any order. Do
    //           not change main above (except at the TODO and for the
    //           experiment in written answer 1). Until the methods exist
    //           main will not compile; that is expected. To test as you go,
    //           first write all five with placeholder bodies (return 0.0 or
    //           return null) so the program compiles, then fill them in one
    //           at a time. The imports you need are already at the top.
    //
    //           readData(fileName): takes a String and returns a double[].
    //           The file begins with the number of weeks, then one demand
    //           number per week. Read them into a double array and return
    //           it. The method opens a file, so its header needs
    //           throws FileNotFoundException, as in Question 1.
    //
    //           averageOf(values, start, end): the average of the elements
    //           from index start up to but NOT including index end.
    //
    //           movingAverageForecast(demand, window): return an array the
    //           same length as demand. Element t, for every t from window
    //           up to the last week, is the average of the window weeks
    //           just BEFORE week t (indexes t - window up to t - 1). The
    //           first window elements have no forecast and stay 0. Use
    //           averageOf.
    //
    //           meanAbsoluteError(demand, forecast, start): the average, over
    //           weeks from index start to the last week, of the absolute
    //           difference between demand and forecast. Use absoluteValue.
    //
    //           absoluteValue(x): takes a double and returns a double: x
    //           without its sign. Make it private. (Do not use Math.abs.)

}
