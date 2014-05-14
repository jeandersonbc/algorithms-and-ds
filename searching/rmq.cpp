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
 *
 * Therefore, the interface for this problem would be something like "int rmq(int *values, int i, int j)"
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
 */

