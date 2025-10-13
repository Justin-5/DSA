
import java.util.ArrayList;
import java.util.List;

// 212. Word Search II
// Approach: Trie + DFS Backtracking

class TrieNode {
    TrieNode[] children;
    @SuppressWarnings("unused")
    boolean isEndOfWord;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
        word = null;
    }
}

@SuppressWarnings("unused")
class Solution {
    private final TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Step 1: Insert word into Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
        node.word = word;
    }

    // Step 2: DFS Backtracking
    private void dfs(char[][] board, int r, int c, TrieNode parent, List<String> res) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || parent.children[ch - 'a'] == null) return;

        TrieNode node = parent.children[ch - 'a'];
        if (node.word != null) {
            res.add(node.word);
            node.word = null; // Avoid duplicates
        }

        board[r][c] = '#'; // Mark visited
        dfs(board, r + 1, c, node, res);
        dfs(board, r - 1, c, node, res);
        dfs(board, r, c + 1, node, res);
        dfs(board, r, c - 1, node, res);
        board[r][c] = ch; // Backtrack
    }

    // Step 3: Main Function
    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) insert(w);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
}
