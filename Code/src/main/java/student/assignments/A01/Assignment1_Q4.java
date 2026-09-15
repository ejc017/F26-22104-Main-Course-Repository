package student.assignments.A01;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment1_Q4 {
    //prediction = 8.00
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // TODO: Use System.out.print() to prompt the user to enter a machine's
        //       cycle time in seconds (a decimal value), then read it into a
        //       double using the appropriate Scanner method
        System.out.println("Enter the machine cycle time in seconds(decimal value)");
        double cycTime = input.nextDouble();
        // TODO: Use System.out.print() to prompt the user to enter the number of
        //       units to produce (a whole number), then read it into an int
        //       using the appropriate Scanner method
        System.out.println("Enter the number of units to produce(integer)");
        double unitToProd = input.nextInt();

        // TODO: Calculate the total production time in minutes:
        //       total minutes = (cycle time in seconds * number of units) / 60
        double totMin = (cycTime*(double)unitToProd) / 60.0;
        // TODO: Use System.out.printf() to print the total production time,
        //       formatted to 2 decimal places
        System.out.printf("Total production time = %.2f", totMin);

    }
}
