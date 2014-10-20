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
 * The Binary Search algorithm uses a Divide and Conquer approach.
 *
 * Characteristics:
 *     Running time: Logarithmic BigOh(log(n))
 *     It works by looking at the mid point of an ORDERED sequence and discarding the useless half
 *
 * Recurrence Function:
 *     T(n) = T(n / 2) + O(1)
 *
 * Reference:
 *     CLRS 3rd Edition - Problem 2.3-5
 */
public class BinarySearch<T extends Comparable<T>> implements SearchingAlg<T> {

    @Override
    public int indexOf(List<T> elements, T target) {
        if (elements == null || target == null)
            return NIL;
        return indexOf(elements, target, 0, elements.size() - 1);
    }
    private int indexOf(List<T> elements, T target, int min, int max) {
        if (min <= max) {
            int mid = (max + min) >> 1;
            if (elements.get(mid).equals(target))
                return mid;
            if (isLessThan(elements.get(mid), target))
                return indexOf(elements, target, mid + 1, max);
            return indexOf(elements, target, min, mid - 1);
        }
        return NIL;
    }
    private boolean isLessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }
    // sanity check
    public static void main(String[] args) {
        List<Integer> data = new java.util.ArrayList<Integer>();
        for (int i = 0; i < 100; i++)
            data.add(i);
        SearchingAlg<Integer> alg = new BinarySearch<Integer>();
        for (int i = 0; i < data.size(); i++) {
            int result = alg.indexOf(data, i);
            if (result == NIL)
                throw new java.lang.RuntimeException("Result shouldn't be NIL");

            // necessary, otherwise List.remove(int index) will be called
            data.remove(new Integer(i));

            result = alg.indexOf(data, i);
            if (result != NIL)
                throw new java.lang.RuntimeException("Result should be NIL");
        }
        System.out.println("All tests passed.");
    }
}
