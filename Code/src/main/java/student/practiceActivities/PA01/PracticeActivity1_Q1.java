package instructor.practiceActivities.PA01;

import java.util.Arrays;

public class PracticeActivity1_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PREDICTIONS -- fill these in BEFORE you run the program.
    //     Write exactly what you think each of the six lines will print,
    //     brackets included.
    //       line 1:[Line7]
    //       line 2:[  Line 7  ]
    //       line 3:[line7]
    //       line 4:[Line7]
    //       line 5:[Shift A]
    //       line 6:[Shift A A]
    //
    // (b) ACTUAL OUTPUT -- run the program and record all six lines here.
    //     Leave your predictions in (a) unchanged, even if they were wrong.
    //       line 1:[Line 7]
    //       line 2:[  Line 7  ]
    //       line 3:[line 7]
    //       line 4:[Line 7]
    //       line 5:[Shift]
    //       line 6:[Shift A]
    //
    // (c) EXPLANATION -- the code just above output lines 5 and 6 calls
    //     concat(" A") both times, and yet the two lines print different
    //     things. Explain why in one or two sentences.
    //
    //      The latter concat method reassigns the variable locking the concat
    //      version in place rather than just 'sampling' the method
    //
    //
    // ================================================================

    public static void main(String[] args) {

        String rawEntry = "  Line 7  ";

        System.out.println("[" + rawEntry.trim() + "]");        // line 1
        System.out.println("[" + rawEntry + "]");               // line 2

        String trimmed = rawEntry.trim();
        System.out.println("[" + trimmed.toLowerCase() + "]");  // line 3
        System.out.println("[" + trimmed + "]");                // line 4

        String shift = "Shift";
        shift.concat(" A");
        System.out.println("[" + shift + "]");                  // line 5

        shift = shift.concat(" A");
        System.out.println("[" + shift + "]");                  // line 6

        // TODO (d): Add one println that prints rawEntry with EVERY space
        //           removed, wrapped in square brackets, so it shows as
        //           [Line7]. Do not change the rawEntry declaration above.
        System.out.println(rawEntry.replace(" ", ""));

    }
}
