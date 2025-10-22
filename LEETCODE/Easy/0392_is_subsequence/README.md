# 392. Is Subsequence

**Difficulty:** Easy  
**Topics:** Two Pointers, String  
**LeetCode Link:** [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/)

---

## 🧩 Problem Statement

Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise.

A **subsequence** of a string is a new string formed from the original by deleting some (possibly none) of its characters **without changing the relative order** of the remaining ones.

Example:

- `"ace"` is a subsequence of `"abcde"`
- `"aec"` is **not** a subsequence of `"abcde"`

---

## 🔹 Example 1

**Input:**

```

s = "abc", t = "ahbgdc"

```

**Output:**

```

true

```

---

## 🔹 Example 2

**Input:**

```

s = "axc", t = "ahbgdc"

```

**Output:**

```

false

```

---

## ⚙️ Constraints

- `0 <= s.length <= 100`
- `0 <= t.length <= 10^4`
- Both `s` and `t` consist only of lowercase English letters.

---

## 💡 Approach

### 🔸 Intuition

We can use a **two-pointer** approach:

- One pointer `i` traverses string `s`
- Another pointer `j` traverses string `t`
- Whenever characters match (`s[i] == t[j]`), move both pointers ahead.
- Otherwise, move only `j` (continue searching in `t`).

If by the end, `i == s.length()`, it means all characters of `s` were found in `t` in order — so `s` is a subsequence of `t`.

---

### 🔹 Example Walkthrough

**Input:**  
`s = "abc"`, `t = "ahbgdc"`

| Step | i   | j   | s[i] | t[j] | Match? | Action   |
| ---- | --- | --- | ---- | ---- | ------ | -------- |
| 1    | 0   | 0   | a    | a    | ✅     | i++, j++ |
| 2    | 1   | 1   | b    | h    | ❌     | j++      |
| 3    | 1   | 2   | b    | b    | ✅     | i++, j++ |
| 4    | 2   | 3   | c    | g    | ❌     | j++      |
| 5    | 2   | 4   | c    | d    | ❌     | j++      |
| 6    | 2   | 5   | c    | c    | ✅     | i++, j++ |

✅ `i == s.length()` → Return `true`.

---

## 🧰 Complexity Analysis

| Complexity   | Explanation                                   |
| ------------ | --------------------------------------------- |
| ⏱️ **Time**  | O(n + m), where n = s.length and m = t.length |
| 💾 **Space** | O(1), only constant extra space used          |

---

## 🔄 Follow-up

If there are **billions of `s` strings** and a single large `t`,  
we can preprocess `t` into a **character index map** (for binary search) to check each `s` efficiently.  
That approach reduces repeated scans over `t` for multiple `s` queries.
