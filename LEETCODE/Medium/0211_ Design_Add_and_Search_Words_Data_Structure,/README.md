### 🧠 Problem Summary

You need to design a data structure that:

- Supports adding new words.
- Allows searching words that may contain `.` characters (where `.` can match any single letter).

---

### ⚙️ Operations

| Method                 | Description                                                                |
| ---------------------- | -------------------------------------------------------------------------- |
| `addWord(String word)` | Adds a new word into the data structure.                                   |
| `search(String word)`  | Returns `true` if the word (with or without dots) exists in the structure. |

---

### 💡 Approach

This problem is a variation of the **Trie (Prefix Tree)** data structure.
We enhance the Trie to handle the wildcard character `'.'`.

#### **1️⃣ Add Word**

- Traverse through each character of the word.
- Create new Trie nodes when necessary.
- Mark the end node with `isEndOfWord = true`.

#### **2️⃣ Search Word**

- Traverse the Trie recursively:

  - If the current character is a **letter**, go to the respective child.
  - If the current character is a **dot '.'**, recursively explore **all possible children**.

- Return true if a valid path ends with a `true` `isEndOfWord`.

---

### 🧩 Example

**Input**

```text
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
```

**Output**

```text
[null,null,null,null,false,true,true,true]
```

**Explanation**

```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") → false
search("bad") → true
search(".ad") → true (matches bad/dad/mad)
search("b..") → true (matches bad)
```

---

### 🧮 Complexity Analysis

| Operation   | Time Complexity                               | Space Complexity               |
| ----------- | --------------------------------------------- | ------------------------------ |
| `addWord()` | O(L) — L = word length                        | O(L × N) — N = number of words |
| `search()`  | O(26^d × L) worst case (when '.' is frequent) | O(L) recursion stack           |

---

### 🧠 Key Idea

- This approach effectively blends **Trie traversal** and **backtracking recursion**.
- The wildcard `'.'` makes us explore **multiple paths**, but only to limited depth (max word length = 25).
