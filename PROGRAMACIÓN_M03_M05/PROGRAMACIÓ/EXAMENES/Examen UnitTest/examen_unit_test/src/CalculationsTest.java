/*
* \u00A9 Copyright 2024 Juan Francisco Sanchez Castelblanque
* Email: ditarex95@alumnes.ilerna.com
* */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;
class CalculationsTest {
    static Calculations calculations;

    @BeforeAll
    static void initCalculations() {
        calculations = new Calculations();
    }

    @Test @Order(2)
    void factorial() {
        assertEquals(1, calculations.factorial(0));
        assertEquals(1, calculations.factorial(1));
        assertEquals(2, calculations.factorial(2));
        assertEquals(6, calculations.factorial(3));
        assertEquals(24, calculations.factorial(4));
        assertEquals(120, calculations.factorial(5));
        assertEquals(-1, calculations.factorial(-1));
    }

    @Test @Order(3)
    void numberOfDigits() {
        assertEquals(1, calculations.numberOfDigits(3));
        assertEquals(2, calculations.numberOfDigits(33));
        assertEquals(3, calculations.numberOfDigits(123));
        assertEquals(4, calculations.numberOfDigits(5555));
        assertEquals(5, calculations.numberOfDigits(12345));
        assertEquals(6, calculations.numberOfDigits(123456));
        assertEquals(7, calculations.numberOfDigits(1234567));
        assertEquals(8, calculations.numberOfDigits(12345678));
        assertEquals(9, calculations.numberOfDigits(123456789));
        assertEquals(10, calculations.numberOfDigits(1234567890));
    }


    @Test @Order(0)
    void power() {
        assertEquals(32, calculations.power(2, 5));
        assertEquals(97.65625, calculations.power(2.5, 5), 0.0001);
        assertEquals(-97.65625, calculations.power(-2.5, 5), 0.0001);
        assertEquals(-3802.0403, calculations.power(-5.2, 5), 0.0001);
        assertEquals(3515.3041, calculations.power(7.7, 4), 0.0001);
    }

    @Test @Order(1)
    void testOccurrencesUsingReflection() throws Exception {
        Method method = Calculations.class.getDeclaredMethod("occurrences", long.class, byte.class);
        method.setAccessible(true);

        byte result1 = (byte) method.invoke(calculations, 1112220000, (byte) 2);
        assertEquals(3, result1);

        byte result2 = (byte) method.invoke(calculations, 1112220000, (byte) 0);
        assertEquals(4, result2);

        byte result3 = (byte) method.invoke(calculations, 1112220000, (byte) 1);
        assertEquals(3, result3);

        byte result4 = (byte) method.invoke(calculations, 123456789, (byte) 0);
        assertEquals(0, result4);

        byte result5 = (byte) method.invoke(calculations, 1, (byte) 1);
        assertEquals(1, result5);
    }

    @Test @Order(4)
    void div() {
        try {
            assertArrayEquals(new double[]{1, 1}, calculations.div(3, 2));
            assertArrayEquals(new double[]{5, 0}, calculations.div(10, 2));
            assertArrayEquals(new double[]{33, 1}, calculations.div(100, 3));
            assertArrayEquals(new double[]{-12, -1}, calculations.div(-25, 2));
            assertThrows(DivideByZeroException.class, () -> calculations.div(10, 0));
        } catch (DivideByZeroException e) {
            assertThrows(DivideByZeroException.class, (Executable) e);
        }
    }

    @Test @Order(5)
    void coverage() throws Exception {
        // Number of Digits
        assertEquals(3, calculations.numberOfDigits(-999));

        // Power
        assertEquals(1, calculations.power(10, 0));
        assertEquals(0.125, calculations.power(2, -3));

        Method method = Calculations.class.getDeclaredMethod("occurrences", long.class, byte.class);
        method.setAccessible(true);

        byte resultNegative = (byte) method.invoke(calculations, -123455, (byte) 5);
        assertEquals(2, resultNegative);

        byte resultZero = (byte) method.invoke(calculations, 0L, (byte) 0);
        assertEquals(0, resultZero);
    }
}

