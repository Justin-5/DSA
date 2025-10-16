# 283. Move Zeroes ⚙️

**Difficulty:** Easy  
**Topics:** Array, Two Pointers, In-place Operations  
**LeetCode Link:** [283. Move Zeroes](https://leetcode.com/problems/move-zeroes/)

---

## 🧩 Problem Statement

Given an integer array `nums`, move all `0`'s to the **end** of it while maintaining the **relative order** of the non-zero elements.

You must do this **in-place** (without making a copy of the array).

---

### 🔹 Example 1

**Input:**

```

nums = [0,1,0,3,12]

```

**Output:**

```

[1,3,12,0,0]

```

**Explanation:**
The non-zero elements `[1, 3, 12]` maintain their original order, and all zeros are moved to the end.

---

### 🔹 Example 2

**Input:**

```

nums = [0]

```

**Output:**

```

[0]

```

---

## ⚙️ Constraints

- `1 <= nums.length <= 10⁴`
- `-2³¹ <= nums[i] <= 2³¹ - 1`

---

## 💡 Approach

### 🔸 Intuition

We can solve this efficiently using a **two-pointer** technique:

- One pointer (`insert`) keeps track of the position to insert the next non-zero element.
- The other pointer (`i`) iterates through the array.

Each time we find a non-zero element, we move it to `nums[insert]` and increment `insert`.

After processing all elements, fill the rest of the array with zeros.

---

### 🔹 Steps

1. Initialize a pointer `insert = 0`.
2. Traverse through the array:
   - If `nums[i] != 0`, assign `nums[insert++] = nums[i]`.
3. After traversal, set all elements from `insert` to the end as `0`.

---

## 🧮 Complexity Analysis

| Complexity        | Explanation                          |
| ----------------- | ------------------------------------ |
| ⏱️ **Time**       | O(n) — single pass through the array |
| 💾 **Space**      | O(1) — in-place modification         |
| 🔄 **Operations** | Minimal number of writes             |

---

## 🧠 Example Walkthrough

**Input:**  
`nums = [0, 1, 0, 3, 12]`

| Step     | i   | nums[i] | insert | Array state          |
| -------- | --- | ------- | ------ | -------------------- |
| 1        | 0   | 0       | 0      | [0, 1, 0, 3, 12]     |
| 2        | 1   | 1       | 1      | [1, 1, 0, 3, 12]     |
| 3        | 2   | 0       | 1      | [1, 1, 0, 3, 12]     |
| 4        | 3   | 3       | 2      | [1, 3, 0, 3, 12]     |
| 5        | 4   | 12      | 3      | [1, 3, 12, 3, 12]    |
| ✅ Final | -   | -       | -      | **[1, 3, 12, 0, 0]** |
