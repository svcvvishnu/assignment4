
import java.util.HashMap;
import java.util.Map;

/**
 * Node Class to store the dictionary nodes
 */
public class Node {
    private final Map<Character, Node> children;
    private String content;
    private boolean isWord;

    public Node() {
        this.children = new HashMap<>();
        this.content = "";
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public void setContent(String value) {
        this.content = value;
    }

    public String getContent() {
        return this.content;
    }

    public boolean isWord() {
        return isWord;
    }
}
