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
import java.lang.Math;

public class FastPower { 

    /** Returns a^b in log(b) time */
    static long fastPow(long a, long b) {
        if (b < 0)
            throw new java.lang.UnsupportedOperationException("B must be greater or equals to zero.");
        if (b == 0)
            return 1;
        if (b == 1)
            return a;

        long c = a * a;
        long result = fastPow(c, b >> 1);
        
        return ((b & 1) == 1) ? result * a : result;
    }
    // Sanity check with Math.pow
    public static void main(String[] args) {

        // for M > 15, we start to miss precision
        // and results diverge
        long M = 15;
        for (long i = 0; i < M; i++) {
            for (long j = 0; j < M; j++) {

                long result = fastPow(i, j);
                long expected = (long) Math.pow(i, j);

                if (result != expected) {
                    throw new java.lang.RuntimeException(
                        String.format("(a:%d, b:%d) Expected: %d\tResult: %d",
                            i, j, expected, result
                        )
                    );
                }
            }
        }
    }
}
