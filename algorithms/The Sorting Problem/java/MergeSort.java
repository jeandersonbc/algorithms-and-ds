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
 * The Merge-Sort algorithm uses a Divide And Conquer approach.
 *
 * Characteristics:
 *     Running time: Linear-Logarithmic BigOh(N * log(N))
 *     This algorithm requires extra memory to solve the sorting problem. Although
 *     It is faster than Insertion Sort for large sequences, the overhead of the
 *     Merge Sort for small sequences is much more than required by the Insertion
 *     Sort. A good optimization would be using Insertion Sort when the size of the
 *     sequence is small enough.
 *
 * Recurrence Function:
 *     T(n) = 2 * T(n / 2) + f(n)
 *
 * Reference:
 *     CLRS 3rd Edition - Section 2.3.1
 */
public class MergeSort<T extends Comparable<T>> implements SortingAlg<T> {

    private List<T> buffer;

    // wrapper function
    @Override
    public void sort(List<T> elements) {
        if (elements == null)
            return;

        // Give enough space to avoid having to keep resizing.
        // Remember that by doing this, buffer.size() == 0
        this.buffer = new ArrayList<T>(elements.size());

        sort(elements, 0, elements.size() - 1);
        this.buffer = null;
    }
    private void sort(List<T> elements, int min, int max) {
        if (min == max)
            return;

        int mid = (min + max) >> 1;
        sort(elements, min, mid);
        sort(elements, mid + 1, max);

        merge(elements, min, mid, max);
    }
    private void merge(List<T> elements, int min, int mid, int max) {
        if (lessThanOrEquals(elements.get(mid), elements.get(mid+1)))
            return;

        for (int k = min; k <= max; k++)
            this.buffer.add(k, elements.get(k));

        int left = min;
        int right = mid + 1;
        for (int k = min; k <= max; k++) {
            if (left > mid)
                elements.set(k, this.buffer.get(right++));
            else if (right > max)
                elements.set(k, this.buffer.get(left++));
            else if (lessThan(this.buffer.get(left), this.buffer.get(right)))
                elements.set(k, this.buffer.get(left++));
            else
                elements.set(k, this.buffer.get(right++));
        }
    }
    // Helper functions
    private boolean lessThanOrEquals(T first, T second) {
        return (first.compareTo(second) <= 0);
    }
    private boolean lessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }
    // Simple driver
    public static void main(String[] args) {
        SortingAlg<Integer> alg = new MergeSort<Integer>();
        List<Integer> elems = java.util.Arrays.asList(9,5,2,7,3,8,2,1,4,7,5,3,9);
        alg.sort(elems);
        for (int i = 0; i < elems.size() - 1; i++) {
            if (elems.get(i).compareTo(elems.get(i+1)) > 0)
                throw new java.lang.RuntimeException("Elems should be sorted.");
        }
        System.out.println("All tests passed.");
    }
}
