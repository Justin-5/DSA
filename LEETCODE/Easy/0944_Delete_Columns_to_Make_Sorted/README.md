# 944. Delete Columns to Make Sorted

## 🧠 Problem Description

You are given an array of `n` strings `strs`, where:

- All strings have the **same length**
- Each string represents a row in a grid

The grid is formed by arranging the strings line by line.  
Your task is to **delete columns that are not sorted lexicographically** (top to bottom).

A column is considered **sorted** if the characters in that column are in **non-decreasing order**.

Return the **number of columns** that need to be deleted.

---

## 📌 Examples

### Example 1

```

Input: strs = ["cba","daf","ghi"]
Grid:
c b a
d a f
g h i

Output: 1

```

Column 1 (`b, a, h`) is not sorted.

---

### Example 2

```

Input: strs = ["a","b"]
Output: 0

```

The single column is already sorted.

---

### Example 3

```

Input: strs = ["zyx","wvu","tsr"]
Output: 3

```

All columns are unsorted.

---

## 📋 Constraints

- `n == strs.length`
- `1 <= n <= 100`
- `1 <= strs[i].length <= 1000`
- `strs[i]` contains only lowercase English letters

---

## 💡 Solution Approach

### Key Idea

- Check **each column independently**
- For a column to be sorted:
  - Every character must be **greater than or equal to** the character above it

---

### 🧩 Algorithm Steps

1. Initialize a counter `delCount` to track columns to delete.
2. Loop through each column index `i`.
3. For each column:
   - Compare characters from row `1` to `n-1`
   - If `strs[j][i] < strs[j-1][i]`, the column is unsorted
   - Increment `delCount` and move to the next column
4. Return `delCount`

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n × m)**
  - `n` = number of strings
  - `m` = length of each string

### Space Complexity

- **O(1)**
  - Only a counter is used

---

## 🧪 Edge Cases Covered

- Single string
- Single column
- All columns sorted
- All columns unsorted
