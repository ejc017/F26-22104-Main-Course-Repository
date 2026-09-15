package instructor.demo.T03Variables;

public class IntroToVariables {

    public static void main(String[] args) {

        /*
        int (primitive)
        32-bit signed integer
        min: -2,147,483,648 (-2^31)
        max: 2,147,483,647 (2^31 - 1)
        Good for counts: batch size, defect count, etc.
        */
        int batchSize = 250;

        /*
        float (primitive)
        32-bit, single-precision floating point
        Decimal literals default to double, so a float literal needs an 'f' suffix
        Rarely the first choice in this course -- used mainly to save memory in large arrays
        */
        float sensorTolerance = 0.36f;

        /*
        double (primitive)
        64-bit, double-precision floating point
        The default, preferred type for decimal values in this course (measurements, cycle time, cost)
        */
        double cycleTimeSeconds = 12.4;

        /*
        boolean (primitive)
        Only two possible values: true and false (lowercase, no quotes)
        Unlike some languages, Java does NOT accept 1/0 or True/False as booleans
        Local variables (like this one) have NO default value -- they must be initialized
        before use, or the code will not compile
        */
        boolean passedInspection = true;

        /*
        char (primitive)
        A single 16-bit Unicode character, written with single quotes
        */
        char gradeLevel = 'A';

        /*
        String (non-primitive)
        Implemented as a class in Java, so a String is technically an object
        (more on objects later) -- effectively, a collection of characters,
        written with double quotes
        */
        String operatorId = "OP-1042";

        /*
        final (constant)
        A value that cannot change after it is initialized
        Convention: ALL_CAPS_WITH_UNDERSCORES
        */
        final double SCRAP_THRESHOLD = 0.05;

        // Declaring/initializing a variable doesn't show you anything -- printing it does
        System.out.println("Batch size: " + batchSize);
        System.out.println("Sensor tolerance: " + sensorTolerance);
        System.out.println("Cycle time (s): " + cycleTimeSeconds);
        System.out.println("Passed inspection: " + passedInspection);
        System.out.println("Grade level: " + gradeLevel);
        System.out.println("Operator ID: " + operatorId);
        System.out.println("Scrap threshold: " + SCRAP_THRESHOLD);
    }

}
