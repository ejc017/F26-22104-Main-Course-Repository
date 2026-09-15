package student.assignments.A01;

public class Assignment1_Q3 {

    // TODO: Remove the block comment below when you are ready to work on this question.

    public static void main(String[] args) {

        // Defects found on each of three shifts of a production day
        int shift1Defects = 12;
        int shift2Defects = 9;
        int shift3Defects = 14;

        int shiftCount = 3;
        double averageDefects = (shift1Defects + shift2Defects + shift3Defects) / (double)shiftCount; // a double will more accurately reflect the mean without truncating the number
        System.out.println("Average defects per shift: " + averageDefects);

        // Cost per unit for a batch that had to be fully scrapped
        int totalBatchCost = 4800;
        int unitsProduced = 1;
        int costPerUnit = totalBatchCost / unitsProduced; //I had 0 units being produced which causes an error bc you cant divide by 0,
        System.out.println("Cost per unit: " + costPerUnit);
    }


}
