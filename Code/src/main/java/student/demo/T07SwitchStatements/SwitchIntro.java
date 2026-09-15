package instructor.demo.T07SwitchStatements;

public class SwitchIntro {

    public static void main(String[] args) {

        //This demo uses int values, but switch statements can consider characters as well
        int input =-1;
        switch (input) {
            case 0:
                //Notice how after the case number we have a colon ":" instead of the usual semi-colon ";"
                //Any expression here will be executed if the input matches the case number
                input = 1;
                //This is the first case of the switch statement
                break; //switch terminates

            case 1:
                input = 4 * 36;
                //This is the second case of the switch statement
                break; //switch terminates

            case 25:
                input = input + 1;
                //Notice that the case number can be any number you choose
                break; //switch terminates

            case 4:
                input++;
                //They do not need to be in any specific order, but it is good practice to start from the lowest number
                break; //switch terminates

            case 5:
                input = input / 25;
                break;
            case 112:
                input--;
                break;
            case 58:
                input *= 4;
                break;
            default:
                System.out.println("This is the default statement");
                //This statement will execute if the value of the input does not match any of the other cases
                break;
        }
        System.out.println("Modified input: " + input);
    }
}
