import java.util.Comparator;
import java.util.Date;

public class DateSorter implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) {
        return u2.getRealDate().compareTo(u1.getRealDate());
    }
}