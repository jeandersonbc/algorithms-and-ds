/* Linear Search
 *
 * Running time: O(n)
 *
 * The worst-case is when TARGET is the last element. The best-case is when the
 * TARGET is the first element (Constant running time)
 *
 * Algorithm works for unsorted arrays (order of elements doesn't matter)
 *
 * Linear search iterates over the A comparing the i-th element with the TARGET.
 * If TARGET exists in A, the iteration will be stopped returning the index i.
 * Otherwise, if the loop terminates, it means that TARGET doesn't exists in A,
 * therefore, NIL is returned
 */
const int NIL = -1;

int search(int *A, int n, int target) {
	for (int i=0; i < n; i++) {
		if (A[i] == target)
			return i;
	}
	return NIL;
}
