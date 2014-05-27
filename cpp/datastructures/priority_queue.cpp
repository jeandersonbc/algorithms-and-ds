/* PRIORITY QUEUE
 *
 * Flavors:
 *     MAX-PRIORITY Queue
 *     MIN-PRIORITY Queue
 *
 * Application:
 *     Elements are retrieved by priority instead of the typical QUEUE policy
 *     "first-in first-out" (FIFO). There are many applications in CS.
 *
 * Implementation:
 *     In order to achieve an efficient PRIORITY QUEUE, consider a {min/max}HEAP
 */
const int ROOT = 1;
const int NIL = -1;
int lenght, heap_sz;

inline int parent(int i) { return (i >> 1); }
inline int right(int i) { return (i << 1); }
inline int left(int i) { return (i << 1) + 1; }

void heapfy(int *A, int i) {
	int rgt = right(i);
	int lft = left(i);
	int largest = i;
	if (rgt <= heap_sz && A[rgt] < A[largest]) largest=rgt;
	if (lft <= heap_sz && A[lft] < A[largest]) largest=lft;
	if (largest != i) {
		int tmp = A[i];
		A[i] = A[largest];
		A[largest] = tmp;
		heapfy(A, largest);
	}
}

void build(int *A, int n) {
	lenght = heap_sz = n;
	A[0] = NIL;
	n >>= 1;
	while(n >= ROOT) {
		heapfy(A, n);
		n--;
	}
}

/* PRIORITY QUEUE interface
 *
 *     ..............INSERT(A, x): Inserts element X in the queue A
 *     CHANGE_KEY(A, i, priority): Changes i-th priority to a new priority
 *     ................EXTRACT(A): Extracts the highest priority element
 *     ...........MAX_PRIORITY(A): Returns the max priority element
 */
bool insert(int *A, int x) {
	if (heap_sz == lenght) return false;
	A[++heap_sz] = x;
	int i = heap_sz;
	while (i > ROOT && A[i] > A[parent(i)]) {
		int tmp = A[parent(i)];
		A[parent(i)] = A[i];
		A[i--] = tmp;
	}
	return true;
}

int extract(int *A) {
	if (heap_sz <= 0) return NIL;
	int extracted = A[ROOT];
	A[ROOT] = A[heap_sz--];
	heapfy(A, ROOT);

	return extracted;
}

inline int max_priority(int *A) {
	return ((heap_sz <= 0) ? NIL : A[ROOT]);
}

// TODO
void change_key(int *A, int i, int priority) {

}

// TODO Driver
int main() { return 0; }
