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
 * The Selection Sort algorithm uses an incremental approach.
 *
 * Characteristics:
 *     Running time: Quadratic - BigOh(n^2)
 *     Regardless of the input, it will always be quadratic. However, the Selection
 *     Sort algorithm perform less memory swaps than Insertion Sort.
 *
 * Loop Invariant:
 *     The inner loop will find the index (min) of the minimum i-th value. Therefore,
 *     by the end of each loop, the range [0...i-1] is sorted
 *
 * Reference:
 *     CLRS 3rd Edition - Problem 2.2-2
 */
public class SelectionSort<T extends Comparable<T>> implements SortingAlg<T> {

    @Override
    public void sort(List<T> elements) {
        if (elements == null) return;
        for (int i = 0; i < elements.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < elements.size(); j++) {
                if (isLessThan(elements.get(j), elements.get(min)))
                    min = j;
            }
            T temp = elements.get(i);
            elements.set(i, elements.get(min));
            elements.set(min, temp);
        }
    }
    private boolean isLessThan(T first, T second) {
        return first.compareTo(second) < 0;
    }
    public static void main(String[] args) {
        SortingAlg<Integer> alg = new SelectionSort<Integer>();
        List<Integer> elems = java.util.Arrays.asList(9,5,2,7,3,8,2,1,4,7,5,3,9);
        alg.sort(elems);
        for (int i = 0; i < elems.size() - 1; i++) {
            if (elems.get(i).compareTo(elems.get(i+1)) > 0)
                throw new java.lang.RuntimeException("Elems should be sorted.");
        }
        System.out.println("All tests passed.");
    }

}
