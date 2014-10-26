/*
 * Copyright (C) 2013, 2014  Jeanderson Barros Candido
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Contributors:
 *     Jeanderson Candido <http://jeandersonbc.github.io> - Initial Implementation
 */
import java.util.List;

public class LogarithmicSolution implements MaxSubArrayFinder {

    private int sum;

    public LogarithmicSolution(List<Integer> values) { 
        if (values == null)
            throw new java.lang.IllegalArgumentException("Parameter values should not be null");

        this.sum = solve(values, 0, values.size() - 1);
    }
    private int solve(List<Integer> values, int left, int right) {
        if (left == right)
            return values.get(left);

        int mid = (left + right) >> 1;
        int leftSum = solve(values, left, mid);
        int rightSum = solve(values, mid + 1, right);
        int crossingSum = solve(values, left, mid, right);

        if (leftSum > rightSum && leftSum > crossingSum)
            return leftSum;
        if (rightSum > leftSum && rightSum > crossingSum)
            return rightSum;
        return crossingSum;
    }
    private int solve(List<Integer> values, int left, int mid, int right) {
        int total = values.get(mid);
        int partialSum = total;
        for (int i = mid - 1; i >= left; i--) {
            partialSum += values.get(i);
            if (partialSum > total)
                total = partialSum;
        }
        partialSum = total;
        for (int i = mid + 1; i <= right; i++) {
            partialSum += values.get(i);
            if (partialSum > total)
                total = partialSum;
        }
        return total;
    }
    @Override
    public int getMaxSum() {
        return this.sum;
    }
    // To make code simpler, I will not consider the following contracts
    @Override
    public int getRight() {
        throw new java.lang.UnsupportedOperationException("Not implemented");
    }
    @Override
    public int getLeft() {
        throw new java.lang.UnsupportedOperationException("Not implemented");
    }
    // Sanity check
    public static void main(String[] args) {
        List<Integer> values = java.util.Arrays.asList(
            13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
        );
        int expectedSum= 43;

        MaxSubArrayFinder alg = new LogarithmicSolution(values);
        test(expectedSum, alg.getMaxSum());
    }
    static void test(int expected, int current) {
        if (current != expected) {
            throw new java.lang.RuntimeException(
                String.format("Expected %d but got %d", expected, current)
            );
        }
    }
}
