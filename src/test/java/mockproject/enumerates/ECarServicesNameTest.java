package mockproject.enumerates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ECarServicesNameTest {

    @Test
    public void testValues() {
        ECarServicesName[] expectedValues = {
                ECarServicesName.ROUTINE_MAINTENANCE,
                ECarServicesName.REPAIR_SERVICES,
                ECarServicesName.CARE_AND_BEAUTY,
                ECarServicesName.INSPECTION,
                ECarServicesName.POLICIES_WARRANTY
        };

        assertArrayEquals(expectedValues, ECarServicesName.values());
    }

    @Test
    public void testValueOf() {
        assertEquals(ECarServicesName.ROUTINE_MAINTENANCE, ECarServicesName.valueOf("ROUTINE_MAINTENANCE"));
        assertEquals(ECarServicesName.REPAIR_SERVICES, ECarServicesName.valueOf("REPAIR_SERVICES"));
        assertEquals(ECarServicesName.CARE_AND_BEAUTY, ECarServicesName.valueOf("CARE_AND_BEAUTY"));
        assertEquals(ECarServicesName.INSPECTION, ECarServicesName.valueOf("INSPECTION"));
        assertEquals(ECarServicesName.POLICIES_WARRANTY, ECarServicesName.valueOf("POLICIES_WARRANTY"));
    }
}
