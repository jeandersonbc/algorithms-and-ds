import java.util.List;
import java.lang.Comparable;
/**
 * Interface for the problem.
 *
 * @author Jeanderson Candido - http://jeandersonbc.github.io
 */
public interface InversionsCounter<T extends Comparable<T>> {

    /**
     * Returns the number of inversions in elements.
     */
    int count(List<T> elements);

}
