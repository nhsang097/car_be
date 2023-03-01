package mockproject.mockproject.model;

public class DataResponse {
  private boolean error;
  private String message;
  private Object data;
  public DataResponse(Boolean error, String msg){

  }
  public DataResponse(Object object){
    this.data = object;
    this.message = "Failed";
  }
  public DataResponse(boolean error, String message){
    this.error = error;
    this.message = message;
  }
  public static DataResponse data(Object data){
    return new DataResponse(data);
  }
  public static DataResponse getError(String msg){
    return new DataResponse(true, msg);
  }
  public boolean isError() {
    return error;
  }

  public void setError(boolean error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
