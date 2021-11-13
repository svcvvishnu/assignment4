/**
 * Dictionary to store all the words.
 */
public class Dictionary {
    //Root noe of the Dictionary
    private final Node root;

    /**
     * Constructor.
     */
    public Dictionary() {
        this.root = new Node();
    }

    /**
     * Insert a new word to the dictionary
     * @param word New word
     */
    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, a -> new Node());
        }
        current.setContent(word);
        current.setIsWord(true);
    }

    /**
     * Find a new word in the Disctionary.
     * @param word Word to search.
     * @return true if found.
     */
    public boolean find(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord();

    }

    /**
     * Get the root node of the Dictionary.
     * @return Root NOde
     */
    public Node getRoot() {
        return this.root;
    }
}
