const int NIL = -1;

// Iterative solution
int binary_search(int *A, int n, int target) {
	int lo = 0;
	int hi = n-1;
	while (lo <= hi) {
		int mid = lo + ((hi - lo) >> 1);
		if (A[mid] == target)
			return mid;
		else if (target < A[mid])
			hi = mid-1;
		else
			lo = mid+1;
	}
	return NIL;
}

// Recursive solution
int binary_search(int *A, int target, int lo, int hi) {
	if (hi < lo) return NIL;

	int mid = lo + ((hi - lo) >> 1);
	if (A[mid] == target)
		return mid;
	else if (target < A[mid])
		return binary_search(A, target, lo, mid-1);
	else
		return binary_search(A, target, mid+1, hi);

}
