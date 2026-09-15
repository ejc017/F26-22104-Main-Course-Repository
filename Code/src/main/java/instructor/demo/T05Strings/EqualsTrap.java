package instructor.demo.T05Strings;

import java.util.Locale;
import java.util.Scanner;

public class EqualsTrap {

    public static void main(String[] args) {

        // Two Strings written directly into the code, holding the same text.
        String a = "pass";
        String b = "pass";

        // == does not ask "do these hold the same characters?" It asks "are
        // these the same object in memory?" Java saves memory by letting both
        // names point at one shared "pass", so this happens to come out true.
        System.out.println(a == b);        // true

        // Now the same four characters, assembled while the program runs
        // instead of written into the code. concat returns a NEW object.
        String c = "pa";
        String d = c.concat("ss");

        System.out.println(d);             // pass -- identical characters to a
        System.out.println(d == a);        // predict this one before running
        System.out.println(d.equals(a));   // and this one

        String r = "   PASS   ";
        System.out.println(r.trim().toLowerCase().equals("pass"));

        // Two comparisons, same characters both times, opposite answers. That
        // is the trap: == is not wrong in some predictable way you could work
        // around, it is unreliable. Anything Java builds while the program
        // runs -- concat, substring, trim, keyboard input -- is a new object.

        Scanner scnr = new Scanner(System.in);

        System.out.print("Did the batch pass? (pass/fail) ");
        String response = scnr.nextLine();

        // The keyboard is the most common source of runtime-built Strings, so
        // it is the most common place this bites. equals compares characters,
        // which is the question you actually meant to ask.
        System.out.println(response.equals("pass"));

        // equalsIgnoreCase asks the same question, treating pass, Pass, and
        // PASS alike.
        System.out.println(response.equalsIgnoreCase("PASS"));

        scnr.close();
    }
}
