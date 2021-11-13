import java.util.*;

public class Algorithm {
    //String separator to construct the key.
    private static final String SEPARATOR = ":";

    /**
     * Solve the game with given dictionary and grid
     * @param grid The character of the m*n grid.
     * @param root root node of the dictionary.
     * @return List of strings found in the grid with the path to travel
     */
    public List<ResultString> solve(char[][] grid, Node root) {
        Map<String, ResultString> words = new HashMap<>();
        for (int i=0; i< grid.length; i++) {
            for (int j = 0; j<grid[0].length; j++) {
                recursive(i, j, grid, root, new HashSet<>(), words, grid.length - i, j + 1, "");
            }
        }
        List<ResultString> result = new ArrayList<>(words.values());
        result.sort(new OutputStringComparator());

        return result;
    }

    private void recursive(int i, int j, char[][] grid, Node root, Set<String> isVisited, Map<String, ResultString> words, int startX, int startY, String path) {
        if (i<0 ||j<0 || i >= grid.length || j>= grid[0].length) return;
        if (isVisited.contains(i + SEPARATOR + j) || !root.getChildren().containsKey(grid[i][j])) return;
        if (root.getChildren().get(grid[i][j]).isWord()) {
            ResultString r = new ResultString(root.getChildren().get(grid[i][j]).getContent(), startY, startX,path);
            ResultString comp = words.getOrDefault(root.getChildren().get(grid[i][j]).getContent(), r);

            words.put(root.getChildren().get(grid[i][j]).getContent(), comp.compareTo(r)>0? r: comp);
        }
        isVisited.add(i + SEPARATOR + j);
        recursive(i + 1, j, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"D");
        recursive(i - 1, j, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"U");
        recursive(i, j + 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"R");
        recursive(i, j - 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"L");
        recursive(i + 1, j + 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"S");
        recursive(i + 1, j - 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"W");
        recursive(i - 1, j + 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"E");
        recursive(i - 1, j - 1, grid, root.getChildren().get(grid[i][j]), isVisited, words, startX, startY, path+"N");
        isVisited.remove(i + SEPARATOR + j);
    }
}
