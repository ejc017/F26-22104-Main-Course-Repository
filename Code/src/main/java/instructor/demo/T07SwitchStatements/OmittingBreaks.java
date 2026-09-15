package instructor.demo.T07SwitchStatements;

public class OmittingBreaks {
    public static void main(String[] args)
    {
        int input = 1;
        switch (input)
        {
            case 1:
            case 2:
            case 3:
                System.out.print("The input was between 1 and 3");
                break;

            case 4:
            case 5:
            case 6:
                System.out.print("The input was between 4 and 6");
                break;

            case 7:
            case 8:
            case 9:
                System.out.print("The input was between 7 and 9");
                break;

            default:
                System.out.print("The input did not match any of the cases");
        }
    }
}
