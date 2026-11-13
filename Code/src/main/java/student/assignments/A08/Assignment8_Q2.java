
package instructor.assignments.A08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Assignment8_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (c) PREDICTION -- BEFORE you run the three lines in part c, write
    //     what each one prints:
    //
    //       leadTimes == copy: false
    //       Arrays.equals(leadTimes, copy): true
    //       Arrays.equals(leadTimes, sorted): false
    //
    //     Then run them and record any line that differed from your
    //     prediction:
    //
    //     None of the lines differed from my prediction.
    //
    // (g) THE RUN: record the full console output below, then the header
    //     and the first three rows of output/a08_supplierRanking.txt.
    //
    // Suppliers read: 12
    // [14, 7, 21, 10, 7, 28, 14, 5, 18, 10, 35, 12]
    // Original: [14, 7, 21, 10, 7, 28, 14, 5, 18, 10, 35, 12]
    // Sorted:   [5, 7, 7, 10, 10, 12, 14, 14, 18, 21, 28, 35]
    // Median lead time: 13.0 days
    // leadTimes == copy: false
    // Arrays.equals(leadTimes, copy): true
    // Arrays.equals(leadTimes, sorted): false
    // Suppliers now: 13
    // Median lead time: 14.0 days
    // [Acme, Brightway, Cobalt, Delta, Falcon, Granite, Hartwell, Ironside, Juniper, Keystone, Lakeside, Zenith, eastbound]
    // Hand sort matches Arrays.sort: true
    //
    // First lines of a08_supplierRanking.txt:
    //
    // Rank   Supplier      Days
    // 1      Hartwell         5
    // 2      Brightway        7
    // 3      eastbound        7
    //
    //     WRITTEN ANSWERS
    //
    //     (1) In part b you sorted a COPY of leadTimes. What would be lost if
    //         you had sorted leadTimes itself? Be specific about names.
    //
    //         Sorting leadTimes itself would change the original order
    //         of the times without changing names. This would cause
    //         the supplier names and their lead times to no longer match.
    //
    //     (2) Where did the name "eastbound" end up when you sorted the
    //         names in part e, and why? In your final ranking file it is
    //         ranked 3rd, not last. Why does sortTogether put it somewhere
    //         different from Arrays.sort(names)?
    //
    //         eastbound ended up last when sorting the names because
    //         lowercase letters come after uppercase letters in Java's
    //         String sorting order. sortTogether sorts by lead time
    //         instead of name, so eastbound is ranked 3rd with 7 days.
    //
    //     (3) Suppose swapInts had no temporary variable and just said
    //             values[i] = values[j];
    //             values[j] = values[i];
    //         What would the array {6, 1, 4, 9} look like after
    //         swapInts(array, 1, 3)? Trace it line by line.
    //
    //         First, values[1] = values[3] changes the array to
    //         {6, 9, 4, 9}. Then values[3] = values[1] keeps it
    //         {6, 9, 4, 9}. The original value 1 is lost because
    //         there was no temporary variable to save it.
    //
    //     (4) swapInts is a void method that returns nothing, yet the
    //         caller's array ends up changed. In Question 1 an int passed
    //         to a method was NOT changed. What is different about an
    //         array? (Use the T15 primer's wording about what a method
    //         receives when you pass it an array.)
    //
    //         When an array is passed to a method, the method receives
    //         a copy of the reference to the same array. This means
    //         changes to the array elements affect the original array.
    //         An int is passed by value, so changing the parameter
    //         does not change the original variable.
    //
    //     (5) sortTogether takes two arrays but returns nothing. Why could
    //         it not have been written to RETURN the sorted names and the
    //         sorted times? (How many values can one return statement
    //         send back?)
    //
    //         A return statement can only return one value, so it
    //         cannot directly return both arrays separately.
    //         sortTogether is void because it changes both arrays
    //         directly instead of returning them.
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        // TODO (a): Create a Scanner on data/a08_suppliers.txt. The first
        //           value is the number of suppliers, n. Read it, then
        //           create a String array names and an int array leadTimes
        //           with n elements each (parallel arrays: element i of each
        //           describes supplier i). Fill both with a for loop; each
        //           supplier is a name (next()) followed by lead time in
        //           days (nextInt()). Close the Scanner. Print:
        //             Suppliers read: 12
        //             [14, 7, 21, 10, 7, 28, 14, 5, 18, 10, 35, 12]
        //           (the second line is Arrays.toString(leadTimes)).

        Scanner input = new Scanner(new FileInputStream("data/a08_suppliers.txt"));

        int n = input.nextInt();
        String[] names = new String[n];
        int[] leadTimes = new int[n];

        // Read each supplier's name and lead time
        for (int i = 0; i < n; i++) {
            names[i] = input.next();
            leadTimes[i] = input.nextInt();
        }

        input.close();

        System.out.println("Suppliers read: " + n);
        System.out.println(Arrays.toString(leadTimes));

        // TODO (b): Make a COPY of leadTimes named sorted with
        //           Arrays.copyOf (the new array has the SAME length:
        //           Arrays.copyOf(leadTimes, leadTimes.length)), and sort the
        //           copy with Arrays.sort. Print
        //           both arrays with Arrays.toString, then the median lead
        //           time of the sorted copy (write the median method below):
        //             Original: [14, 7, 21, 10, 7, 28, 14, 5, 18, 10, 35, 12]
        //             Sorted:   [5, 7, 7, 10, 10, 12, 14, 14, 18, 21, 28, 35]
        //             Median lead time: 13.0 days

        // Sort a copy so the original order is kept
        int[] sorted = Arrays.copyOf(leadTimes, leadTimes.length);
        Arrays.sort(sorted);

        System.out.println("Original: " + Arrays.toString(leadTimes));
        System.out.println("Sorted:   " + Arrays.toString(sorted));
        System.out.println("Median lead time: " + median(sorted) + " days");

        // TODO (c): FIRST write your predictions in the comment block above.
        //           Then add these lines to main (one declaration, then
        //           three printed comparisons):
        //             int[] copy = Arrays.copyOf(leadTimes, leadTimes.length);
        //             System.out.println("leadTimes == copy: " + (leadTimes == copy));
        //             System.out.println("Arrays.equals(leadTimes, copy): " + Arrays.equals(leadTimes, copy));
        //             System.out.println("Arrays.equals(leadTimes, sorted): " + Arrays.equals(leadTimes, sorted));

        int[] copy = Arrays.copyOf(leadTimes, leadTimes.length);

        System.out.println("leadTimes == copy: " + (leadTimes == copy));
        System.out.println("Arrays.equals(leadTimes, copy): " + Arrays.equals(leadTimes, copy));
        System.out.println("Arrays.equals(leadTimes, sorted): " + Arrays.equals(leadTimes, sorted));

        // TODO (d): A new supplier, Zenith, quotes a lead time of 21 days.
        //           Add it to the END of BOTH arrays: grow each with
        //           Arrays.copyOf (assign the result back) and set the last
        //           element. Then print how many suppliers there are, make
        //           a NEW sorted copy of the grown leadTimes and assign it to
        //           the existing variable sorted (do not declare it a second
        //           time), and print the median again:
        //             Suppliers now: 13
        //             Median lead time: 14.0 days

        // Make room for the new supplier
        names = Arrays.copyOf(names, names.length + 1);
        leadTimes = Arrays.copyOf(leadTimes, leadTimes.length + 1);

        names[names.length - 1] = "Zenith";
        leadTimes[leadTimes.length - 1] = 21;

        System.out.println("Suppliers now: " + names.length);

        sorted = Arrays.copyOf(leadTimes, leadTimes.length);
        Arrays.sort(sorted);

        System.out.println("Median lead time: " + median(sorted) + " days");

        // TODO (e): Make a copy of the grown names array (the one that now
        //           includes Zenith), sort the copy with
        //           Arrays.sort, and print it with Arrays.toString:
        //             [Acme, Brightway, Cobalt, Delta, Falcon, Granite, Hartwell, Ironside, Juniper, Keystone, Lakeside, Zenith, eastbound]

        String[] sortedNames = Arrays.copyOf(names, names.length);
        Arrays.sort(sortedNames);

        System.out.println(Arrays.toString(sortedNames));

        // TODO (f): Do this part LAST: sortTogether rearranges names and
        //           leadTimes in place, so anything that needs the original
        //           order must already be done. Rank the suppliers from
        //           fastest to slowest by calling
        //           sortTogether(names, leadTimes) (write it and the methods it
        //           uses below). Then:
        //             - print  Hand sort matches Arrays.sort: true
        //               using Arrays.equals to compare leadTimes with the
        //               sorted copy from part d
        //             - create a PrintWriter for output/a08_supplierRanking.txt
        //               and write a header with  "%-6s %-12s %5s%n"  for
        //               Rank, Supplier, Days, then one line per supplier with
        //               "%-6d %-12s %5d%n"  (rank 1 is the fastest). Close the
        //               PrintWriter. The first lines of a correct file:
        //                 Rank   Supplier      Days
        //                 1      Hartwell         5
        //                 2      Brightway        7
        //                 3      eastbound        7
        //               (suppliers with the same lead time appear in the order
        //               your sort produces them; with indexOfSmallest using
        //               < this is the order shown)

        // Sort the names and times together
        sortTogether(names, leadTimes);

        System.out.println("Hand sort matches Arrays.sort: " + Arrays.equals(leadTimes, sorted));

        PrintWriter output = new PrintWriter("output/a08_supplierRanking.txt");

        output.printf("%-6s %-12s %5s%n", "Rank", "Supplier", "Days");

        // Write the ranked suppliers to the file
        for (int i = 0; i < names.length; i++) {
            output.printf("%-6d %-12s %5d%n", i + 1, names[i], leadTimes[i]);
        }

        output.close();

    }

    // TODO (b): Return the median of an array that is ALREADY SORTED in
    //           ascending order. With an odd number of values it is the middle one. With
    //           an even number it is the mean of the two middle ones. Use
    //           length % 2 to tell odd from even, and divide by 2.0 (not 2)
    //           when you average two ints, so the result keeps its decimal part.
    //           parameters: int[]     returns: double
    public static double median(int[] sortedValues) {
        int middle = sortedValues.length / 2;

        if (sortedValues.length % 2 == 1) {
            return sortedValues[middle];
        } else {
            return (sortedValues[middle - 1] + sortedValues[middle]) / 2.0;
        }
    }

    // TODO (f): Return the INDEX of the smallest value in values, looking
    //           only at positions from  from  to the end of the array. If
    //           two values tie for smallest, return the earlier index
    //           (use <, not <=).
    //           parameters: int[], int     returns: int
    public static int indexOfSmallest(int[] values, int from) {
        int smallest = from;

        for (int i = from + 1; i < values.length; i++) {
            if (values[i] < values[smallest]) {
                smallest = i;
            }
        }

        return smallest;
    }

    // TODO (f): Swap the values at positions i and j of the array, using a
    //           temporary variable.
    //           parameters: int[], int, int     returns: nothing (void)
    public static void swapInts(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    // TODO (f): The same swap for a String array.
    //           parameters: String[], int, int     returns: nothing (void)
    public static void swapStrings(String[] values, int i, int j) {
        String temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    // TODO (f): Sort the two parallel arrays together so leadTimes ends up
    //           ascending and every name stays with its own lead time. This
    //           is a selection sort:
    //             for each position p from 0 to the second-to-last
    //             (p stops at length - 2)
    //               s = the index of the smallest lead time from p onward
    //               swap positions p and s in BOTH arrays
    //           Use indexOfSmallest, swapInts, and swapStrings. The method
    //           returns nothing: it changes the arrays it is given.
    //           parameters: String[], int[]     returns: nothing (void)
    public static void sortTogether(String[] names, int[] leadTimes) {

        // Move the smallest remaining time into each position
        for (int p = 0; p < leadTimes.length - 1; p++) {
            int s = indexOfSmallest(leadTimes, p);

            swapInts(leadTimes, p, s);
            swapStrings(names, p, s);
        }
    }
}
