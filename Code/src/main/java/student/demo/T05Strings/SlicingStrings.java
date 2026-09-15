package instructor.demo.T05Strings;

public class SlicingStrings {

    public static void main(String[] args) {

        String partNumber = "AR-4471-B";
        // index:             0 1 2 3 4 5 6 7 8

        // substring(int) returns the character at beginIndex and everything
        // after it. Everything before beginIndex is left out.
        System.out.println(partNumber.substring(3));       // 4471-B

        // substring(int, int) stops BEFORE endIndex, so the last character
        // included sits at endIndex - 1.
        String plantCode = partNumber.substring(0, 2);     // A and R, stopping before index 2
        String lotNumber = partNumber.substring(3, 7);     // indexes 3 through 6

        System.out.println(plantCode);                     // AR
        System.out.println(lotNumber);                     // 4471

        // Predict: what happens when each line below is uncommented and run?
        // Both ask for an index that does not exist in a 9-character String.
        // System.out.println(partNumber.charAt(9));
        // System.out.println(partNumber.substring(3, 20));
    }
}
