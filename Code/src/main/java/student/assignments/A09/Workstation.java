package student.assignments.A09;
public class Workstation {

    // fields (given). Every field is private.
    private String name;
    private double cycleTimeSec;    // seconds to finish one unit at this station

    // TODO (a): default constructor. Name "Unassigned" and a cycle time of 60.0.
    //           (Not 0.0: unitsPerHour divides by the cycle time.)
    public Workstation() {
        name = "Unassigned";
        cycleTimeSec = 60.0;
    }

    // TODO (a): fully parameterized constructor. Parameters in the order of the
    //           fields above: name, cycleTimeSec.
    public Workstation(String name, double cycleTimeSec) {
        this.name = name;
        this.cycleTimeSec = cycleTimeSec;
    }

    // TODO (a): accessors.
    public String getName() {
        return name;
    }

    public double getCycleTimeSec() {
        return cycleTimeSec;
    }

    // TODO (a): mutator.
    public void setCycleTimeSec(double cycleTimeSec) {
        this.cycleTimeSec = cycleTimeSec;
    }

    // TODO (b): return how many units this station can finish in one hour:
    //           there are 3600 seconds in an hour, so 3600.0 divided by the
    //           cycle time. It takes no parameter: the station it is called on
    //           supplies the cycle time.
    public double unitsPerHour() {
        return 3600.0 / cycleTimeSec;
    }

    // TODO (b): return true if this station can finish AT LEAST demandPerHour
    //           units in an hour, otherwise false. Exactly meeting the demand
    //           counts as meeting it. Call unitsPerHour(); do not repeat its
    //           formula here.
    public boolean meetsDemand(double demandPerHour) {
        return unitsPerHour() >= demandPerHour;
    }

    // Given. Do not change.
    public String toString() {
        return name + " (" + cycleTimeSec + " s per unit)";
    }
}