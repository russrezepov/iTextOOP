import java.util.Comparator;

public class NameSorter implements Comparator<User>
{
    @Override
    public int compare(User u1, User u2) {
        return u2.getLastName().compareToIgnoreCase(u1.getLastName());
    }
}