package instructor.practiceActivities.PA01;

import java.util.Locale;
import java.util.Scanner;

public class PracticeActivity1_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PREDICTIONS -- fill these in BEFORE you run the program, assuming
    //     you type SHIP in capital letters at BOTH prompts.
    //       line 1: false
    //       line 2: true
    //       line 3: false
    //
    // (b) ACTUAL OUTPUT -- run the program, typing SHIP at both prompts, and
    //     record the three lines here. Leave your predictions in (a) unchanged.
    //       line 1: false
    //       line 2: true
    //       line 3: true
    //
    // (c) EXPLANATION -- line 1 compares two entries you typed identically.
    //     Line 3 compares two Strings written into the code, also identical.
    //     They report opposite answers. Explain what == is actually comparing,
    //     and why that makes it the wrong tool for comparing text.
    //
    //     == is comparing the memory location of the variables rather than the actual characters in the string
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the disposition code (SHIP/HOLD): ");
        String firstEntry = input.nextLine();

        System.out.print("Enter the same code again to confirm: ");
        String secondEntry = input.nextLine();

        System.out.println(firstEntry == secondEntry);        // line 1
        System.out.println(firstEntry.equals(secondEntry));   // line 2

        String a = "SHIP";
        String b = "SHIP";
        System.out.println(a == b);                           // line 3

        // TODO (d): Add one println that prints true when firstEntry is the
        //           code SHIP in ANY capitalization -- SHIP, ship, ShIp --
        //           and false otherwise. No if statement is needed.
        System.out.println("Same input is " + firstEntry.toLowerCase().equals(secondEntry.toLowerCase()));

        // TODO (e): Run the program twice more: once typing ship at both
        //           prompts, and once typing ship and then hold. Record both
        //           sets of output in a comment down here.

        /*
        false
        false
        true
        Same input is true

        false
        false
        true
        Same input is false






         */

        input.close();
    }
}
