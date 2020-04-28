import java.util.Comparator;

public class GenderSorter implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) {
        return u2.getGender().compareToIgnoreCase(u1.getGender());
    }
}