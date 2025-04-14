import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SlotMachineTest {
    private static SlotMachineInicial slots;

    @BeforeAll
    static void initialize()
    {
        slots = new SlotMachineInicial();
    }

    @Test
    void result() {
        assertEquals("TWO FRUITS", SlotMachineInicial.result((byte)1, (byte)2, (byte)1));
        assertEquals("THREE FRUITS", SlotMachineInicial.result((byte)1, (byte)1, (byte)1));
        assertEquals("TWO FRUITS ONE STAR", SlotMachineInicial.result((byte)1, (byte)1, (byte)6));
        assertEquals("TWO STARS", SlotMachineInicial.result((byte)6, (byte)1, (byte)6));
        assertEquals("THREE STARS", SlotMachineInicial.result((byte)6, (byte)6, (byte)6));
        assertEquals("YOU HAVE LOST!!", SlotMachineInicial.result((byte)1, (byte)2, (byte)3));
    }

    @Test
    void prize() {
        float bet = 25;
        assertEquals(25, SlotMachineInicial.prize(bet, "TWO FRUITS"), 0.001);
        assertEquals(75, SlotMachineInicial.prize(bet, "TWO FRUITS ONE STAR"), 0.001);
        assertEquals(100, SlotMachineInicial.prize(bet, "TWO STARS"), 0.001);
        assertEquals(125, SlotMachineInicial.prize(bet, "THREE FRUITS"), 0.001);
        assertEquals(275, SlotMachineInicial.prize(bet, "THREE STARS"), 0.001);
        assertEquals(0, SlotMachineInicial.prize(bet, "YOU HAVE LOST!!"), 0.001);
    }

    @Test
    void figure() {
        assertEquals("STRAWBERRY", SlotMachineInicial.figure((byte)1));
        assertEquals("BANANA", SlotMachineInicial.figure((byte)2));
        assertEquals("APPLE", SlotMachineInicial.figure((byte)3));
        assertEquals("LEMON", SlotMachineInicial.figure((byte)4));
        assertEquals("WATERMELON", SlotMachineInicial.figure((byte)5));
        assertEquals("STAR", SlotMachineInicial.figure((byte)6));
        assertEquals("ERROR", SlotMachineInicial.figure((byte)7)); // Comprovació de l'error
        assertEquals("ERROR", SlotMachineInicial.figure((byte)0));
    }

    @Test
    void randomFruit() {
        int numTries = 10000;
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;

        for (int i = 0; i < numTries; i++)
        {
            int numFruit = SlotMachineInicial.randomFruit();

            switch (numFruit)
            {
                case 1: count1++; break;
                case 2: count2++; break;
                case 3: count3++; break;
                case 4: count4++; break;
                case 5: count5++; break;
                case 6: count6++; break;
            }
        }
        double totalProb = ((double)count1 / numTries) + ((double)count2 / numTries) + ((double)count3 / numTries) + ((double)count4 / numTries) + ((double)count5 / numTries) + ((double)count6 / numTries);

        assertEquals(1.0, totalProb, 0.0001);
    }

    @Test
    void isTwoFruits() {
        assertTrue(SlotMachineInicial.isTwoFruits((byte)1, (byte)1, (byte)2));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)2, (byte)2, (byte)1));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)3, (byte)3, (byte)4));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)4, (byte)4, (byte)1));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)5, (byte)5, (byte)1));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)1, (byte)2, (byte)2));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)1, (byte)3, (byte)3));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)3, (byte)4, (byte)4));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)4, (byte)5, (byte)5));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)1, (byte)4, (byte)1));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)2, (byte)3, (byte)2));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)3, (byte)1, (byte)3));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)3, (byte)1, (byte)3));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)4, (byte)2, (byte)4));
        assertTrue(SlotMachineInicial.isTwoFruits((byte)5, (byte)3, (byte)5));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)6, (byte)6, (byte)2));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)6, (byte)4, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)6, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)1, (byte)2, (byte)3));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)1, (byte)1, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)1, (byte)6, (byte)1));
        assertFalse(SlotMachineInicial.isTwoFruits((byte)6, (byte)1, (byte)1));
    }

    @Test
    void isTwoFruitsOneStar() {
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)1, (byte)1, (byte)6));
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)2, (byte)6, (byte)2));
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)6, (byte)3, (byte)3));
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)3, (byte)3, (byte)6));
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)4, (byte)6, (byte)4));
        assertTrue(SlotMachineInicial.isTwoFruitsOneStar((byte)5, (byte)6, (byte)5));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)6, (byte)6, (byte)2));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)3, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)6, (byte)2, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)6, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)1, (byte)2, (byte)3));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)5, (byte)6, (byte)2));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)6, (byte)1, (byte)2));
        assertFalse(SlotMachineInicial.isTwoFruitsOneStar((byte)5, (byte)4, (byte)6));
    }

    @Test
    void isThreeFruits() {
        assertTrue(SlotMachineInicial.isThreeFruits((byte)1, (byte)1, (byte)1));
        assertTrue(SlotMachineInicial.isThreeFruits((byte)2, (byte)2, (byte)2));
        assertTrue(SlotMachineInicial.isThreeFruits((byte)3, (byte)3, (byte)3));
        assertTrue(SlotMachineInicial.isThreeFruits((byte)4, (byte)4, (byte)4));
        assertTrue(SlotMachineInicial.isThreeFruits((byte)5, (byte)5, (byte)5));
        assertTrue(SlotMachineInicial.isThreeFruits((byte)5, (byte)5, (byte)5));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)1, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)6, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)3, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)6, (byte)4, (byte)6));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)6, (byte)4, (byte)2));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)1, (byte)3, (byte)2));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)1, (byte)1, (byte)2));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)1, (byte)3, (byte)1));
        assertFalse(SlotMachineInicial.isThreeFruits((byte)1, (byte)3, (byte)3));
    }

    @Test
    void isTwoStars() {
        assertTrue(SlotMachineInicial.isTwoStars((byte)6, (byte)6, (byte)1));
        assertTrue(SlotMachineInicial.isTwoStars((byte)2, (byte)6, (byte)6));
        assertTrue(SlotMachineInicial.isTwoStars((byte)6, (byte)6, (byte)3));
        assertTrue(SlotMachineInicial.isTwoStars((byte)6, (byte)4, (byte)6));
        assertTrue(SlotMachineInicial.isTwoStars((byte)5, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isTwoStars((byte)6, (byte)1, (byte)2));
        assertFalse(SlotMachineInicial.isTwoStars((byte)3, (byte)6, (byte)5));
        assertFalse(SlotMachineInicial.isTwoStars((byte)1, (byte)4, (byte)6));
        assertFalse(SlotMachineInicial.isTwoStars((byte)6, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isTwoStars((byte)1, (byte)3, (byte)2));
    }

    @Test
    void isThreeStars() {
        assertTrue(SlotMachineInicial.isThreeStars((byte)6, (byte)6, (byte)6));
        assertFalse(SlotMachineInicial.isThreeStars((byte)1, (byte)1, (byte)1));
        assertFalse(SlotMachineInicial.isThreeStars((byte)3, (byte)3, (byte)3));
        assertFalse(SlotMachineInicial.isThreeStars((byte)6, (byte)4, (byte)4));
        assertFalse(SlotMachineInicial.isThreeStars((byte)4, (byte)6, (byte)4));
        assertFalse(SlotMachineInicial.isThreeStars((byte)4, (byte)4, (byte)6));
        assertFalse(SlotMachineInicial.isThreeStars((byte)6, (byte)2, (byte)6));
        assertFalse(SlotMachineInicial.isThreeStars((byte)6, (byte)6, (byte)2));
        assertFalse(SlotMachineInicial.isThreeStars((byte)2, (byte)6, (byte)6));
    }
}
