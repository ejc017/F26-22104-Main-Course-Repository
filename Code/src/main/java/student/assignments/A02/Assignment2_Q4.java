package instructor.assignments.A02;

import java.util.Scanner;

public class Assignment2_Q4 {

    // (d) BOUNDARY TEST RESULTS -- record the output of each of your eight runs.
    //       score  -1 ->Invalid acuity score
    //       score  39 ->Acuity score 39 maps to Level 4 - Non-Urgent
    //       score  40 ->Acuity score 40 maps to Level 3 - Urgent
    //       score  69 ->Acuity score 69 maps to Level 3 - Urgent
    //       score  70 ->Acuity score 70 maps to Level 2 - Emergent
    //       score  89 ->Acuity score 89 maps to Level 2 - Emergent
    //       score  90 ->Acuity score 90 maps to Level 1 - Immediate
    //       score 101 ->Invalid acuity score

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt for and read an acuity score as a whole number.
        System.out.println("Enter the Activity Score as a whole number:");
        int aScore = input.nextInt();
        // TODO (b): If the score is below 0 or above 100, print
        //           "Invalid acuity score" and do not print a triage level
        //           line at all. Your check must use the || operator.

        if(aScore < 0 || aScore > 100) System.out.println("Invalid acuity score");

        // TODO (c): Otherwise, use if / else if / else to determine the triage
        //           level, then report it with printf in the form given in the
        //           assignment. Write the Level 3 test as an explicit range
        //           using &&.
        else if (aScore >= 0 && aScore <= 39) System.out.printf("Acuity score %d maps to Level 4 - Non-Urgent", aScore);
        else if (aScore >= 40 && aScore <= 69) System.out.printf("Acuity score %d maps to Level 3 - Urgent", aScore);
        else if (aScore >= 70 && aScore <= 89) System.out.printf("Acuity score %d maps to Level 2 - Emergent", aScore);
        else if (aScore >= 90 && aScore <= 100) System.out.printf("Acuity score %d maps to Level 1 - Immediate", aScore);

        input.close();
    }
}
