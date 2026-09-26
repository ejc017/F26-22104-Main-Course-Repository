package student.assignments.A04;

import java.util.Random;

public class Assignment4_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (d) EIGHT RUNS -- paste the printf line from each of eight runs.
    //       run 1:
    //       run 2:
    //       run 3:
    //       run 4:
    //       run 5:
    //       run 6:
    //       run 7:
    //       run 8:
    //
    //     Across your eight runs, was any one of the five tests noticeably
    //     more or less common than the others, or did they seem about evenly
    //     spread out? Explain what generating an int in a fixed range from 0
    //     to 4 guarantees about the values you can get back.
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Random rand = new Random();

        // TODO (a): Generate testNumber, an int from 0 to 4, inclusive.
        //           Print the raw value before anything else.

        int testNumber = rand.nextInt(5); // generates an integer from 0 through 4
        System.out.println(testNumber); // prints the raw random value

        // TODO (b): Use a switch statement on testNumber to set a String
        //           named testName:
        //             0 -> "Visual Inspection"
        //             1 -> "Weight Check"
        //             2 -> "Dimensional Scan"
        //             3 -> "Hardness Test"
        //             4 -> "Surface Finish Check"
        //           Include a default case that sets testName to
        //           "Unexpected test number".

        String testName; // stores the name of the selected test

        switch (testNumber) { // selects a test based on testNumber
            case 0:
                testName = "Visual Inspection";
                break;
            case 1:
                testName = "Weight Check";
                break;
            case 2:
                testName = "Dimensional Scan";
                break;
            case 3:
                testName = "Hardness Test";
                break;
            case 4:
                testName = "Surface Finish Check";
                break;
            default:
                testName = "Unexpected test number";
        }

        // TODO (c): Report the result with a single printf, in the form:
        //           Test selected: Weight Check

        System.out.printf("Test selected: %s%n", testName); // prints the selected test
    }
}