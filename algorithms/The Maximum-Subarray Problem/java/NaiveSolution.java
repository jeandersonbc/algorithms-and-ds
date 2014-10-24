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

public class NaiveSolution implements MaxSubArrayFinder {

    private int left;
    private int right;
    private int sum;

    public NaiveSolution(List<Integer> values) { 
        if (values == null)
            throw new java.lang.IllegalArgumentException("Parameter values should not be null");

        solve(values);
    }
    /**
     * This solution tests every single possible subarray A[i..j] for i less than
     * or equals to j. Therefore, it is not difficult to see that we have a solution bounded
     * by N squared. More strictly, it would not be exactly N squared because as i increases,
     * j decreases but it is okay since we are talking about BigOh-notation.
     */
    private void solve(List<Integer> values) {
        this.sum= values.get(0);
        for (int i = 0; i < values.size(); i++) {
            int maxTmp = values.get(i);
            for (int j = i + 1; j < values.size(); j++) {
                maxTmp += values.get(j);
                if (maxTmp > this.sum) {
                    this.sum= maxTmp;
                    this.right = j;
                    this.left = i;
                }
            }
        }
    }
    @Override
    public int getMaxSum() {
        return this.sum;
    }
    @Override
    public int getRight() {
        return this.right;
    }
    @Override
    public int getLeft() {
        return this.left;
    }
    // Sanity check
    public static void main(String[] args) {
        List<Integer> values = java.util.Arrays.asList(
            13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7
        );
        int expectedRight = 10;
        int expectedLeft = 7;
        int expectedSum= 43;

        MaxSubArrayFinder alg = new NaiveSolution(values);
        test(expectedRight, alg.getRight());
        test(expectedSum, alg.getMaxSum());
        test(expectedLeft, alg.getLeft());
    }
    static void test(int expected, int current) {
        if (current != expected) {
            throw new java.lang.RuntimeException(
                String.format("Expected %d but got %d", expected, current)
            );
        }
    }
}
