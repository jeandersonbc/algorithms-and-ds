import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
/**
 * The SlowCounter solution uses an incremental approach.
 *
 * Characteristics:
 *     Running time: Quadratic BigOh(N^2)
 *     It is an in-place solution based on the Insertion Sort algorithm.
 */
public class SlowCounter<T extends Comparable<T>> implements InversionsCounter<T> {

    @Override
    public int count(List<T> elements) {
        int total = 0;
        if (elements == null)
            return total;
        for (int pos = 1; pos < elements.size(); pos++) {
            T key = elements.get(pos);
            int backwards = pos - 1;
            while (backwards >= 0 && isLessThan(key, elements.get(backwards))) {
                elements.set(backwards + 1, elements.get(backwards--));
                total++;
            }
            elements.set(backwards + 1, key);
        }
        return total;
    }
    private boolean isLessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }
    
    // Simple driver
    public static void main(String[] args) {
        InversionsCounter<Integer> alg = new SlowCounter<Integer>();
        List<Integer> invertedSequence = new ArrayList<Integer>();
        for (int e = 10000; e >= 1; e--) {
            invertedSequence.add(e);
        }
        int result = alg.count(invertedSequence);
        int expectedResult = 49995000;
        if (result != expectedResult) {
            throw new java.lang.RuntimeException(
                String.format("Result should be equals to %d: %d",
                        expectedResult, result)
            );
        }
        System.out.println("All tests passed.");
    }
}
