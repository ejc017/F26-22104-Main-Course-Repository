package instructor.assignments.A09;

// This class COMPILES, but it contains bugs. Do not rewrite it; find each bug and fix it.
public class Batch {

    private String id;
    private int units;      // units in the batch
    private int defects;    // defective units found by inspection

    public Batch(String id, int units, int defects) {
        this.id = id;
        this.units = units;
        this.defects = defects;
    }

    public String getId() {
        return id;
    }

    public int getUnits() {
        return units;
    }

    public int getDefects() {
        return defects;
    }

    // Replace the number of defects (for example after rework and re-inspection).
    public void setDefects(int defects) {
        this.defects = defects;
    }

    // The defects as a percent of the units, e.g. 8 defects in 500 units is 1.6.
    public double defectRatePercent() {
        return defects * 100.0 / units;
    }

    // A batch is acceptable if its defect rate is AT MOST maxPercent.
    public boolean isAcceptable(double maxPercent) {
        return defectRatePercent() <= maxPercent;
    }

    public String toString() {
        return id + ": " + defects + " defects in " + units + " units";
    }
}