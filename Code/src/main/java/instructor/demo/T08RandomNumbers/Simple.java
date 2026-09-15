package instructor.demo.T08RandomNumbers;

public class Simple {
    public static void main(String[] args) {

        double n = Math.random(); // 0.0 <= n < 1.0
        int i = (int) (Math.random() * 10); // 0-9

        System.out.println(n);
        System.out.println(i);
    }
}
