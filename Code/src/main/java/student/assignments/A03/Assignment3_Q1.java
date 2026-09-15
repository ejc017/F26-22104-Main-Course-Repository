ppackage instructor.assignments.A03;

import java.util.Scanner;

public class Assignment3_Q3 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) PREDICTIONS -- fill these in BEFORE you run the program.
    //     Every line the program prints for each pair of entries. "Nothing at
    //     all" is a valid prediction if that is what you expect.
    //       scanned 4, ordered 4: complete order
    //       scanned 3, ordered 5: mismatch
    //       scanned 0, ordered 0: empty order
    //
    // (b) ACTUAL OUTPUT -- run the program three times and record what each
    //     run printed. Leave your predictions in (a) unchanged.
    //       scanned 4, ordered 4:
    //       Enter the number of items scanned: 4
    //       Enter the number of items the order called for: 4
    //       MISMATCH - send to recount
    //       Packing station released
    //
    //       scanned 3, ordered 5:
    //       Enter the number of items scanned: 3
    //       Enter the number of items the order called for: 5
    //       Packing station released
    //
    //       scanned 0, ordered 0:
    //       Enter the number of items scanned: 0
    //       Enter the number of items the order called for: 0
    //       Empty order - nothing to pack
    //       Packing station released
    //
    // (c) EXPLANATION
    //     Which if does the else below actually belong to, and what rule does
    //     Java use to decide that?
    //     Then, for the 4/4 run and the 3/5 run
    //     specifically, why did the wrong thing happen? There is no condition
    //     in the nested if for a complete order and the else that executes the
    //     mismatch code has no brackets enclosing it
    //
    //
    // (d) OUTPUT AFTER YOUR FIX -- re-run all three pairs, plus the negative
    //     count from part (e).
    //       scanned 4, ordered 4:
    //       Enter the number of items scanned: 4
    //       Enter the number of items the order called for: 4
    //       Order complete - 4 items packed
    //       Packing station released
    //
    //       scanned 3, ordered 5:
    //       Enter the number of items scanned: 3
    //       Enter the number of items the order called for: 5
    //       MISMATCH - send to recount
    //       Packing station released
    //
    //       scanned 0, ordered 0:
    //       Enter the number of items scanned: 0
    //       Enter the number of items the order called for: 0
    //       Empty order - nothing to pack
    //       Packing station released
    //
    //       scanned -1, ordered 4:
    //       Error: item counts cannot be negative
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of items scanned: ");
        int scanned = input.nextInt();

        System.out.print("Enter the number of items the order called for: ");
        int ordered = input.nextInt();

        // The indentation below says what the programmer meant. The compiler
        // does not read indentation.
        //
        // TODO (d): Add braces so this does what the three messages claim:
        //             counts match, count is 0     -> Empty order - nothing to pack
        //             counts match, count above 0  -> Order complete - N items packed
        //             counts do not match          -> MISMATCH - send to recount
        //           Keep it nested: the outer question is whether the counts
        //           match, and the inner question is asked only when they do.
        //
        // TODO (e): Then wrap your fixed branching in a validity check. If
        //           either count is below zero, print
        //           "Error: item counts cannot be negative" and print none of
        //           the three messages above. Use ||, and use an if -- not
        //           try/catch. Assume both counts are typed as whole numbers;
        //           a negative count is the only bad value to guard against.

        if (scanned < 0 || ordered < 0) {

            System.out.println("Error: item counts cannot be negative");

        } else {

            if (scanned == ordered) {

                if (scanned == 0) {

                    System.out.println("Empty order - nothing to pack");

                } else {

                    System.out.println("Order complete - " + scanned + " items packed");

                }

            } else {

                System.out.println("MISMATCH - send to recount");

            }

            System.out.println("Packing station released");
        }

        input.close();
    }
}
}