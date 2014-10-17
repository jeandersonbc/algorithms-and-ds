import java.util.List;

/**
 * Interface for the Searching problem.
 * @author Jeanderson Candido - http://jeandersonbc.github.io
 */
interface SearchingAlg<T> {

    final int NIL = -1;

    /**
     * Returns the index of the first occurence of target in elements.
     * If elements doesn't contain target, NIL is returned;
     */
    int indexOf(List<T> elements, T target);
}
