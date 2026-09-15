package instructor.demo.T05Strings;

public class InspectingStrings {

    public static void main(String[] args) {

        String partNumber = "AR-4471-B";
        // index:             0 1 2 3 4 5 6 7 8

        // length() counts every character, including the dashes
        System.out.println(partNumber.length());                         // 9

        // charAt(int) returns one character. The first is at index 0, so the
        // last one is at length() - 1 -- never at length().
        System.out.println(partNumber.charAt(0));                        // A
        System.out.println(partNumber.charAt(partNumber.length() - 1));  // B (revision letter)

        // indexOf(String) returns the position of the first match, or -1 if
        // the text does not appear at all
        System.out.println(partNumber.indexOf("-"));                     // 2
        System.out.println(partNumber.indexOf("4471"));                  // 3
        System.out.println(partNumber.indexOf("Z"));                     // -1

        // contains(String) answers the same question as a true/false value
        System.out.println(partNumber.contains("4471"));                 // true
        System.out.println(partNumber.contains("Z"));                    // false

        // isEmpty() is true only when length() is 0
        String operatorNote = "";
        System.out.println(operatorNote.isEmpty());                      // true
        System.out.println(partNumber.isEmpty());                        // false
    }
}
