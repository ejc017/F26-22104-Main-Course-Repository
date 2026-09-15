package instructor.demo.T06IfElse;

public class SingleIfElse {

    public static void main(String[] args) {

        // one counter per outcome, each initialized to zero
        int passCount = 0;
        int failCount = 0;

        String inspectionResult = "pass";

        if (inspectionResult.equals("pass")) {   // first branch: the part passed
            passCount += 1;                      // increase passCount by 1
        }
        else {                                   // second branch: anything else
            failCount += 1;                      // increase failCount by 1
        }

        System.out.println("# Passed: " + passCount + "\n"
                + "# Failed: " + failCount);

        // Only one part is considered here, which is why the answer is easy to
        // predict. Loops and arrays, later this semester, let a single if-else
        // statement classify hundreds of parts.
    }
}
