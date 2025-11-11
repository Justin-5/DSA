# 162. Find Peak Element

## 🧩 Problem Description

A **peak element** in an array is one that is **strictly greater than its neighbors**.

Given a 0-indexed integer array `nums`, find any **peak element’s index**.

- If multiple peaks exist, return **any one** of them.
- You can imagine that:

```

nums[-1] = nums[n] = -∞

```

(i.e., edges are treated as negative infinity).

Your solution **must** run in **O(log n)** time.

---

## 🔍 Example 1

**Input**

```

nums = [1,2,3,1]

```

**Output**

```

2

```

**Explanation**
`3` is a peak element since `3 > 2` and `3 > 1`.

---

## 🔍 Example 2

**Input**

```

nums = [1,2,1,3,5,6,4]

```

**Output**

```

5

```

**Explanation**
Both `nums[1] = 2` and `nums[5] = 6` are peaks.  
Returning either `1` or `5` is valid.

---

## ⚙️ Constraints

- `1 <= nums.length <= 1000`
- `-2³¹ <= nums[i] <= 2³¹ - 1`
- `nums[i] != nums[i + 1]` for all valid `i`.

---

## 💡 Approach — Binary Search for Peak

### Intuition

The key insight is:

> If `nums[mid] < nums[mid + 1]`, then there must be a **peak on the right side**.  
> Otherwise, there’s guaranteed to be a **peak on the left side (including mid)**.

This works because the array "moves upward" toward a peak and "downward" afterward — similar to a **mountain** shape.

---

### Algorithm

1. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
2. While `left < right`:
   - Compute `mid = (left + right) / 2`.
   - If `nums[mid] < nums[mid + 1]`, move right:  
     → `left = mid + 1`
   - Else, move left:  
     → `right = mid`
3. When the loop ends, `left == right` — the index of a peak.

---

### 🧮 Example Walkthrough

**Input**

```

nums = [1, 2, 3, 1]

```

| Step | left | right | mid | nums[mid] | nums[mid+1] | Decision           | New Range |
| ---- | ---- | ----- | --- | --------- | ----------- | ------------------ | --------- |
| 1    | 0    | 3     | 1   | 2         | 3           | 2 < 3 → move right | [2, 3]    |
| 2    | 2    | 3     | 2   | 3         | 1           | 3 > 1 → move left  | [2, 2]    |

✅ Peak found at index **2** (`nums[2] = 3`).

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                              |
| --------- | ---------- | ---------------------------------------- |
| **Time**  | `O(log n)` | Binary search halves the range each step |
| **Space** | `O(1)`     | No extra data structures                 |
