# 960. Delete Columns to Make Sorted III

## 🧠 Problem Description

You are given an array of `n` strings `strs`, where:

- All strings have the **same length**
- Each string represents a row in a grid

You may delete any set of **column indices**, and those columns are removed from **every string**.

After deletions, **each individual string (row)** must be in **lexicographic (non-decreasing) order**:

```

strs[i][0] <= strs[i][1] <= ... <= strs[i][last]

```

⚠️ Important:

- The **rows do NOT need to be sorted relative to each other**
- Only **within each row**, characters must be sorted

Return the **minimum number of columns** that need to be deleted.

---

## 📌 Examples

### Example 1

```

Input: strs = ["babca","bbazb"]
Output: 3

```

Explanation:

- Delete columns `{0, 1, 4}`
- Result: ["bc", "az"]
- Both rows are individually sorted

---

### Example 2

```

Input: strs = ["edcba"]
Output: 4

```

Explanation:

- The single row is strictly decreasing
- Only one character can remain → delete 4 columns

---

### Example 3

```

Input: strs = ["ghi","def","abc"]
Output: 0

```

Explanation:

- All rows are already sorted
- No deletions needed

---

## 📋 Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 100`
- `strs[i]` contains lowercase English letters

---

## 💡 Key Insight

This problem reduces to finding the **Longest Increasing Subsequence (LIS)** of columns such that:

For two columns `j < i`, column `j` can come before column `i` **only if**:

```

strs[k][j] <= strs[k][i]   for every row k

```

Each column behaves like a vector of characters across all rows.

---

## 💡 Solution Approach (Dynamic Programming)

### Core Idea

- Treat each column as an element
- Find the **longest sequence of columns** that keeps all rows sorted
- The columns not in this sequence must be deleted

---

### 🧩 Algorithm Steps

1. Use a DP array `dp[i]`:
   - `dp[i]` = longest valid sequence ending at column `i`
2. Initialize all `dp[i] = 1`
3. For each column `i`:
   - Check all previous columns `j < i`
   - If column `j` can precede column `i` for **all rows**, update:
     ```
     dp[i] = max(dp[i], dp[j] + 1)
     ```
4. Track `maxKeep = max(dp[i])`
5. Final answer:

````

deletions = totalColumns - maxKeep

```

---

## ⏱️ Time and Space Complexity

### Time Complexity
- **O(m² × n)**
- `m` = number of columns
- `n` = number of rows

### Space Complexity
- **O(m)**
- DP array

---

## 🧪 Edge Cases Covered

- Single row
- Multiple rows
- Fully sorted rows
- Fully decreasing rows
- Mixed column dependencies

````
