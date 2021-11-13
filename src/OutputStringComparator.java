import java.util.Comparator;

/**
 * Comparator to sort the output result strings.
 */
public class OutputStringComparator implements Comparator<ResultString> {
    @Override
    public int compare(ResultString o1, ResultString o2) {
        return o1.getWord().compareTo(o2.getWord());
    }
}
