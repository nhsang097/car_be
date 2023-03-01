package mockproject.exception;

import mockproject.exception.ExceptionControllerAdvice;
import mockproject.exception.PhoneNumberExistedException;
import mockproject.model.DataResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static sun.nio.cs.Surrogate.is;

class ExceptionControllerAdviceTest {

    @Mock
    private Exception mockException;

    private ExceptionControllerAdvice exceptionControllerAdvice;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        exceptionControllerAdvice = new ExceptionControllerAdvice();
    }

    @Test
    public void handleException_shouldReturnDataResponseWithErrorMessage() {
        String errorMessage = "Test error message";
        when(mockException.getMessage()).thenReturn(errorMessage);

        DataResponse response = exceptionControllerAdvice.handleException(mockException);

        assertTrue(response.isError());
        assertEquals(errorMessage, response.getMessage());
    }

//    @Test
//    public void handlePhoneNumberExistedException_shouldReturnDataResponseWithErrorMessageAndForbiddenStatus() {
//        String errorMessage = "Test error message";
//        PhoneNumberExistedException mockException = new PhoneNumberExistedException(errorMessage);
//
//        DataResponse response = exceptionControllerAdvice.handlePhoneNumberExistedException(mockException);
//
//        assertTrue(response.isError());
//        assertEquals(false, response.getMessage());
//        assertEquals(HttpStatus.FORBIDDEN.value(), response.getMessage());
//    }


}
