/**
 * Result String class. Comparable to see which string to store.
 */
public class ResultString implements Comparable<ResultString>{

    static String TAB = "\t";
    String word;
    int x;
    int y;
    String path;


    public ResultString(String word, int x, int y, String path) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.path = path;
    }

    public String toString() {
        return word + TAB + x + TAB + y + TAB + path;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(ResultString o) {
        if(this.x != o.x) return Integer.compare(this.x, o.x);
        return Integer.compare(this.y, o.y);
    }
}
