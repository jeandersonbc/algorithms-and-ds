import java.util.Scanner;

public class LCM {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Truth: lcm(a, b) * gcd(a, b) = a * b
        long lcm = ((long)a * b) / gcd(Math.max(a, b), Math.min(a, b));

        System.out.println(lcm);
    }
}
