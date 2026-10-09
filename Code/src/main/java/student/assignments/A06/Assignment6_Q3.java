package instructor.assignments.A06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Assignment6_Q2 {

    // ===================== YOUR WRITTEN ANSWERS =====================
    //
    // (a) LINE NUMBERS -- one example line number from a06_receivingLog.txt
    //     for each item. Look at the file before you write any code.
    //       a blank line: (fill in from the input file)
    //       a comment line: (fill in from the input file)
    //       the header line: (fill in from the input file)
    //       a row that breaks R1: (fill in from the input file)
    //       a row that breaks R2: (fill in from the input file)
    //       a row that breaks R3: (fill in from the input file)
    //
    // (g) CONSOLE SUMMARY -- record the full summary your program prints.
    //     (Copy the actual summary after running the program.)
    //
    //     Why is it better to write the rejected rows to a file, with line
    //     numbers and the original text, than to simply skip over them?
    //
    //     Saving rejected rows with their line numbers and original text
    //     makes errors easier to find, check, and correct.
    //
    // ================================================================

    public static void main(String[] args) throws FileNotFoundException {

        // TODO (b): Create a Scanner on data/a06_receivingLog.txt and read it
        //           one line at a time (hasNextLine / nextLine), counting
        //           which line number you are on (the first line is line 1).
        //           Keep the original line, and work with a trimmed copy.
        //           IGNORE (count, then do nothing else with) a line whose
        //           trimmed copy is empty, starts with "#", or starts with
        //           "lot,".

        Scanner input = new Scanner(
                new FileInputStream("data/a06_receivingLog.txt"));
        PrintWriter rejects = new PrintWriter(
                "output/a06_receivingRejects.txt");
        PrintWriter clean = new PrintWriter(
                "output/a06_receivingClean.txt");

        int linesRead = 0;
        int ignored = 0;
        int accepted = 0;
        int rejectedR1 = 0;
        int rejectedR2 = 0;
        int rejectedR3 = 0;

        while (input.hasNextLine()) {
            String originalLine = input.nextLine();
            linesRead++;
            String line = originalLine.trim();

            // Skips blank lines, comments, and the header
            if (line.isEmpty() || line.startsWith("#")
                    || line.toLowerCase().startsWith("lot,")) {
                ignored++;
                continue;
            }

            // TODO (c): Every other line is a record. Reject it with the FIRST
            //           of these rules that it breaks:
            //             R1  the trimmed line does not contain exactly 4 commas
            //             R2  qty or defects is empty or "N/A"
            //             R3  qty <= 0, or defects < 0, or defects > qty

            int commaCount = 0; // Counts commas in the record
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaCount++;
                }
            }

            String rule = "";

            // Checks whether the record has the correct number of fields
            if (commaCount != 4) {
                rule = "R1";
                rejectedR1++;
            } else {
                // Extracts each field from the line
                String rest = line;
                int comma = rest.indexOf(',');
                String lot = rest.substring(0, comma).trim();
                rest = rest.substring(comma + 1);

                comma = rest.indexOf(',');
                String supplier = rest.substring(0, comma).trim();
                rest = rest.substring(comma + 1);

                comma = rest.indexOf(',');
                String part = rest.substring(0, comma).trim();
                rest = rest.substring(comma + 1);

                comma = rest.indexOf(',');
                String qtyText = rest.substring(0, comma).trim();
                String defectsText = rest.substring(comma + 1).trim();

                // Checks missing values before parsing numbers
                if (qtyText.isEmpty() || defectsText.isEmpty()
                        || qtyText.equalsIgnoreCase("N/A")
                        || defectsText.equalsIgnoreCase("N/A")) {
                    rule = "R2";
                    rejectedR2++;
                } else {
                    int qty = Integer.parseInt(qtyText);
                    int defects = Integer.parseInt(defectsText);

                    // Checks whether the numbers make sense
                    if (qty <= 0 || defects < 0 || defects > qty) {
                        rule = "R3";
                        rejectedR3++;
                    } else {
                        // Formats accepted fields for the clean file
                        String cleanLot = lot.toUpperCase();
                        String cleanSupplier = supplier.toUpperCase();
                        String cleanPart = "";

                        if (!part.isEmpty()) {
                            cleanPart = part.substring(0, 1).toUpperCase()
                                    + part.substring(1).toLowerCase();
                        }

                        // Writes the accepted record
                        clean.printf("%s,%s,%s,%d,%d%n",
                                cleanLot, cleanSupplier, cleanPart, qty, defects);
                        accepted++;
                    }
                }
            }

            // TODO (d): For each rejected record, write one line to
            //           output/a06_receivingRejects.txt with the line number,
            //           the rule, and the ORIGINAL (untrimmed) line.

            if (!rule.isEmpty()) {
                rejects.printf("Line %d [%s] %s%n",
                        linesRead, rule, originalLine);
            }
        }

        // TODO (f): After the loop, close everything and print the summary
        input.close();
        rejects.close();
        clean.close();

        // Prints the processing totals
        System.out.printf("Lines read: %d%n", linesRead);
        System.out.printf("Ignored (blank, comment, header): %d%n", ignored);
        System.out.printf("Accepted: %d%n", accepted);
        System.out.printf("Rejected [R1] wrong field count: %d%n", rejectedR1);
        System.out.printf("Rejected [R2] missing value: %d%n", rejectedR2);
        System.out.printf("Rejected [R3] impossible value: %d%n", rejectedR3);

        // TODO (e): For each accepted record, write one line to
        //           output/a06_receivingClean.txt: lot id and supplier in
        //           UPPER CASE, part name with only its first letter
        //           capitalized, qty, and defects, no stray spaces.
        //
        // The accepted records are written to the clean file inside the loop.
    }
}