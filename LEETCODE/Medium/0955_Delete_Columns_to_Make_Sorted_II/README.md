# 955. Delete Columns to Make Sorted II

## 🧠 Problem Description

You are given an array of `n` strings `strs`, where:

- All strings have the **same length**
- Each string represents a row in a grid

You may choose any set of **column indices** and delete those columns from **every string**.

After deletions, the resulting array must be in **lexicographic order**:

```

strs[0] <= strs[1] <= strs[2] <= ... <= strs[n-1]

```

Your task is to return the **minimum number of columns** that must be deleted to achieve this.

---

## 📌 Examples

### Example 1

```

Input: strs = ["ca","bb","ac"]
Output: 1

```

Explanation:

- Deleting column 0 results in `["a","b","c"]`
- The array is now lexicographically sorted

---

### Example 2

```

Input: strs = ["xc","yb","za"]
Output: 0

```

Explanation:

- The array is already sorted
- No deletion required

---

### Example 3

```

Input: strs = ["zyx","wvu","tsr"]
Output: 3

```

Explanation:

- Every column violates lexicographic order
- All columns must be deleted

---

## 📋 Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 100`
- `strs[i]` consists of lowercase English letters

---

## 💡 Key Insight

Unlike **LeetCode 944**, we **cannot evaluate columns independently**.

Why?

- A column that looks unsorted **may become irrelevant** if previous columns already establish lexicographic order between rows.

So we must:

- Track which adjacent rows are **already confirmed sorted**
- Only compare rows that are **not yet sorted**

---

## 💡 Solution Approach (Greedy + State Tracking)

### Core Idea

Process columns from **left to right**, greedily deciding whether to:

- **Delete the column**, or
- **Keep it and update row ordering state**

---

### 🧩 Algorithm Steps

1. Maintain a boolean array `sortedRow[]`:
   - `sortedRow[j] = true` means `strs[j] < strs[j+1]` is already guaranteed
2. For each column:
   - Compare only row pairs that are **not yet sorted**
3. If any comparison violates order:
   - Delete the column
4. Otherwise:
   - Mark rows as sorted when a strict `<` is found
5. Stop early if all row pairs are sorted

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n × m)**
  - `n` = number of strings
  - `m` = length of each string

### Space Complexity

- **O(n)**
  - Boolean array to track sorted row pairs

---

## 🧪 Edge Cases Covered

- Already sorted array
- All columns need deletion
- Early termination when ordering is complete
- Partial ordering across columns
