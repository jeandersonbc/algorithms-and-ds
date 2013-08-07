/* Selection Sort
 *
 * Running time: O(n^2)
 * Stable and in-place sorting
 *
 * Iterates over A[0..n-1] elements looking for the index of the min i-th
 * element and swaps it. No matter how is the input, the inner loop has to be
 * completed every time to find who is the minimum value. In another words, even
 * in the best case (sorted array) the running time would be quadratic.
 *
 * Compared to Insertion Sort, Selection Sort performs less exchanges.
 */
void sort(int *A, int n) {
	for (int i = 0; i < n-1; i++) {
		int min = i;
		for (int j=i+1; j < n; j++) {
			if (A[j] < A[min])
				min = j;
		}
		int tmp = A[i];
		A[i] = A[min];
		A[min] = tmp;
	}
}
