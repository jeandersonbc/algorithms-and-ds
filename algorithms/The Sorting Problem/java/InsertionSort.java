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
import java.lang.Comparable;
/**
 * The Insertion Sort uses an incremental approach.
 *
 * Characteristics:
 *     Running-time: Quadratic - BigOh(n^2)
 *     This algorithm is input-sensitive. If the input is already sorted (best case),
 *     it runs in linear time. This algorithm is useful and efficient for tiny arrays
 *     and arrays "pre-sorted". The worst case is having an inverted array yielding
 *     quadratic time.
 *
 * Loop invariant:
 *     The index i iterates over all elements, starting from the second value such
 *     that the subarray in the range [0, i-1] is alway sorted.
 *
 * Reference
 *     CLRS 3rd Edition - Section 2.1
 */
public class InsertionSort<T extends Comparable<T>> implements SortingAlg<T> {

    @Override
    public void sort(List<T> elements) {
        if (elements == null) return;

        for (int i = 1; i < elements.size(); i++) {
            T key = elements.get(i);
            int j = i - 1;
            while (j >= 0 && isLessThan(key, elements.get(j))) {
                elements.set(j + 1, elements.get(j));
                j--;
            }
            elements.set(j + 1, key);
        }
    }

    /* Returns true if the first is less than the second.
     * (an easier way to read the compareTo method)
     */
    private boolean isLessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }

    public static void main(String[] args) {
        SortingAlg<Integer> alg = new InsertionSort<Integer>();
        List<Integer> elems = java.util.Arrays.asList(9,5,2,7,3,8,2,1,4,7,5,3,9);
        alg.sort(elems);
        for (int i = 0; i < elems.size() - 1; i++) {
            if (elems.get(i).compareTo(elems.get(i+1)) > 0)
                throw new java.lang.RuntimeException("Elems should be sorted.");
        }
        System.out.println("All tests passed.");
    }
}
