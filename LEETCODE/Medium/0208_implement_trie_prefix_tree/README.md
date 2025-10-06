## 208. Implement Trie (Prefix Tree)

### Problem

We need to implement a **Trie (Prefix Tree)** data structure that supports:

1. `insert(word)` → adds a word to the trie.
2. `search(word)` → checks if a word exists in the trie.
3. `startsWith(prefix)` → checks if any word starts with a given prefix.

---

### Example

```
Input:
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]

Output:
[null, null, true, false, true, null, true]

Explanation:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // true
trie.search("app");     // false
trie.startsWith("app"); // true
trie.insert("app");
trie.search("app");     // true
```

---

### Approach 🚀

We use a **TrieNode** class to represent each character:

- Each node has up to **26 children** (one for each lowercase letter).
- Each node has a flag `isEndOfWord` to mark if a complete word ends there.

Operations:

- **Insert(word):** Traverse character by character, creating new nodes if needed.
- **Search(word):** Traverse character by character; return `true` only if the last node is `isEndOfWord`.
- **StartsWith(prefix):** Traverse character by character; return `true` if traversal succeeds (even if not end of word).

---

### Dry Run 📝

Insert `"apple"`:

```
root → a → p → p → l → e*
(* marks end of word)
```

Search `"app"`:

- Traverse `a → p → p` exists.
- But last node is not `isEndOfWord`. → return `false`.

Search `"apple"`:

- Traverse `a → p → p → l → e`.
- Last node is `isEndOfWord = true`. → return `true`.

---

### Complexity

- **Insert:** `O(L)` (L = length of word)
- **Search:** `O(L)`
- **StartsWith:** `O(L)`
- **Space:** `O(26 * N * L)` worst case (N words of avg length L)
