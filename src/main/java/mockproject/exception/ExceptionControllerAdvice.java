package mockproject.exception;

import mockproject.model.DataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @ExceptionHandler(PhoneNumberExistedException.class)
  @ResponseStatus(HttpStatus.FORBIDDEN)
  @ResponseBody
  public DataResponse handlePhoneNumberExistedException(Exception e) {
    return new DataResponse(e.getMessage());
  }

}
