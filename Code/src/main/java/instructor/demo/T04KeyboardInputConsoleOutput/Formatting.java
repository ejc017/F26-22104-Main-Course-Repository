package instructor.demo.T04KeyboardInputConsoleOutput;

public class Formatting {

    public static void main(String[] args) {

        // %s formats a String; %n adds a newline inside a printf format string
        System.out.printf("%s%n%s*%n", "Abraham", "Lincoln");

        // %d formats an int
        int batchSize = 250;
        System.out.printf("Batch size: %d%n", batchSize);

        // %.Xf formats a floating-point value to X decimal places (rounded)
        System.out.printf("%.3f%n", 8.79253);

        //%% prints a literal '%' character
    }
}
