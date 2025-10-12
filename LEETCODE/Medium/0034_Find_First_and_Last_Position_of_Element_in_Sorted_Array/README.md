### 🧠 Problem Summary

Given a sorted array `nums` (non-decreasing order) and a target value `target`,
find the **starting and ending index** of `target` in `nums`.

If `target` is not found, return `[-1, -1]`.

The algorithm must run in **O(log n)** time.

---

### 💡 Approach — Binary Search Twice

We use **binary search** twice:

1. Once to find the **first (leftmost)** occurrence of `target`.
2. Again to find the **last (rightmost)** occurrence of `target`.

#### 🔍 Key Insight

Even after finding `target`, we continue searching:

- For the **first occurrence**: move `right = mid - 1`.
- For the **last occurrence**: move `left = mid + 1`.

---

### 🧩 Steps

1. Define a helper function `binarySearch(nums, target, findFirst)`:

   - Use a loop to binary search for `target`.
   - When found, record the index.
   - Keep searching to left or right depending on `findFirst`.

2. In `searchRange()`:

   - Call `binarySearch(nums, target, true)` for the first position.
   - Call `binarySearch(nums, target, false)` for the last position.

3. Return both results in an array.

---

### 🧮 Example

#### Input:

```
nums = [5,7,7,8,8,10], target = 8
```

#### Step-by-step:

- First occurrence → index 3
- Last occurrence → index 4

✅ **Output:** `[3, 4]`

---

### ⚙️ Complexity

| Operation | Complexity |
| --------- | ---------- |
| **Time**  | O(log n)   |
| **Space** | O(1)       |
