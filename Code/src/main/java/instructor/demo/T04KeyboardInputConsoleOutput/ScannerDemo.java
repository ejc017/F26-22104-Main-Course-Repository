package instructor.demo.T04KeyboardInputConsoleOutput;

//import java.util.Scanner; //import line

import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter a double value");
        double newValue = scnr.nextDouble();
        System.out.println(newValue);

        System.out.println("Enter a sentence");
        String sentence = scnr.nextLine();
        System.out.println(sentence);


        // next() reads one whitespace-separated token as a String
        System.out.println("Enter single word");
        String exampleText = scnr.next();
        System.out.println(exampleText.length());
        System.out.println(exampleText);

        // nextInt() reads one token as an int
        int intInput = scnr.nextInt();
        System.out.println(intInput);

        String moreText = scnr.next();
        System.out.println(moreText.length());
        System.out.println(moreText);

        // Try entering something other than true/false here (e.g. 3.5) to see
        // a live runtime error -- a type mismatch, not a compile-time error.
        boolean booleanInput = scnr.nextBoolean();
        System.out.println(booleanInput);

        scnr.close();
    }
}
