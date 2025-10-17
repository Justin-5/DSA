# 5. Longest Palindromic Substring 💫

**Difficulty:** Medium  
**Topics:** String, Dynamic Programming, Expand Around Center  
**LeetCode Link:** [5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

---

## 🧩 Problem Statement

Given a string `s`, return the **longest palindromic substring** in `s`.

A string is a palindrome if it reads the same forward and backward.

---

### 🔹 Example 1

**Input:**

```

s = "babad"

```

**Output:**

```

"bab"

```

**Explanation:**
"aba" is also a valid answer.

---

### 🔹 Example 2

**Input:**

```

s = "cbbd"

```

**Output:**

```

"bb"

```

---

## ⚙️ Constraints

- `1 <= s.length <= 1000`
- `s` consists of only digits and English letters.

---

## 💡 Approach

### 🔸 Intuition

The key insight is that **every palindrome mirrors around its center**.  
So, for each index in the string, we can try to **expand around it** to find the longest palindrome that uses it as the center.

There are two types of centers:

1. **Odd-length palindrome** (centered at one character)  
   → Expand around `(i, i)`
2. **Even-length palindrome** (centered between two characters)  
   → Expand around `(i, i + 1)`

We expand both ways and keep track of the longest palindrome found.

---

### 🔹 Steps

1. Iterate through every index `i` in the string.
2. Expand around the center at `(i, i)` and `(i, i + 1)` to find palindrome lengths.
3. Choose the longer palindrome length and update the start and end indices if it’s the new maximum.
4. Return the substring using the final indices.

---

### 🧮 Complexity Analysis

| Complexity   | Explanation                                                     |
| ------------ | --------------------------------------------------------------- |
| ⏱️ **Time**  | O(n²) — For each character, expand up to the full string length |
| 💾 **Space** | O(1) — Constant extra space used                                |

---

## 🧠 Example Walkthrough

**Input:** `s = "babad"`

| i   | Center Type | Palindrome | Length | Current Longest |
| --- | ----------- | ---------- | ------ | --------------- |
| 0   | "b" (odd)   | "b"        | 1      | "b"             |
| 1   | "a" (odd)   | "bab"      | 3      | "bab"           |
| 2   | "b" (odd)   | "aba"      | 3      | "bab"           |
| 3   | "a" (odd)   | "a"        | 1      | "bab"           |
| 4   | "d" (odd)   | "d"        | 1      | "bab"           |

✅ Final answer → `"bab"`
