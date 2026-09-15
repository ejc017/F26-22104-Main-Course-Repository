package instructor.demo.T06IfElse;

public class DetectingRanges {

    public static void main(String[] args) {

        int defectCount = 3;

        // A RANGE needs two comparisons joined with &&. There is no way to
        // write it as a single chained comparison in Java.
        if (defectCount == 0) {
            System.out.println("Disposition: pass");
        }
        else if (defectCount >= 1 && defectCount <= 4) {
            System.out.println("Disposition: rework");
        }
        else {
            System.out.println("Disposition: scrap");
        }

        // || is true when EITHER side is true
        String shift = "night";
        if (shift.equals("night") || shift.equals("swing")) {
            System.out.println("Off-hours inspection: second signature required");
        }

        // ! reverses a condition, so this reads "not a pass"
        String inspectionResult = "fail";
        if (!inspectionResult.equals("pass")) {
            System.out.println("Part did not pass; routing to review");
        }

        // && stops evaluating as soon as its left side is false. Here that
        // guard is what prevents a divide-by-zero runtime error when no parts
        // were inspected -- the division on the right never runs.
        int partsInspected = 0;
        int defectsFound = 0;
        if (partsInspected != 0 && defectsFound / partsInspected > 2) {
            System.out.println("Defect rate above threshold");
        }
        else {
            System.out.println("Nothing to report for this shift");
        }
    }
}
