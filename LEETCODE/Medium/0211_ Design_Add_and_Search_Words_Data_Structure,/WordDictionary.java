// ------------------------------------------
// LeetCode 211: Design Add and Search Words
// ------------------------------------------

// Trie Node representing each character node
class TrieNode {
    TrieNode[] children;  // Array to store references to next characters
    boolean isEndOfWord;  // Marks the end of a complete word

    // Constructor initializes the children array and end flag
    public TrieNode() {
        this.children = new TrieNode[26];  // For lowercase 'a' to 'z'
        this.isEndOfWord = false;
    }
}

// WordDictionary class implementing addWord and search
@SuppressWarnings("unused")
class WordDictionary {
    private final TrieNode root;  // Root node of the Trie

    // Constructor initializes the Trie root
    public WordDictionary() {
        this.root = new TrieNode();
    }

    // -----------------------------
    // Adds a word into the Trie
    // -----------------------------
    public void addWord(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Map 'a'..'z' to 0..25
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(); // Create node if not exists
            }
            cur = cur.children[index]; // Move to next level
        }
        cur.isEndOfWord = true; // Mark end of word
    }

    // -----------------------------
    // Helper method for recursive search
    // -----------------------------
    private boolean searchHelper(TrieNode node, String word, int index) {
        // Base condition: reached end of word
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        // Case 1: Wildcard '.'
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    // Recursively try all possible paths
                    if (searchHelper(node.children[i], word, index + 1)) {
                        return true;
                    }
                }
            }
            return false; // No path matched
        }

        // Case 2: Normal letter
        int charIndex = ch - 'a';
        if (node.children[charIndex] == null) {
            return false; // Path doesn't exist
        }

        return searchHelper(node.children[charIndex], word, index + 1);
    }

    // -----------------------------
    // Searches for a word in the Trie
    // -----------------------------
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
}

/**
 * Example Usage:
 * WordDictionary dict = new WordDictionary();
 * dict.addWord("bad");
 * dict.addWord("dad");
 * dict.addWord("mad");
 * System.out.println(dict.search("pad")); // false
 * System.out.println(dict.search("bad")); // true
 * System.out.println(dict.search(".ad")); // true
 * System.out.println(dict.search("b..")); // true
 */
