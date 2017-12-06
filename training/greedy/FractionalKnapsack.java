import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.Comparable;

public class FractionalKnapsack {

    static class Item implements Comparable<Item> {
        int value, weight;
        public Item(int v, int w) {
            this.value = v;
            this.weight = w;
        }
        @Override
        public int compareTo(Item other) {
            return other.value - this.value;
        }
    }
    public static void main(String[] args0) {
        Scanner sc = new Scanner(System.in);

        int numItems = sc.nextInt();
        int remainingWeight = sc.nextInt();

        Queue<Item> items = new PriorityQueue<>();
        while (numItems-- > 0) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            items.add(new Item(v, w));
        }

        float maxProfit = 0f;
        while (!items.isEmpty()) {
            Item curr = items.remove();
            System.out.println(curr.value + " " + curr.weight);
            if (curr.weight > remainingWeight) {
                float fract = (float) remainingWeight / curr.weight;
                maxProfit += fract * curr.value;
                break;
            } else {
                maxProfit += curr.value;
                remainingWeight -= curr.weight;
            }
        }
        System.out.println(String.format("%.4f", maxProfit));
        sc.close();
    }
}
