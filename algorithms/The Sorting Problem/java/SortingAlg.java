import java.lang.Comparable;
import java.util.List;
/**
 * Interface for the Sorting problem. It is convenient to use the Comparable interface.
 * @author Jeanderson Candido - http://jeandersonbc.github.io
 * @param T - Type of the objects to be sorted
 */
public interface SortingAlg<T extends Comparable<T>> {
    /**
     * Reorders the given sequence of elements in ascending sorted order.
     */
    void sort(List<T> elements);
}
