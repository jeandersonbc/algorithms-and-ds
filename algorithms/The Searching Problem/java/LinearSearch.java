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
import java.util.Arrays;
/**
 * The LinearSearch algorithm uses an incremental approach.
 *
 * Characteristics:
 *     Running-time: Linear - BigOh(n)
 *     Works on unsorted sequences
 *
 * Loop invariant:
 *     Target will never be in elements[0..i-1]. If the i-th is
 *     the target element, the index i will be returned, breaking
 *     the loop. If the loop terminates, it means that target
 *     doesn't exist in elements.
 *
 * Reference:
 *     CLRS 3rd Edition - Exercise 2.1-3
 */
public class LinearSearch<T> implements SearchingAlg<T> {

    @Override
    public int indexOf(List<T> elements, T target) {
        if (elements != null && target != null) {
            for (int i = 0; i < elements.size(); i++) {
                if (target.equals(elements.get(i)))
                    return i;
            }
        }
        return NIL;
    }

    // sanity check
    public static void main(String[] args) {
        List<Integer> data = java.util.Arrays.asList(9,4,6,2,4,6,1,6,7,-1);
        int[] expectedIndexes = {0,1,2,3,1,2,6,2,8,9};
        SearchingAlg<Integer> alg = new LinearSearch<Integer>();
        for (int i = 0; i < data.size(); i++) {
            int result = alg.indexOf(data, data.get(i));
            if (result == NIL)
                throw new java.lang.RuntimeException("Result shouldn't be NIL");
        }
        System.out.println("All tests passed.");
    }
}
