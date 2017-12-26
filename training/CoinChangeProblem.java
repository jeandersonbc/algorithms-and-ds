import java.util.Arrays;

/*
 * Given an arbitrary amount of money and a set of coin denominations,
 * do you know how to compute the minimum number of coins necessary
 * to change the informed amount of money?
 *
 * For instance, given $25 and the coins $1, $5, and $10, you can change
 * $25 with at least 3 coins: 10+10+5
 */
class Main {

    /* This recursive approach solves the problem correctly
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

    /*
     * Is this really faster? If so, can you tell why?
     */
    static int faster(int value, int[] coins) {
        int[] minCoins = new int[value + 1];
        minCoins[0] = 0;
        for (int currentValue = 1; currentValue <= value; currentValue++) {
            minCoins[currentValue] = -1;
            for (int coin : coins) {
                if (coin <= currentValue) {
                    int numCoins = minCoins[currentValue - coin] + 1;
                    if (minCoins[currentValue] == -1
                            || minCoins[currentValue] > numCoins) {
                        minCoins[currentValue] = numCoins;
                    }
                }
            }
        }
        return minCoins[value];
    }

    static void correctness(int testValue, int[] testCoins) {
        System.out.printf("Test Value: %d, Test Coins: %s\n", testValue, Arrays.toString(testCoins));
        int sol1 = solve(testValue, testCoins);
        int sol2 = faster(testValue, testCoins);
        if (sol1 != sol2) {
            System.err.printf("Wrong Answer - Recursive: %d, DP: %d\n", sol1, sol2);
        } else {
            System.out.printf("Correct Answer: %d\n", sol2);
        }
    }

    static void efficiency(int minValue, int maxValue, int[] testCoins) {
        System.out.println("N\tNaive\tDP");
        for (int testValue = minValue; testValue <= maxValue; testValue += 10) {
            long t1 = System.currentTimeMillis();
            solve(testValue, testCoins);
            t1 = System.currentTimeMillis() - t1;

            long t2 = System.currentTimeMillis();
            faster(testValue, testCoins);
            t2 = System.currentTimeMillis() - t2;

            System.out.printf("%d\t%d\t%d\n", testValue, t1, t2);
        }
    }

    // Some tests...
    public static void main(String[] args) {
        correctness(25, new int[]{5, 10, 15});
        correctness(40, new int[]{5, 10, 25, 50});
        correctness(40, new int[]{5, 10, 20, 25, 50});
        correctness(7, new int[]{1, 3, 4, 5});

        System.out.println("----------");
        efficiency(100, 150, new int[]{5, 10, 20, 25, 50});

        System.out.println("----------");
        int sol = faster(10_000_000, new int[]{5, 10, 20, 25, 50});
        System.out.printf("For N = 10^7, Coin Change = %d\n", sol);
    }
}
