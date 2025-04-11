import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BiggerTest {
    @Test
    public void bigger() {
        int[] array = { 20, 16 , 12, 4, 25 };
        assertEquals(Bigger.bigger(array), 25);

        int[] Array1 = { 110, 5, 22, 33 };
        int[] Array2 = { 22, 5, 33, 110 };
        int[] Array3 = { 33, 110, 22, 5 };
        assertEquals(Bigger.bigger(Array1), 110);
        assertEquals(Bigger.bigger(Array2), 110);
        assertEquals(Bigger.bigger(Array3), 110);

        int[] Array4 = { 115, 5, 6, -1, 115, 10, 0 };
        assertEquals(Bigger.bigger(Array4), 115);

        int[] Array5 = { 12 };
        assertEquals(Bigger.bigger(Array5), 12);

        int[] Array6 = { -24, -16, -17, -22, -56 };
        assertEquals(Bigger.bigger(Array6), -16);

        int[] Array7 = {};
        assertThrows(NullPointerException.class, () -> Bigger.bigger(Array7));
    }
}
