Problems
--------

## The Range Minimum/Maximum Query (RMQ) problem

Given a range [i, j] and M queries, return the maximum (or minimum) element within the given range.
Segment Tree is a useful data structure to solve this problem efficiently. It allows to perform
queries in O(log(n)) time. Therefore, for M queries, the solution is O(M * log(n)).
