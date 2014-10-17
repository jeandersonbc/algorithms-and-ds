import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class QuickFind implements UnionFind {

    private int[] id;

    public QuickFind(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Value n should be greater than 0");

        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if (!isConnected(p, q)) {
            int pid = id[p];
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pid)
                    id[i] = id[q];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        if (isValid(q) && isValid(p)) {
            return id[p] == id[q];
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.id); 
    }

    private boolean isValid(int p) {
        return (p >= 0 && p < id.length);
    }

    /**
     * Demo
     */
    public static void main(String[] args) {
        int n = 10;

        UnionFind uf = new QuickFind(n);
        for (int i = 0; i < n; i++) {
            assertConnection(uf, i, i);
        }
        System.out.println(uf);

        int[] pairs = {5, 8, 2, 5, 9, 7, 6, 5, 3, 8, 2, 0};
        for (int i = 1; i < pairs.length; i += 2) {
            uf.union(pairs[i-1], pairs[i]);
            assertConnection(uf, pairs[i-1], pairs[i]);
            System.out.println(uf);
        }
    }

    private static void assertConnection(UnionFind uf, int p, int q) {
        if (!uf.isConnected(p, q) && !uf.isConnected(q, p))
            System.out.println("Fail, points should be connected");
    }
}
