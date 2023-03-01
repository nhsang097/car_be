package mockproject.until;

import mockproject.until.DateTimeUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTimeUtilsTest {

    @Test
    public void testFromStringToDate() {
        // Arrange
        String dateString = "2023-02-20";

        // Act
        Date date = DateTimeUtils.fromStringToDate(dateString);

        // Assert
        assertEquals(dateString, DateTimeUtils.fromDateToString(date));
    }
}
