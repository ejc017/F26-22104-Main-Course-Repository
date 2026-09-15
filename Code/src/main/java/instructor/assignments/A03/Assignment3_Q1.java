package instructor.assignments.A03;

import java.util.Scanner;

public class Assignment3_Q1 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (e) RECORDED RUNS -- paste the output of each of the five runs.
    //
    //     Run 1, pressed Enter without typing anything:
    //
    //     Run 2, typed SHIP-USF-14-K:
    //
    //     Run 3, typed PLT-USF-14-:
    //
    //     Run 4, typed PLT-USF-14:
    //
    //     Run 5, typed "  plt-usf-14-k  " (with the spaces):
    //
    //
    // ================================================================

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO (a): Prompt for and read a pallet label. Store it exactly as
        //           typed in a String named rawEntry, then make a second
        //           String named label holding rawEntry trimmed and
        //           converted to upper case.

        // TODO (b): Store the position of the first dash, the second dash, and
        //           the last dash of label in three int variables, using
        //           appropriate String methods related to finding indices. Do
        //           not type in a position you counted yourself.

        // TODO (c): Write one if / else if / else chain applying the four
        //           rejection rules in the order given in the assignment. Each
        //           rejected label prints its message and nothing else.
        //             1. rawEntry is blank        -> Error: no label entered
        //             2. no PLT- prefix           -> Error: label must begin with PLT-
        //             3. ends with a dash         -> Error: label is missing its check letter
        //             4. no second dash, OR the
        //                second dash is the last  -> Error: label is missing a field

        // TODO (d): In the final else, print the divider, the whole label, and
        //           the four fields, then the divider again. Pull every field
        //           out of label with substring and your dash positions. Build
        //           the divider with repeat, not by typing forty characters.

        input.close();
    }
}
