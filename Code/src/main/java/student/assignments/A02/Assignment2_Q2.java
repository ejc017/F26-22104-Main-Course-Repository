package instructor.assignments.A02;

import java.util.Locale;

public class Assignment2_Q2 {

    public static void main(String[] args) {

        // TODO (a): Declare a String named encounterCode holding your own
        //           encounter code.
        String encounterCode = "NS-0407-S";

        // TODO (b): Print the code length, the initials, the visit number, and
        //           the priority letter, each on its own line with a short
        //           label. Calculate each one from encounterCode.

        System.out.println("Encounter length = " + encounterCode.length());
        System.out.println("Initials are = " + encounterCode.substring(0,encounterCode.indexOf("-")));
        System.out.println("Visiting Number is = " + encounterCode.substring(3,7));
        System.out.println("Priority Letter = " + encounterCode.substring(encounterCode.length()));


        // TODO (c): Print the unit name below cleaned up, wrapped in square
        //           brackets, so it reads [EMERGENCY DEPARTMENT] -- capitalized,
        //           no spaces on either end, and exactly one space in the
        //           middle. trim() reaches only the two ends of a String, and
        //           the ends are not the only place this value has a problem.
        //           The variable is already declared for you.
        String rawUnitName = "   emergency  department   ";
        System.out.println("[" + rawUnitName.trim().toUpperCase() + "]");

        // TODO (d): Print rawUnitName one more time, again wrapped in square
        //           brackets, and explain in a comment what the result shows.
        System.out.println("[" + rawUnitName + "]");
        //rawUnitName was not changed in the previous
        //print statement because Strings are immutable
        //and we did not re-initialize it with the new value

    }
}
