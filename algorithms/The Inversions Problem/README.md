The Inversions Problem
======================

How to count the number of inversions in a sequence of values?

Given a sequence `A` of integers, an **inversion** is a pair `(A[i], A[j])`
such that `A[i]` is greater than `A[j]` and `i` is less than `j` for all `i` and
`j` in `A[1...n]`

###Input:###
Sequence of `N` numbers `A = [a1, a2, a3, ..., aN]`

####Output:####
An integer representing the number of inversions in `A`

###Example:###
* `A = [3,2,4]`
* `f(A) = 1`

##Reference:##
* CLRS 3rd Edition - Problem 2-4
