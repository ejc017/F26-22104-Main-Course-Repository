package instructor.practiceActivities.PA01_Solution;

public class PracticeActivity1_Q2 {

    public static void main(String[] args) {

        // A line pulled straight out of a maintenance log.
        String logEntry = "Press 12 cleared inspection";
        // index:          0    5    10   15   20   25
        String operatorNote = "";

        // (a) length() counts every character, spaces included.
        System.out.println("Length: " + logEntry.length());                          // Length: 27

        // (b) The first character sits at index 0, so the last one sits at
        //     length() - 1. Asking length() for it is what keeps this correct
        //     if the log entry is ever swapped for a different line.
        System.out.println("First character: " + logEntry.charAt(0));                // P
        System.out.println("Last character: " + logEntry.charAt(logEntry.length() - 1)); // n

        // (c) indexOf reports where the first match begins -- the position of
        //     the "c" in "cleared" -- or -1 if the text is not there at all.
        int clearedIndex = logEntry.indexOf("cleared");
        System.out.println("Index of cleared: " + clearedIndex);                     // 9

        // (d) One-argument substring: from clearedIndex to the end of the line.
        System.out.println("From cleared on: " + logEntry.substring(clearedIndex));  // cleared inspection

        //     Two-argument substring stops BEFORE the index given, so the end
        //     bound has to be the space that follows "cleared". indexOf finds
        //     that for us: "inspection" starts at 17, and the space sits one
        //     position earlier, at 16. Nothing here is a number counted by hand.
        int inspectionIndex = logEntry.indexOf("inspection");
        System.out.println("Just the word: " + logEntry.substring(clearedIndex, inspectionIndex - 1)); // cleared

        //     Equally good, and with no arithmetic at all -- search for the
        //     space and the word together, which lands directly on index 16:
        //     logEntry.substring(clearedIndex, logEntry.indexOf(" inspection"))

        // (e) contains asks the same question indexOf does, but answers it as
        //     a boolean instead of a position.
        System.out.println("Contains scrapped: " + logEntry.contains("scrapped"));   // false

        // (f) isEmpty() is true only when length() is 0. A blank note is an
        //     empty String, not a null one -- it exists, it just holds nothing.
        System.out.println("Note is empty: " + operatorNote.isEmpty());              // true
        System.out.println("Log entry is empty: " + logEntry.isEmpty());             // false

        // (g) PREDICTION: this crashes rather than printing anything.
        //     ERROR: StringIndexOutOfBoundsException
        //       (message on this JDK: "Index 27 out of bounds for length 27".
        //        The exact wording has changed between Java versions; the
        //        name of the exception is the part that is stable.)
        //     WHY: indexes start at 0, so 27 characters occupy indexes 0
        //     through 26. length() is one past the last valid index, which
        //     makes length() - 1 the last character. Left commented out so
        //     the file still runs.
        // System.out.println(logEntry.charAt(logEntry.length()));


        // ==================== IF YOU FINISH EARLY ====================

        // 1. indexOf reports "not found" as -1. It does not return 0 -- that
        //    is a real position, the first character -- and it does not
        //    crash. Anything that came back negative means "not in here".
        System.out.println("indexOf z: " + "Press 12".indexOf("z"));            // -1

        // 2. Same neighborhood of the String, two different types. substring
        //    returns a String and stops BEFORE index 8, so it hands back
        //    indexes 6 and 7 together. charAt returns a single char: index 6
        //    and nothing else. A String can hold any number of characters,
        //    including zero; a char is always exactly one. That is the whole
        //    difference between the two types.
        System.out.println("substring(6, 8): " + logEntry.substring(6, 8));     // 12
        System.out.println("charAt(6): " + logEntry.charAt(6));                 // 1

        // 3. trim() has nothing but spaces to work with, so it removes all of
        //    them and returns an empty String -- isEmpty() confirms it. Note
        //    that allSpaces itself is untouched and still three characters
        //    long, the same immutability point from Question 1.
        String allSpaces = "   ";
        System.out.println("[" + allSpaces.trim() + "]");                       // []
        System.out.println("Trimmed is empty: " + allSpaces.trim().isEmpty());  // true
        System.out.println("Original length: " + allSpaces.length());           // 3

    }
}
