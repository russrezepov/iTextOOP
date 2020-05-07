import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

    public static Date convertDate(String dateString) throws ParseException {
        Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateString);
        System.out.println(date1);
        return date1;
    }
}

