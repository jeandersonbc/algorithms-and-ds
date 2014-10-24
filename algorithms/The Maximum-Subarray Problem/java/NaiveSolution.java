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

    private List<Integer> values;

    public NaiveSolution(List<Integer> values) { 
        if (values == null)
            throw new java.lang.IllegalArgumentException("Parameter values should not be null");

        this.values = values;
    }

    // TODO Finish this

    @Override
    public int getMaxSum() { return 0; }

    @Override
    public int getRight() { return 0; }

    @Override
    public int getLeft() { return 0; }

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
