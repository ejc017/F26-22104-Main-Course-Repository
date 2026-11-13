package student.assignments.A09;

public class Assignment9_Q3 {

    public static void main(String[] args) {

        final double DEMAND = 55.0;     // units per hour the line must deliver

        Workstation[] line = {
                new Workstation("Cut", 60.0),
                new Workstation("Drill", 72.0),
                new Workstation("Weld", 66.0),
                new Workstation("Paint", 48.0)
        };

        for (int i = 0; i < line.length; i++) {
            System.out.printf("%-6s %6.1f units/hour%n", line[i].getName(), line[i].unitsPerHour());
        }

        int slowest = indexOfBottleneck(line);
        System.out.println("Bottleneck: " + line[slowest]);
        System.out.printf("The line can deliver %.1f units/hour%n", line[slowest].unitsPerHour());
        System.out.println("Stations meeting demand: " + countMeetingDemand(line, DEMAND) + " of " + line.length);

        // A process improvement: Drill gets a faster fixture.
        line[1].setCycleTimeSec(60.0);

        slowest = indexOfBottleneck(line);
        System.out.println("After the change, bottleneck: " + line[slowest]);
        System.out.printf("The line can deliver %.1f units/hour%n", line[slowest].unitsPerHour());
        System.out.println("Stations meeting demand: " + countMeetingDemand(line, DEMAND) + " of " + line.length);
    }

    // TODO (c): return the INDEX of the bottleneck, the station that can finish the
    //           FEWEST units per hour (the first, if two tie). Begin by assuming the
    //           station at index 0 is the bottleneck and keep that index in a variable.
    //           Loop over the rest of the stations, starting at index 1. When the station
    //           at index i has a smaller unitsPerHour() (use <) than the station at the
    //           index you are keeping, replace the kept index with i. After the loop,
    //           return the kept index. Using < rather than <= is what makes the first
    //           station win a tie.
    public static int indexOfBottleneck(Workstation[] stations) {
        return 0;
    }

    // TODO (c): return how many of the stations meet the demand. Call meetsDemand on
    //           each station; do not repeat its comparison here.
    public static int countMeetingDemand(Workstation[] stations, double demandPerHour) {
        return 0;
    }
}
