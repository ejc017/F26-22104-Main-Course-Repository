package instructor.demo.T07SwitchStatements;

public class SwitchStrings {
    public static void main(String[] args) {
        int i;
        for (i = 1; i < 4 ; i++) {
            String station = "WS" + i;
            int cycleTime = 0;

            //switch code here
            switch (station) {
                case "WS1":
                    cycleTime = 42;
                    break;
                case "WS2":
                    cycleTime = 58;
                    break;
                case "WS3":
                    cycleTime = 35;
                    break;
                default:
                    System.out.println("Station not Found");
            }
            System.out.println("Cycle time (s): " + cycleTime);
        }
    }
}

