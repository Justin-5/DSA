# 274. H-Index

## 🧩 Problem Description

Given an integer array `citations` where `citations[i]` represents the number of citations a researcher received for their _i-th paper_, return the **researcher's h-index**.

The **h-index** is defined as:

> The maximum value of `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.

---

### 🔍 Example 1

**Input:**

```

citations = [3,0,6,1,5]

```

**Output:**

```

3

```

**Explanation:**
The researcher has 5 papers with citation counts `[3,0,6,1,5]`.

- 3 papers have at least 3 citations.
- The rest have fewer than 3 citations.  
  Hence, `h-index = 3`.

---

### 🔍 Example 2

**Input:**

```

citations = [1,3,1]

```

**Output:**

```

1

```

---

### ⚙️ Constraints

- `n == citations.length`
- `1 <= n <= 5000`
- `0 <= citations[i] <= 1000`

---

## 💡 Approach (Based on Your Code)

1. **Sort** the array of citations in ascending order.
2. For each paper `i` (after sorting):
   - Let `h = n - i`, which represents the number of papers with at least `citations[i]` citations.
   - If `citations[i] >= h`, then `h` is a valid h-index.
3. Return the first valid `h` found, otherwise return 0.

---

### 🧠 Example Walkthrough

For `citations = [3, 0, 6, 1, 5]`:

| Step | Sorted Citations | i   | h = n - i | citations[i] | Condition (≥ h) | Result   |
| ---- | ---------------- | --- | --------- | ------------ | --------------- | -------- |
| 1    | [0, 1, 3, 5, 6]  | 0   | 5         | 0            | ❌              | continue |
| 2    | [0, 1, 3, 5, 6]  | 1   | 4         | 1            | ❌              | continue |
| 3    | [0, 1, 3, 5, 6]  | 2   | 3         | 3            | ✅              | return 3 |

✅ h-index = 3

---

### ⏱️ Time Complexity

- **O(n log n)** → Sorting the citations.
- **O(n)** → Single scan after sorting.

**Total:** O(n log n)

### 💾 Space Complexity

- **O(1)** → In-place sort and computation.
