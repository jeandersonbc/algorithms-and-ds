import java.util.List;
import java.util.Arrays;
/**
 * The LinearSearch algorithm uses an incremental approach.
 *
 * Characteristics:
 *     Running-time: Linear - BigOh(n)
 *     Works on unsorted sequences
 *
 * Loop invariant:
 *     Target will never be in elements[0..i-1]. If the i-th is
 *     the target element, the index i will be returned, breaking
 *     the loop. If the loop terminates, it means that target
 *     doesn't exist in elements.
 *
 * Reference:
 *     CLRS 3rd Edition - Exercise 2.1-3
 */
public class LinearSearch<T> implements SearchingAlg<T> {

    @Override
    public int indexOf(List<T> elements, T target) {
        if (elements != null && target != null) {
            for (int i = 0; i < elements.size(); i++) {
                if (target.equals(elements.get(i)))
                    return i;
            }
        }
        return NIL;
    }

    // sanity check
    public static void main(String[] args) {
        List<Integer> data = java.util.Arrays.asList(9,4,6,2,4,6,1,6,7,-1);
        int[] expectedIndexes = {0,1,2,3,1,2,6,2,8,9};
        SearchingAlg<Integer> alg = new LinearSearch<Integer>();
        for (int i = 0; i < data.size(); i++) {
            int result = alg.indexOf(data, data.get(i));
            if (result == NIL)
                throw new java.lang.RuntimeException("Result shouldn't be NIL");
        }
        System.out.println("All tests passed.");
    }
}
