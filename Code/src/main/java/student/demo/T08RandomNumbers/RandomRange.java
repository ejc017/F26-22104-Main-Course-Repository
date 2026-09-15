package instructor.demo.T08RandomNumbers;

import java.util.Random;

public class RandomRange {
    public static void main(String[] args) {
        Random rand = new Random();

        int min = 30;
        int max = 60;
        int processingTime = min + rand.nextInt(max - min + 1); // 30-60, inclusive

        System.out.println("Processing time (s): " + processingTime);
    }
}
