package instructor.demo.T07SwitchStatements;

public class SwitchCharacters {
    public static void main(String[] args)
    {
        char input = 'a';

        switch (input)
        {
            case 'a':
            case 'A':
                System.out.print("Either A or a will make this case execute");
                break;
            //Do not forget the break whenever you need to separate cases

            case 'b':
            case 'B':
                System.out.print("This statement can also be executed by upper or lowercase b");
                break;

            default:
                System.out.print("As usual, default executes if the input does not match any of the cases");
        }
    }

}
