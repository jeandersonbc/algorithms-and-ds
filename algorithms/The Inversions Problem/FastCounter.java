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
import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
/**
 * The FastCounter solution uses a Divide and Conquer approach.
 *
 * Characteristics:
 *     Running time: Linear-Logarithmic BigOh(N * log(N))
 *     Requires extra memory (not in-place). It is a modification of the
 *     Merge-Sort algorithm.
 *
 * Recurrence Function:
 *     T(n) = 2T(n / 2) + O(n)
 */
public class FastCounter<T extends Comparable<T>> implements InversionsCounter<T> {

    private List<T> buffer;

    @Override
    public int count(List<T> elements) {
        if (elements == null)
            return 0;

        this.buffer = new ArrayList<T>(elements.size());
        int total = count(elements, 0, elements.size() - 1);
        this.buffer = null;

        return total;
    }
    private int count(List<T> elements, int min, int max) {
        int total = 0;
        if (min == max)
            return total;

        int mid = (min + max) >> 1;
        total += count(elements, min, mid);
        total += count(elements, mid + 1, max);

        if (isLessThanOrEqualsTo(elements.get(mid), elements.get(mid + 1)))
            return total;
        
        for (int k = min; k <= max; k++) {
            this.buffer.add(k, elements.get(k));
        }
        int left = min;
        int right = mid + 1;
        for (int k = min; k <= max; k++) {
            if (left > mid)
                elements.set(k, this.buffer.get(right++));
            else if (right > max)
                elements.set(k, this.buffer.get(left++));
            else if (isLessThanOrEqualsTo(this.buffer.get(left), this.buffer.get(right)))
                elements.set(k, this.buffer.get(left++));
            else {
                total += mid - left + 1;
                elements.set(k, this.buffer.get(right++));
            }
        }
        return total;
    }
    private boolean isLessThanOrEqualsTo(T first, T second) {
        return (first.compareTo(second) <= 0);
    }
    
    // Simple driver
    public static void main(String[] args) {
        InversionsCounter<Integer> alg = new FastCounter<Integer>();
        List<Integer> invertedSequence = new ArrayList<Integer>();
        for (int e = 10000; e >= 1; e--) {
            invertedSequence.add(e);
        }
        int result = alg.count(invertedSequence);
        int expectedResult = 49995000;
        if (result != expectedResult) {
            throw new java.lang.RuntimeException(
                String.format("Result should be equals to %d: %d",
                        expectedResult, result)
            );
        }
        System.out.println("All tests passed.");
    }
}
