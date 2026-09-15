package instructor.practiceActivities.PA01;
//import java.lang.reflect.Method;
import java.util.ArrayList;
//import java.util.Locale;
//import java.util.Scanner;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;
//import java.sql.SQLOutput;
//import java.util.Arrays;

public class PracticeActivity1_Q2 {


    static String TitleCase (String para) {
        ArrayList<String> arr = new ArrayList<>();
        int nxtSpace; // Next space character in para
        //System.out.println(nxtSpace);
        int firstSpace = 0; // Never changes because we delete first word every loop
        String firstWord; // Word that we are changing at i
        String firstLttr; // First letter of firstWord var at i
        String temp; // temporary variable used to store original first letter
        StringBuilder finalString = new StringBuilder(); // String we will return
        while (true) { // uses if statement to break out of infinite loop
            nxtSpace = para.indexOf(" "); // finds next space in para
            if (nxtSpace == -1){ //if the Next Space does not exist, run this code

                firstLttr = para.substring(0, 1); // Finds the first letter of para
                // (not firstWord bc para is only one word rn)
                temp = firstLttr; // Assign temp to store firstLetter so we can use it after reinitializing it
                firstLttr = firstLttr.toUpperCase(); // Reinitializes firstLttr to an UpperCase Version of itself
                para = firstLttr + para.replace(temp, ""); //
                arr.add(para);
                break;
            }//end if statement
            else {
                //System.out.println(nxtSpace);
                firstWord = para.substring(firstSpace, nxtSpace);
                para = para.replaceFirst(Pattern.quote(firstWord + " "), "");
                //System.out.println(firstWord);
                firstLttr = firstWord.substring(0, 1);
                temp = firstLttr;
                firstLttr = firstLttr.toUpperCase();
                firstWord = firstLttr + firstWord.replace(temp, "");
                arr.add(firstWord);

                //System.out.println(pGraph);
                //System.out.println();
            }//end else statement
        }
        System.out.println();
        System.out.println("arr.size() = " + arr.size());
        System.out.println();

        for(int i = 0; i < arr.size(); i++){

            finalString.append(arr.get(i)).append(" ");

        }

        return finalString.toString();


    }//end method TitleClass

    public static void main(String[] args) {

        // A line pulled straight out of a maintenance log.
        String logEntry = "Press 12 cleared inspection";
        String operatorNote = "";

        // TODO (a): Print how many characters are in logEntry, with a short
        //           label so the output is readable.
        System.out.println("logEntry = " + logEntry);

        System.out.println("There are " + logEntry.length() + " characters in logEntry");

        // TODO (b): Print the first character of logEntry, and then the last
        //           character. Get the last one from length(), not from a
        //           number you counted yourself.
        System.out.println("The first character is = " + logEntry.substring(0, 1) + " and the last character is " + logEntry.substring(logEntry.length() - 1));

        // TODO (c): Print the index where the word "cleared" begins.
        String findWord = "cleared";
        System.out.println("The index where \'cleared\' begins is = " + logEntry.indexOf(findWord));


        // TODO (d): Two prints here, both starting from what indexOf gave you
        //           in (c). Do not type in a position number you counted.
        //             1. everything from "cleared" to the end of the line, so
        //                it reads: cleared inspection
        //             2. the word "cleared" on its own, with nothing after it.
        //                This one needs the two-argument form of substring,
        //                and indexOf can find the second bound for you too.

        System.out.println("Everything from " + findWord + " in logEntry and on = " + logEntry.substring(logEntry.indexOf(findWord)));
        System.out.println("Just logEntry" + findWord + " = " + logEntry.substring(logEntry.indexOf(findWord), logEntry.indexOf(findWord) + findWord.length()));

        // TODO (e): Print whether logEntry contains the word "scrapped".
        System.out.println("It is " + logEntry.contains("scrapped") + " that logEntry contains \'scrapped\'.");
        // TODO (f): Print whether operatorNote is empty, and then print
        //           whether logEntry is empty.
        System.out.println("It is " + operatorNote.isEmpty() + " that operatorNote is empty");

        // TODO (g): Predict what the line below will do when you uncomment it,
        //           then uncomment it and run. Record the name of the error
        //           in a comment, then put the // back so the file is left in
        //           a runnable state.
        //there will be a runtime error because you are
        // trying to grab a char past the bounds of the string
//        System.out.println(logEntry.charAt(logEntry.length()));
//
//        Exception in thread "main" java.lang.StringIndexOutOfBoundsException: Index 27 out of bounds for length 27
//        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
//        at java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
//        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
//        at java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
//        at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
//        at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
//        at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
//        at java.base/java.lang.String.checkIndex(String.java:4904)


        //ignore i just want to practice
        System.out.println();
        System.out.println();
        String pGraph = "The domestic pigeon (Columba livia \"domestica\" or\n" +
                " Columba livia forma domestica)[2] is a domesticated bird derived" +
                " from the rock dove (Columba livia), of which it is also a subspecies.\n" +
                " Although often termed a \"subspecies\", the domesticated" +
                " pigeon does not constitute an accepted zoological subspecies of the\n" +
                " rock dove,[1] but a collection of over 350 breeds.[3] The rock" +
                " dove is among the world's first birds to be domesticated;\n" +
                " Mesopotamian cuneiform tablets mention the domestication of pigeons more than" +
                " 5,000 years ago, as do Egyptian hieroglyphs. Pigeons \n" +
                "have held historical importance to humans as food, pets," +
                " symbolic animals, and messengers.\n" +
                " Due to their homing ability, pigeons have been used to" +
                " deliver messages, including war pigeons during the two\n" +
                " world wars. City pigeons, which are" +
                " feral birds, are generally seen as pests, mainly due\n" +
                " to their droppings and a reputation for spreading disease.";
        System.out.println(pGraph);
        System.out.println();
        String newPara = TitleCase(pGraph);
        System.out.println();
        System.out.println("Title Case Input = ");
        System.out.println(newPara);







    }


}
