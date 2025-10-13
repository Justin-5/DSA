### 📘 **README.md**

```markdown
# 212. Word Search II 🧠

**Difficulty:** Hard  
**Topics:** Trie, DFS, Backtracking, Matrix Traversal  
**LeetCode Link:** [212. Word Search II](https://leetcode.com/problems/word-search-ii/)

---

## 🧩 Problem Statement

Given an `m x n` board of characters and a list of strings `words`, return **all words** on the board.

Each word must be constructed from letters of **sequentially adjacent cells** (horizontally or vertically).  
The same letter cell **cannot be used more than once** in a single word.

---

### 🔹 Example 1

**Input:**
```

board = [["o","a","a","n"],
["e","t","a","e"],
["i","h","k","r"],
["i","f","l","v"]]
words = ["oath","pea","eat","rain"]

```

**Output:**
```

["eat","oath"]

```

---

### 🔹 Example 2

**Input:**
```

board = [["a","b"],
["c","d"]],
words = ["abcb"]

```

**Output:**
```

[]

```

---

## 💡 Approach

We use a **Trie + DFS Backtracking** approach.

### 🔸 Step 1: Build a Trie
- Insert all words into a Trie for prefix-based lookup.
- Each Trie node stores:
  - 26 child pointers.
  - `isEndOfWord` flag.
  - `word` reference (when the word ends at that node).

### 🔸 Step 2: DFS Traversal
- For each cell `(i, j)`:
  - Explore using DFS only if the current character exists in Trie children.
  - Mark cells as visited with `'#'` temporarily.
  - When a full word is found, add it to results and mark it as used.

### 🔸 Step 3: Return Results
- Once DFS is completed, return the list of found words.

---

## 🧮 Complexity Analysis

| Complexity | Explanation |
|-------------|-------------|
| ⏱️ **Time** | O(M × N × 4 × L) where M×N = board size, L = max word length |
| 💾 **Space** | O(sum of all word lengths) for Trie + recursion stack |

---

## 🧠 Key Insights
- Trie helps **prune unnecessary searches**.
- Once a word is found, we set `node.word = null` to avoid duplicates.
- DFS explores up/down/left/right directions.

```
