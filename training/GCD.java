import java.util.Scanner;

public class GCD {

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(gcd(Math.max(a, b), Math.min(a, b)));
        }
        in.close();
    }

}
