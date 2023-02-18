package mockproject.exception;

import mockproject.model.DataResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(Exception.class)
    public DataResponse handleException (Exception e){
      DataResponse dataResponse = new DataResponse(true);
      dataResponse.setError(true);
      dataResponse.setMessage(e.getMessage());
      return dataResponse;

    }

}
