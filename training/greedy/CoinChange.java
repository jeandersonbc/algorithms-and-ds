import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();

        int cnt = 0,
            quantity = 0;

        // Naturally Greedy
        int[] coins = new int[] {10, 5, 1};
        for (int i = 0; i < coins.length; i++) {
            quantity = value / coins[i];
            value -= quantity * coins[i];
            cnt += quantity;
            if (value == 0) {
                break;
            }
        }
        System.out.println(cnt);
        sc.close();
    }

}
