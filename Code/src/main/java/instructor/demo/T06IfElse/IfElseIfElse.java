package instructor.demo.T06IfElse;

public class IfElseIfElse {

    public static void main(String[] args) {

        // a third outcome means a third counter
        int passCount = 0;
        int reworkCount = 0;
        int scrapCount = 0;

        String disposition = "rework";

        if (disposition.equals("pass")) {          // first branch
            passCount += 1;
        }
        else if (disposition.equals("rework")) {   // second branch
            reworkCount += 1;
        }
        else {                                     // third branch: anything else
            scrapCount += 1;
        }

        System.out.println("# Passed: " + passCount + "\n"
                + "# Rework: " + reworkCount + "\n"
                + "# Scrap:  " + scrapCount);
    }
}
