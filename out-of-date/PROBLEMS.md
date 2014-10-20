Problems
--------

## The Maximum-Subarray Problem

Given an array A of integers, and the operation sum(A, i, j) which sums all values in the range
A[i..j], find the maximum subarray i.e. an i and j such that sum(A, i, j) is the maximum value.
* Cormen: Divide-and-Conquer algorithms

## The Range Minimum/Maximum Query (RMQ) problem

Given a range [i, j] and M queries, return the maximum (or minimum) element within the given range.
Segment Tree is a useful data structure to solve this problem efficiently. It allows to perform
queries in O(log(n)) time. Therefore, for M queries, the solution is O(M * log(n)).
