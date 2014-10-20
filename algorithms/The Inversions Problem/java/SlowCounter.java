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
 * The SlowCounter solution uses an incremental approach.
 *
 * Characteristics:
 *     Running time: Quadratic BigOh(N^2)
 *     It is an in-place solution based on the Insertion Sort algorithm.
 */
public class SlowCounter<T extends Comparable<T>> implements InversionsCounter<T> {

    @Override
    public int count(List<T> elements) {
        int total = 0;
        if (elements == null)
            return total;
        for (int pos = 1; pos < elements.size(); pos++) {
            T key = elements.get(pos);
            int backwards = pos - 1;
            while (backwards >= 0 && isLessThan(key, elements.get(backwards))) {
                elements.set(backwards + 1, elements.get(backwards--));
                total++;
            }
            elements.set(backwards + 1, key);
        }
        return total;
    }
    private boolean isLessThan(T first, T second) {
        return (first.compareTo(second) < 0);
    }
    
    // Simple driver
    public static void main(String[] args) {
        InversionsCounter<Integer> alg = new SlowCounter<Integer>();
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
