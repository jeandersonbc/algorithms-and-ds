/* Heap Sort
 *
 * Like INSERTION SORT, it's a in-place sorting algorithm
 * Like MERGE SORT, it's a linear-logarithmic sorting O(n * log(n))
 *
 * Unlike the mentioned algorithms, HEAP SORT uses a DATA STRUCTURE to manage
 * information (the HEAP).
 */

/* The HEAP data structure:
 *     - complete binary tree and elements have to be inserted from left to
 *     right into the last level.
 *
 *     - the root contains the larger (or minimum if it's a min-heap)
 *     - the value of internal node is higher (max-heap or less in the case
 *     of a min-heap) than its children: e.g. A[parent(i)] <= A[i] (min-heap)
 *
 *     - Due to the heap property (above), extract min/max requires O(1) + cost
 *     to maintain the heap property
 *
 *     - Since the heap is a complete binary tree, its height is lg(n). The
 *     implication of this is that any operation in a branch will be O(log(n))
 *
 *     Properties (using arrays):
 *         - For the sake of simplicity, ROOT = A[1]
 *         - A.length    => # of values in the array
 *         - A.heap_size => # of values in the heap (0 <= A.heap_size <= A.length)
 *         - parent(i): A[i >> 1];
 *         - left(i):   A[i << 1];
 *         - right(i):  A[(i << 1) + 1];
 * 
 * Maintaining the HEAP property: HEAPFY. Because it's an operation involving
 * branches, it runs in O(log(n))
 *
 * Building a HEAP: Since we have to iterate over a list of values (A) and just
 * adjust pointers O(1), it's a linear operation
 */
