package instructor.demo.T04KeyboardInputConsoleOutput;

import java.util.Scanner;

public class NextLineTrap {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter a batch size: ");
        int batchSize = scnr.nextInt();

        // Predict: what happens when the two lines below are uncommented and run?
        // System.out.print("Enter an operator note: ");
        // String note = scnr.nextLine();
        // System.out.println("Note: " + note);

        System.out.println("Batch size: " + batchSize);

        scnr.close();
    }
}
