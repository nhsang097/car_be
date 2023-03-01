package mockproject.enumerates;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EServiceAreaTest {

    @Test
    public void testValueOf() {
        assertEquals(EServiceArea.DA_NANG, EServiceArea.valueOf("DA_NANG"));
        assertEquals(EServiceArea.BINH_DUONG, EServiceArea.valueOf("BINH_DUONG"));
        assertEquals(EServiceArea.HAI_PHONG, EServiceArea.valueOf("HAI_PHONG"));
        assertEquals(EServiceArea.PHU_YEN, EServiceArea.valueOf("PHU_YEN"));
    }

    @Test
    public void testValues() {
        EServiceArea[] values = EServiceArea.values();
        assertEquals(4, values.length);
        assertEquals(EServiceArea.DA_NANG, values[0]);
        assertEquals(EServiceArea.BINH_DUONG, values[1]);
        assertEquals(EServiceArea.HAI_PHONG, values[2]);
        assertEquals(EServiceArea.PHU_YEN, values[3]);
    }
}
