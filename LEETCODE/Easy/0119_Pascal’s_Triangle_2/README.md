### 🧠 Problem Summary

You are given an integer `rowIndex`, and you need to return the **rowIndexᵗʰ row** (0-indexed) of **Pascal’s Triangle**.

In Pascal’s Triangle:

- The first and last element of every row is `1`.
- Each interior element is the **sum of the two elements directly above it**.

---

### 💡 Approach

We don’t need to generate the entire Pascal’s Triangle — just the target row.

#### 🔁 Key Idea:

Each element `row[j]` can be computed **in place**, going **backward** so that previous values aren’t overwritten before they’re used.

#### Formula:

```
row[j] = row[j] + row[j - 1]
```

→ Iterate `j` from `i - 1` down to `1` to preserve previously computed values.

---

### 🧩 Steps

1. Initialize a list `row` with `[1]` (the first row).
2. For each new row `i`:

   - Traverse from the **end of the row to the beginning** (reverse order).
   - Update each value using the above formula.
   - Append a `1` at the end (last element is always 1).

3. Return the final list.

---

### 🧮 Example

#### Input:

```
rowIndex = 3
```

#### Step-by-step:

```
row = [1]
i = 1 → row = [1, 1]
i = 2 → update backwards: [1, 2, 1]
i = 3 → update backwards: [1, 3, 3, 1]
```

✅ **Output:** `[1, 3, 3, 1]`

---

### ⚙️ Optimization

| Factor               | Value                       |
| -------------------- | --------------------------- |
| **Time Complexity**  | O(n²)                       |
| **Space Complexity** | O(n)                        |
| **In-place update?** | ✅ Yes — uses one list only |

---

### 🧠 Insight

By updating from **right to left**, we ensure we’re not overwriting data that’s still needed for computation — this is a classic **in-place DP pattern**.
