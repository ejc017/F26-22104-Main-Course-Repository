package instructor.demo.T05Strings;

public class CreatingStrings {

    public static void main(String[] args) {

        // A String is an object, not a primitive. Most objects require the new
        // keyword to create -- String is one of the few that does not.
        String partNumberA = new String("AR-4471-B");

        // The shorthand below is what an overwhelming majority of developers use.
        String partNumberB = "AR-4471-B";

        System.out.println(partNumberA);
        System.out.println(partNumberB);

        // Primitives, for comparison. These hold a value and nothing else.
        int lotSize = 250;
        boolean passed = true;

        System.out.println(lotSize);
        System.out.println(passed);

        // Because a String is an object, it comes with built-in capabilities
        // (methods) that you reach with a dot. An int has none to offer.
        System.out.println(partNumberB.length());
    }
}
