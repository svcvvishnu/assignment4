import java.util.Comparator;

public class OutputStringComparator implements Comparator<ResultString> {
    @Override
    public int compare(ResultString o1, ResultString o2) {
        return o1.getWord().compareTo(o2.getWord());
    }
}
