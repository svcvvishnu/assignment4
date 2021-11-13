import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Boggle Game.
 */
public class Boggle {

    private Dictionary dict;
    private char[][] grid;
    private List<String> solution;

    /**
     * Constructor.
     */
    public Boggle() {
        this.dict = new Dictionary();
    }

    /**
     * Read set of words that form a dictionary.
     * @param stream Stream of input
     * @return true if all words are read.
     * @throws RuntimeException if the input is not in expected format
     */
    public boolean getDictionary(BufferedReader stream) throws RuntimeException {
        if (stream == null) throw new RuntimeException("Invalid Stream");

        List<String> words = new ArrayList<>();
        String line  = null;
        try {
            line = stream.readLine();
            while (line != null) {
                if(line.equals("")) return true;
                if (line.length()<2) throw new RuntimeException("Word length is less than 2");
                //It is mentioned to assume the input is lower case. So storing the lowercase values of the input
                dict.insert(line.toLowerCase());
                line = stream.readLine();
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }

    /**
     * Get Puzzle Grid
     * @param stream Stream tor ead from
     * @return True if grid created.
     * @throws RuntimeException Exception if there are any failures.
     */
    public boolean getPuzzle(BufferedReader stream) throws RuntimeException {
        if (stream == null) throw new RuntimeException("Invalid Stream");

        List<String> grids = new ArrayList<>();
        String line  = null;
        try {
            line = stream.readLine();
            if (line == null) return true;
            int length = line.length();
            while (line != null) {
                if(line.equals("")) break;
                if (line.length() != length) throw new RuntimeException("Grid is not of equal length");
                //It is mentioned to assume the input is lower case. So storing the lowercase values of the input
                grids.add(line.toLowerCase());
                line = stream.readLine();
            }
        } catch (IOException e) {
            return false;
        }
        grid = new char[grids.size()][grids.get(0).length()];
        int i=0;
        for (String s : grids) {
            grid[i] = s.toCharArray();
            i++;
        }
        return true;
    }

    /**
     * Solve tehe puzzle for given dict and puzzle.
     * @return List of sorted strings.
     */
    public List<String> solve() {
        if (dict.getRoot().getChildren().size() == 0 || grid == null) throw new RuntimeException("Get Dictionary or puzzle before solving");
        Algorithm a = new Algorithm();
        List<ResultString> res =  a.solve(grid, dict.getRoot());

        List<String> output = new ArrayList<>();
        for(ResultString r : res) {
            output.add(r.toString());
        }
        this.solution = output;
        return output;
    }

    /**
     * Return printable String of found words.
     * @return String representation
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        if (solution == null) {
            solve();
        }
        for (int i = 0; i<this.solution.size(); i++) {
            sb.append(this.solution.get(i));
            if (i != this.solution.size() -1) sb.append("\n");
        }
        return sb.toString();
    }
}
