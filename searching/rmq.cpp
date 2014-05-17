/**
 * Range Minimum Query (RMQ)
 *
 * In this set of problems, we have a SEQUENCE OF VALUES and we want to know
 * what is the MINIMUM element given the lower and upper indexes:
 *
 * PARAMETERS:
 *     vector of values
 *     lower and upper indexes (range)
 *
 * OUTPUT:
 *     MINIMUM VALUE of the given range (other versions may consider the index of the minimum value)
 */ 

/**
 * Naive approach: O(n)
 *
 * Let's assume minimum as the i-th value. Then, we perform a linear search through the j-th element
 * checking if it's lower than the current minimum element.
 */
int rmq(int *values, int i, int j) {
    int lower = values[i];
    for (int k = i + 1; k <= j; k++) {
        if (values[k] < lower)
            lower = values[k];
    }
    return lower;
}

/**
 * What's the problem? Imagine that we will be performing M queries. If a single query takes
 * O(n) then we will have the asymptotic complexity of O(Mn) to solve our problem...
 *
 * ...CAN WE DO BETTER?!
 *
 * Intuitively, we could think about optimizing our linear search to a logarithmic complexity
 * to have O(Mlog(n)) but HOW?
 *
 * What if we had a preprocessed tree to store the minimum element of two children? Then our
 * query would be proportional to the height of this tree (log(n)). It seems to be a promising
 * approach. Let's go deep further on this:
 *
 * Assuming the following values:
 *     A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
 *
 * Building the auxiliary tree, we would have:
 *
 *     T = {min(A[0..N-1]), min(A[0..(N-1)/2]), min(A[(N-1)/2..N]), ... min(A[0]), .. min(A[N-1])}
 *
 * Have you seen this structure before? Seems like we could use a heap-like structure for our
 * auxiliary heap, right? Now, remember that for N leaves, we will require N*2 to represent each node in
 * an array. Asymptoticly speaking, we are "sacrificing" memory to speed up our lookup. As mentioned
 * before, 2 * N is all we need ( O(n) extra memory).
 */

/*
 * Because we are using a heap-like structure, we need to define the left and right children for the i-th
 * node. The following methods return indexes corresponding to an element.
 * For the sake of simplicity, let's assume 0 as the root our auxiliary tree. Also, A is the vector of 
 * values and T is the pre-processed tree. Finally, we have the following:
 */
inline int right(int i) {
    return (i + 1) << 1;
}
inline int left(int i) {
    return (i << 1) + 1;
}

/*
 * Now, we need a sub-routine to build our auxiliary tree. Inspired by the Divide and Conquer approach
 * we come up with the following build routine O(log(n)):
 */
void build(int n, int i, int j) {
    if (i == j) T[n] = A[i];
    else {
        int mid = (i + j)/2;
        build(left(n), i, mid);
        build(right(n), mid+1, j);
        T[n] = min(T[left(n)], T[right(n)]);
    }
}

/*
 * Nice! We know how to build our pre-processed tree to speed up our lookup procedure but how are we going
 * to use it for queries?
 */
int query(int n, int i, int j, int a, int b) {
    if (j < a || i > b) return INF;
    if (a == b) return A[a];
    if (i >= a && j <= b) return T[n];

    int mid = (i + j) / 2;
    int q1 = query(left(n), i, mid, a, b);
    int q2 = query(right(n), mid+1, j, a, b);

    return min(q1, q2);
}
