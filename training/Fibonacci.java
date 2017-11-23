import java.util.Scanner;

public class Fibonacci {

    static final int MAXN = 10_000;
    static int[] memo = new int[MAXN];

    static int fibSlow(int n) {
        return (n <= 1) ? n : (fibSlow(n - 1) + fibSlow(n - 2));
    }

    static int fib(int n) {
        return memo[n];
    }

    public static void main(String[] args) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < MAXN; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        Scanner in = new Scanner(System.in);
        int tc = in.nextInt();
        while (tc-- > 0) {
            int value = in.nextInt();
            System.out.println(String.format("%d %d", fibSlow(value), fib(value)));
        }
        in.close();
    }
}
