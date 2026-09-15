package instructor.practiceActivities.PA01_Solution;

import java.util.Scanner;

public class PracticeActivity1_Q3 {

    // ========================= SOLUTION =========================
    //
    // (a) PREDICTIONS -- typing SHIP at both prompts.
    //     Almost everyone predicts line 1 as true and line 3 as false, or
    //     predicts both the same. Getting it backwards here is the whole
    //     setup for (c).
    //       line 1: false
    //       line 2: true
    //       line 3: true
    //
    // (b) ACTUAL OUTPUT -- typing SHIP at both prompts:
    //       line 1: false
    //       line 2: true
    //       line 3: true
    //       (d):    true
    //
    // (c) EXPLANATION -- == does not compare characters. It asks whether two
    //     names point at the same object in memory. Line 3 is true only
    //     because both Strings were written directly into the code as
    //     literals, and Java saves memory by pointing both names at one
    //     shared "SHIP". Line 1 is false because Scanner builds a brand new
    //     String object for each thing you type, so the two entries are two
    //     separate objects that happen to hold identical characters.
    //
    //     That is what makes == the wrong tool: it is not wrong in some
    //     predictable direction you could work around, it is unreliable.
    //     The same characters give opposite answers depending on where the
    //     String came from. Anything Java builds while the program runs --
    //     keyboard input, concat, substring, trim -- is a new object.
    //     equals() compares the characters, which is the question you
    //     actually meant to ask.
    //
    // ============================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the disposition code (SHIP/HOLD): ");
        String firstEntry = input.nextLine();

        System.out.print("Enter the same code again to confirm: ");
        String secondEntry = input.nextLine();

        System.out.println(firstEntry == secondEntry);        // line 1 -> false
        System.out.println(firstEntry.equals(secondEntry));   // line 2 -> true (when both entries match)

        String a = "SHIP";
        String b = "SHIP";
        System.out.println(a == b);                           // line 3 -> true

        // (d) equalsIgnoreCase compares the characters the way equals does,
        //     but treats SHIP, ship, and ShIp as the same text. One
        //     statement, no if needed, because the method already hands back
        //     the true/false value we wanted to print.
        System.out.println(firstEntry.equalsIgnoreCase("SHIP"));

        // (e) TWO MORE RUNS
        //
        //     Typing ship at both prompts:
        //       line 1: false     <- still two separate objects
        //       line 2: true      <- same characters, so equals says yes
        //       line 3: true      <- literals, unchanged by anything typed
        //       (d):    true      <- lowercase ship still matches SHIP
        //
        //     Typing ship, then hold:
        //       line 1: false
        //       line 2: false     <- different characters this time
        //       line 3: true
        //       (d):    true      <- (d) only looks at firstEntry, which is
        //                            still ship, so the mismatch does not
        //                            change it
        //
        //     Line 1 is false in every run, including the one where the two
        //     entries matched perfectly. A confirm-your-entry check built on
        //     == would reject every user, every time.

        input.close();
    }
}
