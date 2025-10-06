// Node of the Trie
class TrieNode {
    TrieNode[] children;   // Each index corresponds to a letter 'a' - 'z'
    boolean isEndOfWord;   // Marks the end of a valid word

    public TrieNode() {
        this.children = new TrieNode[26]; // 26 lowercase letters
        this.isEndOfWord = false;
    }
}

// Main Trie class
@SuppressWarnings("unused")
class Trie {
    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode(); // Root is an empty node
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; // Map 'a'->0, 'b'->1, ...
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(); // create new node if missing
            }
            cur = cur.children[index]; // move to next node
        }
        cur.isEndOfWord = true; // Mark end of word
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode cur = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false; // path does not exist
            }
            cur = cur.children[index];
        }
        return cur.isEndOfWord; // true only if it's end of word
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                return false; // path does not exist
            }
            cur = cur.children[index];
        }
        return true; // traversal successful → prefix exists
    }
}

/**
 * Usage:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // true
 * trie.search("app");     // false
 * trie.startsWith("app"); // true
 * trie.insert("app");
 * trie.search("app");     // true
 */
