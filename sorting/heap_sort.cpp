#include <cstdio>

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
 *     - the root contains the maximum (or minimum if it's a min-heap)
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
 *         - parent(i):     A[i >> 1];
 *         - left(i):       A[i << 1];
 *         - right(i):      A[(i << 1) + 1];
 * 
 * Maintaining the HEAP property: HEAPFY. Because it's an operation involving
 * branches, it runs in O(log(n))
 *
 * Building a HEAP: Since we have to iterate over a list of values (A) and just
 * adjust pointers O(1), it's a linear operation
 */
int heap_size;
int *values;

inline int parent(int i) { return (i >> 1); }
inline int left(int i) { return (i << 1); }
inline int right(int i) { return (i << 1) + 1; }

/* HEAPFY (max-heap)
 * 
 * Running time: O(log(n))
 *
 * Assumes the children of i obeys the heap property but it's not guaranteed
 * that i is in the right place.
 *
 * "floats" down the improper element. As we saw previously, it's an operation
 * from a node to the root. Worst case is that the node is a leaf, therefore
 * height = log(n).
 */
void heapfy(int *a, int i) {
	int lft = left(i);
	int rght = right(i);
	int largest = i;
	if (lft <= heap_size && a[i] < a[lft])
		largest = lft;
	if (rght <= heap_size && a[largest] < a[rght])
		largest = rght;
	if (largest != i) {
		int tmp = a[i];
		a[i] = a[largest];
		a[largest] = tmp;   // A[largest] has the old A[i] value!
		heapfy(a, largest); // Needs to check if i is in the proper place
	}
}

// Driver based on Figure 6.2 from Cormen. Use as input the file test_heap.txt

void print() {
	for (int i=1; i <= heap_size; i++) printf("%d ", values[i]);
	printf("\n");
}

int main() {
	int n;
	scanf("%d", &n);

	values = new int[n+1];
	heap_size = 0;
	values[0] = -1; // sentinel

	for (int i=1; i <= n; i++) { scanf("%d", (values+i)); heap_size++; };
	print();
	heapfy(values, 2);
	print();

	delete [] values;
	return 0;
}
