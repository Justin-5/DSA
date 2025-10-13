# 2273. Find Resultant Array After Removing Anagrams 🔤

**Difficulty:** Easy  
**Topics:** Strings, Sorting, Hashing  
**LeetCode Link:** [2273. Find Resultant Array After Removing Anagrams](https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/)

---

## 🧩 Problem Statement

You are given a string array `words`, where each word contains lowercase English letters.

Perform operations where if **two adjacent words are anagrams**, you remove the latter one.  
Continue until no adjacent words are anagrams.

Return the final `words` array.

---

### 🔹 Example 1

**Input:**

```

words = ["abba","baba","bbaa","cd","cd"]

```

**Output:**

```

["abba","cd"]

```

**Explanation:**

- "bbaa" and "baba" → remove "bbaa"
- "abba" and "baba" → remove "baba"
- "cd" and "cd" → remove the second "cd"

---

### 🔹 Example 2

**Input:**

```

words = ["a","b","c","d","e"]

```

**Output:**

```

["a","b","c","d","e"]

```

No anagrams found.

---

## 💡 Approach

### 🔸 Step 1: Initialize Result

Start with the first word added to the list.

### 🔸 Step 2: Iterate Over Words

For each new word:

- Compare with the **last word** in the result list.
- Sort both and check if they are anagrams.

### 🔸 Step 3: Add Non-Anagrams

If they are **not anagrams**, append the new word.

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                                       |
| ------------ | ------------------------------------------------- |
| ⏱️ **Time**  | O(N × L log L) → sorting each word for comparison |
| 💾 **Space** | O(N × L) for storing results and temporary arrays |

---

## 🧠 Key Insights

- Sorting words is a simple way to check anagrams.
- Alternatively, you could use frequency arrays for O(26) checks.
- Removing anagrams works deterministically regardless of order.
