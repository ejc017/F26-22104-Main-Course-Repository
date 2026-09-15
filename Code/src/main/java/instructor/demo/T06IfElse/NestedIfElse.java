package instructor.demo.T06IfElse;

import java.util.Scanner;

public class NestedIfElse {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        String stateInput;
        int income;

        System.out.println("Enter State (WI, NC or NV)");
        stateInput = scnr.nextLine();
        System.out.println("Enter Income");
        income = scnr.nextInt();

        double taxRate = 0;

        // OUTER if-else: which state was entered
        if (stateInput.equals("WI")) {
            // NESTED if-else: which income bracket the income falls into
            if (income > 200000) {
                taxRate = .5;
            }
            else if (income >= 75000) {
                taxRate = .35;
            }
            else {
                taxRate = .25;
            }
        }
        else if (stateInput.equals("NC")) {
            if (income > 200000) {
                taxRate = .45;
            }
            else if (income >= 75000) {
                taxRate = .30;
            }
            else {
                taxRate = .20;
            }
        }
        else if (stateInput.equals("NV")) {
            if (income > 200000) {
                taxRate = .425;
            }
            else if (income >= 75000) {
                taxRate = .325;
            }
            else {
                taxRate = .175;
            }
        }
        else {
            System.out.println("Invalid State Entered");
        }

        // taxRate is still 0 for a state that matched none of the branches
        // above, so the summary is only printed for a recognized state.
        if (stateInput.equals("WI") || stateInput.equals("NC") || stateInput.equals("NV")) {
            System.out.println("Tax rate for " + stateInput + " with income " + income + ": " + taxRate);
        }

        scnr.close();
    }
}
