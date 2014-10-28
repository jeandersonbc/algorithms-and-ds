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

public class QuickSortClassic<T extends Comparable<T>> implements SortingAlg<T> {

    @Override
    public void sort(List<T> elements) {
        if (elements == null)
            return;
        sort(elements, 0, elements.size() - 1); 
    }
    private void sort(List<T> elements, int left, int right) {
        if (left < right) {
            int p = partition(elements, left, right);
            sort(elements, left, p-1);
            sort(elements, p+1, right);
        }
    }
    private int partition(List<T> elements, int left, int right) {
        T pivot = elements.get(right);
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (isLessThan(elements.get(j), pivot)) {
                T greater = elements.get(++i);
                elements.set(i, elements.get(j));
                elements.set(j, greater);
            }
        }
        T temp = elements.get(i + 1);
        elements.set(i + 1, pivot);
        elements.set(right, temp);

        return i + 1;
    }
    private boolean isLessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }

    // Simple driver
    public static void main(String[] args) {
        SortingAlg<Integer> alg = new ClassicQuickSort<Integer>();
        List<Integer> elems = java.util.Arrays.asList(9,5,2,7,3,8,2,1,4,7,5,3,9);
        alg.sort(elems);
        for (int i = 0; i < elems.size() - 1; i++) {
            if (elems.get(i).compareTo(elems.get(i+1)) > 0) {
                throw new java.lang.RuntimeException("Elems should be sorted.");
            }
        }
        System.out.println("All tests passed.");
    }
}

