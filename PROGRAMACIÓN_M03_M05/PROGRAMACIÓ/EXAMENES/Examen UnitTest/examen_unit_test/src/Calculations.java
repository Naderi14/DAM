/*
 * Calculations.java 23 Apr 2024
 *
 *
 * \u00A9 Copyright 2024 Juan Francisco Sanchez Castelblanque
 * Email: ditarex95@alumnes.ilerna.com
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */

public class Calculations {
    public double factorial(int n) {
        if (n < 0) return -1;
        double fac = 1;
        for (int i = 1; i <= n; i++) {
            fac = fac * i;
        }
        return fac;
    }

    /**
     * Returns the number of digits in a given integer.
     *
     * @param num integer whose digit count is determined. If negative, its absolute value is used.
     * @return number of digits in the given integer
     */
    public int numberOfDigits(int num) {
        if (num < 0) num = Math.abs(num);
        int length = 0;
        long temp = 1;
        while (temp <= num) {
            length++;
            temp *= 10;
        }
        return length;
    }

    /**
     * Counts how many times a specific digit appears in a given number.
     *
     * @param number the number in which the digit will be searched. If negative, its absolute value is taken.
     * @param digit  the digit to be counted within the number
     * @return the number of occurrences of the digit in the number
     */
    private byte occurrences(long number, byte digit) {
        if (number < 0) number = Math.abs(number);
        byte count = 0;

        while (number > 0){
            if (number % 10 == digit )  ++count;
            number = number / 10;
        }
        return count;
    }

    public double power(double base, int exponent) {
        double p = 1;
        int i = 1;
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            while (i <= exponent) {
                p = p * base;
                i++;
            }
            return p;
        } else {
            while (i <= -exponent) {
                p = p * base;
                i++;
            }
            return 1/p;
        }
    }

    /**
     * Returns the quotient and remainder of the division between two integers.
     *
     * @param x dividend
     * @param y divisor, must not be zero
     * @return array where the first element is the quotient and the second element is the remainder
     * @throws DivideByZeroException if the divisor is zero
     */
    public double[] div(int x, int y) throws DivideByZeroException {
        if (y == 0) throw new DivideByZeroException("Divide by zero!");
        double[] res = new double[] { x/ y, x % y};
        return res;
    }
}
