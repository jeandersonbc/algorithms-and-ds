import java.util.Arrays;

class Main {

    /* This recursive approach solves the problem corretly
     * but it does not scale for large inputs.
     *
     * Can you guess why? :)
     */
    static int solve(int value, int[] coins) {
        if (value == 0) return 0;
        int minCoins = -1;
        for (int coin : coins) {
            if (coin <= value) {
                int numCoins = solve(value - coin, coins);
                if (minCoins == -1 || minCoins > numCoins + 1)
                    minCoins = numCoins + 1;
            }
        }
        return minCoins;
    }
    public static void main(String[] args) {
        int value = 25;
        int[] coins = {5, 10, 15};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins));

        value = 40;
        coins = new int[]{5, 10, 25, 50};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins));

        value = 40;
        coins = new int[]{5, 10, 20, 25, 50};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins));
    }
}
