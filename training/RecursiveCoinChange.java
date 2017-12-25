import java.util.Arrays;

class Main {

    /* This recursive approach solves the problem corretly
     * but it does not scale for large inputs.
     *
     * Can you guess why? :)
     */
    static int solve(int value, int[] coins, int total) {
        if (value == 0) return total;
        int answer = -1;
        for (int coin : coins) {
            if (coin <= value) {
                int tmp = solve(value - coin, coins, total + 1);
                if (answer == -1 || answer > tmp)
                    answer = tmp;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int value = 25;
        int[] coins = {5, 10, 15};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins, 0));

        value = 40;
        coins = new int[]{5, 10, 25, 50};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins, 0));

        value = 40;
        coins = new int[]{5, 10, 20, 25, 50};
        System.out.println(value + " " + Arrays.toString(coins));
        System.out.println(solve(value, coins, 0));
    }
}
