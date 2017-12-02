import java.util.*;

public class FibModulus {

    private static long getFibonacciHuge(long n, int m) {
        int[] fib = new int[10_000_000];
        fib[0] = 0;
        fib[1] = 1;

        int size = 2;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % m;
            size++;
            if (fib[i] == 1 && fib[i - 1] == 0) {
                size -= 2;
                break;
            }
        }
        return fib[(int)(n % size)] % m;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHuge(n, m));
    }
}

