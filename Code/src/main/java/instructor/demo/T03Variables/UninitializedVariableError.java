package instructor.demo.T03Variables;

public class UninitializedVariableError {

    public static void main(String[] args) {

        int b = 8;
        int a = b + 7;   // works -- b was initialized before use
        System.out.println("a = " + a);

        int c =5;
        // Predict: what happens when the line below is uncommented and run?

        int result = 19 + c;   // c was never initialized
        System.out.println("result = " + result);
    }

}
