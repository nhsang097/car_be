package mockproject.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataResponseTest {

    @Test
    void constructorWithObject_shouldSetDataAndMessage() {
        String testData = "test data";
        DataResponse dataResponse = new DataResponse(testData);

        assertFalse(dataResponse.isError());
        assertEquals("Success", dataResponse.getMessage());
        assertEquals(testData, dataResponse.getData());
    }

    @Test
    void constructorWithBooleanAndMessage_shouldSetErrorAndMessage() {
        DataResponse dataResponse = new DataResponse(true, "Test error message");

        assertTrue(dataResponse.isError());
        assertEquals("Test error message", dataResponse.getMessage());
        assertNull(dataResponse.getData());
    }

    @Test
    void isError_shouldReturnErrorFlag() {
        DataResponse dataResponse = new DataResponse(true, "Test error message");

        assertTrue(dataResponse.isError());
    }

    @Test
    void setMessage_shouldSetMessage() {
        DataResponse dataResponse = new DataResponse(false, "Test message");
        dataResponse.setMessage("New message");

        assertEquals("New message", dataResponse.getMessage());
    }

    @Test
    void setData_shouldSetData() {
        String testData = "test data";
        DataResponse dataResponse = new DataResponse(false, "Test message");
        dataResponse.setData(testData);

        assertEquals(testData, dataResponse.getData());
    }
}
