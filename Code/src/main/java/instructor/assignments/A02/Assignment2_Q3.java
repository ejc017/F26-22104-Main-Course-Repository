package instructor.assignments.A02;

import java.util.Scanner;

public class Assignment2_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PREDICTIONS -- fill these in BEFORE you run the program.
    //     What does each of the three println statements print when the user
    //     types admit, in lower case?
    //       line 1:
    //       line 2:
    //       line 3:
    //
    // (b) ACTUAL OUTPUT -- run the program, type admit, and record the three
    //     lines here. Leave your predictions in (a) unchanged.
    //       line 1:
    //       line 2:
    //       line 3:
    //
    // (c) EXPLANATION -- why did the FIRST line print what it did? What does
    //     == actually compare when both sides are Strings?
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the disposition (admit/discharge): ");
        String disposition = input.nextLine();

        System.out.println(disposition == "admit");
        System.out.println(disposition.equals("admit"));
        System.out.println(disposition.equalsIgnoreCase("ADMIT"));

        // TODO (d): Add one System.out.println(...) statement that prints true
        //           when the user typed EITHER valid disposition -- admit or
        //           discharge -- in any capitalization, with or without stray
        //           spaces around it, and false for anything else. One
        //           statement, no if needed, but you will need ||.

        input.close();
    }
}
