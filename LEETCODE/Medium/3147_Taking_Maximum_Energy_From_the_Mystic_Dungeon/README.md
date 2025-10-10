### 🧠 Problem Summary

You are given:

- An array `energy[]` of integers (positive and negative values allowed).
- An integer `k`, representing the teleport distance between magicians.

You can start from **any magician i**, and after absorbing their energy, you **teleport to (i + k)**, repeating the process until you leave the array bounds.

You must choose a starting point to **maximize the total energy absorbed**.

---

### 💡 Approach

This problem can be efficiently solved **from the end of the array backward**.

#### 🔁 Key Idea:

When you visit a magician `i`, your total energy is:

```
energy[i] + energy[i + k] + energy[i + 2k] + ...
```

Instead of computing this sum for every possible starting point (which would be O(n²)),
we can reuse previously computed results.

---

### 🧩 Steps

1. Traverse the array **from the end to the start**.
2. For each index `i`, if jumping `k` steps ahead is possible (`i + k < n`),
   update:

   ```java
   energy[i] += energy[i + k];
   ```

   → This means “total energy if starting at i” = energy at i + total energy starting from i+k.

3. Track the **maximum** energy value found during the traversal.

---

### 🧮 Complexity Analysis

| Operation | Time Complexity | Space Complexity |
| --------- | --------------- | ---------------- |
| Traversal | O(n)            | O(1)             |

Since we reuse the `energy[]` array to store cumulative sums, **no extra space** is needed.

---

### 🧠 Example

#### **Input**

```
energy = [5, 2, -10, -5, 1], k = 3
```

#### **Step-by-Step Execution**

```
Start from rightmost index:
i = 4 → no jump possible → energy[4] = 1
i = 3 → no jump possible → energy[3] = -5
i = 2 → i + 3 = 5 (out of bounds) → energy[2] = -10
i = 1 → i + 3 = 4 → energy[1] += energy[4] → 2 + 1 = 3
i = 0 → i + 3 = 3 → energy[0] += energy[3] → 5 + (-5) = 0
```

Updated `energy[]`: `[0, 3, -10, -5, 1]`

**Maximum energy = 3**

✅ Output: `3`

---

### 🧠 Insight

By updating each `energy[i]` to include its future teleport chain,
we essentially compress the recursive process into an **in-place DP solution**.
