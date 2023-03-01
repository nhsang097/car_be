package mockproject.enumerates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ECarNameTest {

    @Test
    void testToString() {
        assertEquals("Toyota", ECarName.Toyota.toString());
        assertEquals("TOYOTA", ECarName.TOYOTA.toString());
        assertEquals("toyota", ECarName.toyota.toString());
    }

    @Test
    void testValues() {
        ECarName[] expectedValues = {ECarName.Toyota, ECarName.TOYOTA, ECarName.toyota};
        assertArrayEquals(expectedValues, ECarName.values());
    }

    @Test
    void testValueOf() {
        assertEquals(ECarName.Toyota, ECarName.valueOf("Toyota"));
        assertEquals(ECarName.TOYOTA, ECarName.valueOf("TOYOTA"));
        assertEquals(ECarName.toyota, ECarName.valueOf("toyota"));
        assertThrows(IllegalArgumentException.class, () -> ECarName.valueOf("ford"));
    }
}
