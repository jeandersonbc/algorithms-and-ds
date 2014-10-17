import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class WeightedQuickUnion implements UnionFind {

    private int id[];
    private int sz[];

    public WeightedQuickUnion(int n) {
        if (n <= 0)
            throw new IllegalArgumentException("Value n should be greater than 0");

        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        if (!isConnected(p, q)) {
            if (sz[root(q)] < sz[root(p)]) {
                id[root(q)] = root(p);
                sz[root(p)] += sz[root(q)];
            } else {
                id[root(p)] = root(q);
                sz[root(q)] += sz[root(p)];
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        if (isValid(p) && isValid(q)) {
            return root(p) == root(q);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Roots:\t").append(Arrays.toString(this.id));
        str.append("\n").append("Size:\t");
        str.append(Arrays.toString(this.sz));
        return str.toString();
    }

    private int root(int node) {
        while (id[node] != node) {
            node = id[node];
        }
        return node;
    }

    private boolean isValid(int p) {
        return (p >= 0 && p < id.length);
    }

    /**
     * Demo
     */
    public static void main(String[] args) {
        int n = 10;

        UnionFind uf = new WeightedQuickUnion(n);
        for (int i = 0; i < n; i++) {
            assertConnection(uf, i, i);
        }
        System.out.println(uf);

        int[] pairs = {8, 9, 5, 1, 6, 7, 7, 3, 5, 0, 8, 5, 2, 4, 7, 2, 2, 0};
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
