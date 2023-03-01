package mockproject.exception;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class CarsNotFoundExceptionTest {

    @Test
    void testConstructor() {
        // Test default constructor
        CarsNotFoundException exception1 = new CarsNotFoundException();
        assertNotNull(exception1);

        // Test constructor with message
        CarsNotFoundException exception2 = new CarsNotFoundException("Test message");
        assertNotNull(exception2);
        assertEquals(null, exception2.getMessage());
    }
    @Test
    void testThrow() {
        // Test throwing the exception with default constructor
        assertThatThrownBy(() -> {
            throw new CarsNotFoundException("Test message");
        }).isInstanceOf(CarsNotFoundException.class);

        // Test throwing the exception with message
        assertThatThrownBy(() -> {
            throw new CarsNotFoundException();
        }).isInstanceOf(CarsNotFoundException.class)
                .hasMessage(null);
    }

    @Test
    public void testCarsNotFoundExceptionConstructor() {
        CarsNotFoundException exception = new CarsNotFoundException();
        assertNull(exception.getMessage());
    }

    @Test
    public void testCarsNotFoundExceptionConstructorWithMessage() {
        String message = null;
        CarsNotFoundException exception = new CarsNotFoundException();
        assertEquals(message, exception.getMessage());
    }
}
