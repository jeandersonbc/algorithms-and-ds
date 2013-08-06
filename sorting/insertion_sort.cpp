/* Insertion Sort
 *
 * Worst-case runtime: O(n^2)
 * Stable and in-place sorting
 * 
 * It's efficient for tiny arrays and pre-sorted sorted arrays
 * since it only shifts an element when necessary. In another words,
 * the runtime is affected by the input (linear time for sorted
 * arrays. However, it performs a lot of exchanges.
 *
 * It uses an incremental approach in such way that the sub-array
 * A[0..j] is always sorted (loop invariant).
 *
 * This algorithm is useful to detect INVERSIONS (do you know how?)
 */
void sort(int *A, int n) {
	for (int i = 1; i < n; i++) {
		int key = A[i];
		int j = i - 1;
		while (j >= 0 && key < A[j]) {
			A[j+1] = A[j];
			j--;
		}
		A[j + 1] = key;
	}
}
