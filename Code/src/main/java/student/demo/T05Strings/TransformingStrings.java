package instructor.demo.T05Strings;

public class TransformingStrings {

    public static void main(String[] args) {

        String operatorEntry = "  pass  ";

        // Every String method below RETURNS a new String. None of them changes
        // the String that called it. The brackets make the spaces visible.
        System.out.println("[" + operatorEntry.toUpperCase() + "]");   // [  PASS  ]
        System.out.println("[" + operatorEntry.trim() + "]");          // [pass]

        // Predict: after those two calls, what does this line print?
        System.out.println("[" + operatorEntry + "]");

        // To keep a result, you have to store it somewhere.
        String cleaned = operatorEntry.trim().toUpperCase();
        System.out.println("[" + cleaned + "]");                       // [PASS]

        // replace(String, String) swaps every match and returns a new String
        String partNumber = "AR-4471-B";
        System.out.println(partNumber.replace("-", ""));               // AR4471B
        System.out.println(partNumber);                                // AR-4471-B, untouched

        // concat(String) is the method form of the + operator. It makes the
        // same point: the String that calls it is never modified.
        String plant = "AR";
        String lot = "4471";
        System.out.println(plant.concat(lot));                         // AR4471
        System.out.println(plant);                                     // AR, still just two characters
    }
}
