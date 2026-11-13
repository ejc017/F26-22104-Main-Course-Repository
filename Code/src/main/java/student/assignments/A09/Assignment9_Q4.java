package instructor.assignments.A09;

// This file COMPILES, but it contains bugs. Do not rewrite it; find each bug and fix it.
public class Assignment9_Q4 {

    // ===================== YOUR RECORDED RESULTS =====================
    //
    // (a) THE BUGGY RUN: before you change anything, run the program and
    //     record the first FOUR lines of its output.
    //
    //     B-101: 8 defects in 500 units -> 0.00%
    //     B-102: 8 defects in 400 units -> 0.00%
    //     B-103: 10 defects in 250 units -> 0.00%
    //     B-104: 12 defects in 800 units -> 0.00%
    //
    // (b) THE FIX: there are exactly five bugs, three in Batch.java and
    //     two in this file.
    //
    //     THE BUG LIST: for each one, give the class and method, say what
    //     was wrong, and show the corrected line.
    //
    //     Bug 1: Batch, defectRatePercent - defects / units is int division,
    //            so it is 0 for every batch and every rate printed 0.00%.
    //            Corrected: return defects * 100.0 / units;
    //     Bug 2: Batch, isAcceptable - used < but "at most" means <=, so a
    //            batch at exactly 2.00% (B-102) was not counted.
    //            Corrected: return defectRatePercent() <= maxPercent;
    //     Bug 3: Batch, setDefects - "defects = defects;" assigned the
    //            parameter to itself, so the field never changed and B-103
    //            still showed 10 defects after rework.
    //            Corrected: this.defects = defects;
    //     Bug 4: Assignment9_Q4, indexOfWorst - the loop stopped at
    //            batches.length - 1, so the last batch (B-105) was never
    //            checked. Corrected: for (int i = 1; i < batches.length; i++) {
    //     Bug 5: Assignment9_Q4, countAcceptable - "return count;" was inside
    //            the for loop, so it returned after checking only the first
    //            batch. Corrected: removed the return inside the loop, so the
    //            loop checks every batch and the "return count;" after the
    //            loop returns the full count.
    //
    // ================================================================

    public static void main(String[] args) {

        Batch[] batches = {
                new Batch("B-101", 500, 8),
                new Batch("B-102", 400, 8),
                new Batch("B-103", 250, 10),
                new Batch("B-104", 800, 12),
                new Batch("B-105", 200, 14)
        };

        for (int i = 0; i < batches.length; i++) {
            System.out.printf("%s -> %.2f%%%n", batches[i], batches[i].defectRatePercent());
        }

        int worst = indexOfWorst(batches);
        System.out.println("Worst batch: " + batches[worst].getId());
        System.out.println("Acceptable at 2.0%: " + countAcceptable(batches, 2.0) + " of " + batches.length);
        System.out.printf("Average defect rate: %.2f%%%n", averageDefectRate(batches));

        // B-103 is reworked and inspected again: only 4 defects remain.
        batches[2].setDefects(4);
        System.out.printf("%s -> %.2f%%%n", batches[2], batches[2].defectRatePercent());
        System.out.println("Acceptable at 2.0%: " + countAcceptable(batches, 2.0) + " of " + batches.length);
    }

    // Return the INDEX of the batch with the highest defect rate (the first, if two tie).
    public static int indexOfWorst(Batch[] batches) {
        int worst = 0;
        for (int i = 1; i < batches.length; i++) {
            if (batches[i].defectRatePercent() > batches[worst].defectRatePercent()) {
                worst = i;
            }
        }
        return worst;
    }

    // Return how many batches are acceptable at the given maximum percent.
    public static int countAcceptable(Batch[] batches, double maxPercent) {
        int count = 0;
        for (int i = 0; i < batches.length; i++) {
            if (batches[i].isAcceptable(maxPercent)) {
                count++;
            }
        }
        return count;
    }

    // Return the mean of the defect rates of all the batches.
    public static double averageDefectRate(Batch[] batches) {
        double total = 0.0;
        for (int i = 0; i < batches.length; i++) {
            total += batches[i].defectRatePercent();
        }
        return total / batches.length;
    }
}