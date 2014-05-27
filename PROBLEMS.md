Problems
--------

## The Sorting Problem

Permutes elements from *A[0...N]* such that *A[i]* and *A[i+1]* are ordered for
all *(0 <= i < N)*
* Cormen: 1.1


### Inversions

Given a list *A[0..N]* and a **i** and **j** such that *i < j*, an inversion is a *pair(A[i],
A[j])* such that *A[i] > A[j]*.
* Subproblem of the Sorting problem.
* Cormen: Problem 2-4


## The Searching Problem

Given a list of values A and a target T, return the index of T in A or NIL if A
does not contains T
* Cormen: Exercise 2.1.3

## The Range Minimum/Maximum Query (RMQ) probrem

Given a range [i, j] and M queries, return the maximum (or minimum) element within the given range.
Segment Tree is a useful data structure to solve this problem efficiently. It allows to perform
queries in O(log(n)) time. Therefore, for M queries, the solution is O(M * log(n)).

## Dynamic Programming with Bitmask

