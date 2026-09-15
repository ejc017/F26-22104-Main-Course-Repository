package instructor.demo.T08RandomNumbers;

import java.util.Random;

public class RandomExercise {
    public static void main(String[] args) {
        Random rand = new Random();

        //TODO: use rand.nextInt(...) to pick a station number from 1 to 3,
        //then use a switch statement to set selectedStation to "WS1", "WS2" or "WS3"
        int stationNumber = 0;
        String selectedStation = "";

        System.out.println("Station number: " + stationNumber);
        System.out.println("Part routed to: " + selectedStation);
    }
}
