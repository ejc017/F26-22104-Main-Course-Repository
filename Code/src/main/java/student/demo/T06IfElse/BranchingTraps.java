package instructor.demo.T06IfElse;

public class BranchingTraps {

    public static void main(String[] args) {

        int defectCount = 0;

        // TRAP 1 -- a stray semicolon ends the if statement immediately, so the
        // block below is not attached to it and runs no matter what.
        if (defectCount > 5);
        {
            System.out.println("TRAP 1 -- scrapped a part with " + defectCount + " defects");
        }

        // TRAP 2 -- = assigns, == compares. This compiles, takes the branch
        // every time, and silently changes batchPassed on the way through.
        // The comparison that was meant here is (batchPassed == true).
        boolean batchPassed = false;
        if (batchPassed = true) {
            System.out.println("TRAP 2 -- branch taken even though batchPassed started false");
        }
        System.out.println("TRAP 2 -- batchPassed is now " + batchPassed);

        // TRAP 3 -- Java has no chained comparison. Uncomment to see:
        //     error: bad operand types for binary operator '<='
        //       first type:  boolean
        //       second type: int
        // 0 <= defectCount produces a boolean, which cannot then be compared
        // to 4. Build the range with && instead.
        // if (0 <= defectCount <= 4) {
        //     System.out.println("rework");
        // }

        // TRAP 4 -- every if and else block needs both of its braces.
        // Uncomment to see:
        //     error: 'else' without 'if'
        // if (defectCount > 5) {
        //     System.out.println("scrap");
        // else
        //     System.out.println("keep");
        // }
    }
}
