package mockproject.exception;

public class PhoneNumberExistedException extends RuntimeException{
public PhoneNumberExistedException(String phone){
  super("This phone number"+ phone + "has been used" );

}

}
