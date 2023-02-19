package mockproject.until;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

  @Component
  public class DateTimeUtils {
    public static Date fromStringToDate(String a){
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      dateFormat.setLenient(false);
      Date date = null;
      try {
        date = dateFormat.parse(a);
      } catch (ParseException pe) {
        System.err.println("Wrong format: " + a);
      }
      return date;
    }

    public Date standardizationDate(Date date)  {
      try{
        return  new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
      } catch (ParseException pe) {
        return null;
      }
    }
    public String fromDateToString(Date date) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String formattedDate = formatter.format(date);
      return formattedDate;
    }

  /*
  public static Date fromStringToDate(String strDate) throws ParseException {
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    try {
      date = sdf.parse(strDate);
    }catch (ParseException e){
      System.out.println("Loi dinh dang ngay thang roi !");
    }

    return date;
  }*/
  }

