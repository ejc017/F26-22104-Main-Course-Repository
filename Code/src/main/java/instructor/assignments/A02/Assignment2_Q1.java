package instructor.assignments.A02;

import java.util.Scanner;

public class Assignment2_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PREDICTION -- fill this in BEFORE you run the program.
    //     What will each of the three prompts do, and what will the three
    //     output lines show?
    //
    //
    //
    // (b) ACTUAL OUTPUT -- run the program, then paste exactly what the
    //     console showed. Leave your prediction in (a) unchanged, even if
    //     it turned out to be wrong.
    //
    //
    //
    // (c) EXPLANATION -- after you fix the program below, explain what the
    //     original code did wrong. Which earlier Scanner call left something
    //     behind, and why did that matter to the nextLine() call?
    //
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the patient's age in years: ");
        int patientAge = input.nextInt();

        System.out.print("Enter the patient's temperature in degrees F: ");
        double temperature = input.nextDouble();

        // TODO (c): Fix the reading of the presenting complaint. The fix goes
        //           somewhere in this area. Write your explanation up in (c).
        System.out.print("Enter the presenting complaint: ");
        String complaint = input.nextLine();

        // TODO (d): Replace the three println statements below with a single
        //           printf statement, in the form given in the assignment.
        System.out.println("Age: " + patientAge);
        System.out.println("Temperature: " + temperature);
        System.out.println("Complaint: " + complaint);

        input.close();
    }
}
