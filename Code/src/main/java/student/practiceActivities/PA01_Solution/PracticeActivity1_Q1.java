package instructor.practiceActivities.PA01_Solution;

public class PracticeActivity1_Q1 {

    // ========================= SOLUTION =========================
    //
    // (a) PREDICTIONS -- what a correct prediction looks like.
    //     Lines 2 and 5 are the two that catch people. A student who
    //     predicted those wrong and then understood why has done the
    //     exercise exactly right; the wrong prediction is the point.
    //       line 1: [Line 7]
    //       line 2: [  Line 7  ]
    //       line 3: [line 7]
    //       line 4: [Line 7]
    //       line 5: [Shift]
    //       line 6: [Shift A]
    //
    // (b) ACTUAL OUTPUT -- the program prints exactly the six lines above,
    //     plus the new line 7 added in part (d):
    //       line 1: [Line 7]
    //       line 2: [  Line 7  ]
    //       line 3: [line 7]
    //       line 4: [Line 7]
    //       line 5: [Shift]
    //       line 6: [Shift A]
    //       (d):    [Line7]
    //
    // (c) EXPLANATION -- a String method never changes the String it was
    //     called on. Strings are immutable, so concat builds and returns a
    //     NEW String and leaves the original alone. The first call throws
    //     that new String away, because nothing catches what it returns, so
    //     shift still holds "Shift" on line 5. The second call assigns the
    //     returned String back into shift, so by line 6 the name points at
    //     the new "Shift A".
    //
    //     Same idea explains line 2: trim() on line 1 returned a trimmed
    //     copy, but rawEntry itself was never touched, so it still has its
    //     stray spaces.
    //
    // (d) See the added println at the bottom of main.
    //
    // ============================================================

    public static void main(String[] args) {

        String rawEntry = "  Line 7  ";

        System.out.println("[" + rawEntry.trim() + "]");        // line 1 -> [Line 7]
        System.out.println("[" + rawEntry + "]");               // line 2 -> [  Line 7  ]

        String trimmed = rawEntry.trim();
        System.out.println("[" + trimmed.toLowerCase() + "]");  // line 3 -> [line 7]
        System.out.println("[" + trimmed + "]");                // line 4 -> [Line 7]

        String shift = "Shift";
        shift.concat(" A");                                     // return value discarded
        System.out.println("[" + shift + "]");                  // line 5 -> [Shift]

        shift = shift.concat(" A");                             // return value kept
        System.out.println("[" + shift + "]");                  // line 6 -> [Shift A]

        // (d): trim() only removes spaces from the two ends, so it would
        //      leave the space between "Line" and "7". replace() removes
        //      characters from anywhere in the String, so replacing every
        //      space with an empty String deletes all five of them.
        System.out.println("[" + rawEntry.replace(" ", "") + "]");   // [Line7]

    }
}
