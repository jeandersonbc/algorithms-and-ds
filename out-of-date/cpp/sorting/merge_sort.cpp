int *buffer; // Auxiliary memory. Remember to allocate enough space here

/* Merge operation
 *
 * Running time: O(n)
 *
 * Due to the first verification, in the best-case (A[lo..mid] <= A[mid+1..hi])
 * the running time is constant O(1). However, this operation requires extra
 * memory O(n).
 */
void merge(int *A, int lo, int mid, int hi) {
	// nothing to be merged
	if (A[mid] <= A[mid+1]) return; 

	// copying to buffer
	for (int k=lo; k <= hi; k++)
		buffer[k] = A[k];
	
	int i = lo;
	int j = mid+1;
	for (int k=lo; k <= hi; k++) {
		// left array exhausted
		if (i > mid)
			A[k] = buffer[j++];

		// right array exhausted
		else if (j > hi)
			A[k] = buffer[i++];

		// normal case
		else if (buffer[i] < buffer[j])
			A[k] = buffer[i++];
		else
			A[k] = buffer[j++];
	}
}

/* Merge Sort
 *
 * Running Time: O(n * log(n))
 * This algorithm is not in-place. The merge operation requires extra memory
 *
 * Merge sort splits the problem in the half, sorts the two sub-problems and
 * merges the result to solve the original array A. This is Divide-and-Conquer
 * approach.
 *
 * The MERGE operation is useful to detect INVERSIONS
 *
 * One improvement to this approach is to use INSERTION SORT for tiny arrays
 * instead of merge them.
 */
void sort(int *A, int lo, int hi) {
	if (lo < hi) {
		int mid = lo + ((hi - lo) >> 1);
		sort(A, lo, mid);
		sort(A, mid+1, hi);
		merge(A, lo, mid, hi);
	}
}
