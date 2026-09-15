package instructor.demo.T08RandomNumbers;

import java.util.Random;

public class Classic {
    public static void main(String[] args) {
        Random rand = new Random();

        int n = rand.nextInt(10);      // 0-9
        int n2 = rand.nextInt(6) + 1;  // 1-6
        double d = rand.nextDouble();  // 0.0 <= d < 1.0
        boolean b = rand.nextBoolean();

        System.out.println("int between 0 and 9: " + n);
        System.out.println("int between 1 and 6: " + n2);
        System.out.println("double between 0 and 1: " + d);
        System.out.println("boolean: " + b);
    }
}
