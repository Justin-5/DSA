# 80. Remove Duplicates from Sorted Array II

**Difficulty:** Medium  
**Topics:** Array, Two Pointers  
**LeetCode Link:** [80. Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

---

## 🧩 Problem Statement

Given an integer array `nums` **sorted in non-decreasing order**, remove some duplicates **in-place** such that **each unique element appears at most twice**.

The **relative order** of the elements should remain the same.

You must modify the input array in-place using **O(1)** extra memory and return the new length `k` — the number of elements remaining after removing extra duplicates.

After the function returns:

- The first `k` elements of `nums` should contain the resulting array.
- The remaining positions beyond `k` can be ignored.

---

## 🔹 Example 1

**Input:**

```

nums = [1,1,1,2,2,3]

```

**Output:**

```

k = 5, nums = [1,1,2,2,3,_]

```

**Explanation:**
Only up to two occurrences of each number are kept.

---

## 🔹 Example 2

**Input:**

```

nums = [0,0,1,1,1,1,2,3,3]

```

**Output:**

```

k = 7, nums = [0,0,1,1,2,3,3,*,*]

```

---

## ⚙️ Constraints

- `1 <= nums.length <= 3 * 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` is sorted in non-decreasing order.

---

## 💡 Approach

### 🔸 Intuition

Since the array is already **sorted**, duplicates will always be adjacent.

We can use a **two-pointer** approach:

- One pointer (`i`) traverses the array.
- The other pointer (`j`) keeps track of the position where the next valid number should be placed.

We allow **each number to appear at most twice**.

---

### 🔹 Steps

1. Initialize a pointer `j = 0` (write pointer).
2. Loop through `nums` with pointer `i`.
3. For each `nums[i]`, check:
   - If `j < 2` → always include the number (because we can have up to 2 occurrences).
   - Else if `nums[i] > nums[j - 2]` → include the number because it’s a new unique value or a valid second duplicate.
4. Assign `nums[j] = nums[i]` and increment `j`.

After processing all elements:

- The first `j` elements in `nums` will be the modified array.
- Return `j`.

---

## 🧮 Example Walkthrough

**Input:**

```

nums = [1,1,1,2,2,3]

```

| Step | i   | nums[i] | Condition               | Updated nums | j   |
| ---- | --- | ------- | ----------------------- | ------------ | --- |
| 0    | 0   | 1       | j < 2 ✅                | [1]          | 1   |
| 1    | 1   | 1       | j < 2 ✅                | [1,1]        | 2   |
| 2    | 2   | 1       | nums[i] > nums[j-2]? ❌ | [1,1]        | 2   |
| 3    | 3   | 2       | nums[i] > nums[j-2]? ✅ | [1,1,2]      | 3   |
| 4    | 4   | 2       | nums[i] > nums[j-2]? ✅ | [1,1,2,2]    | 4   |
| 5    | 5   | 3       | nums[i] > nums[j-2]? ✅ | [1,1,2,2,3]  | 5   |

✅ Result: `k = 5`, `nums = [1,1,2,2,3,_]`

---

## 🧰 Complexity Analysis

| Complexity   | Explanation                                       |
| ------------ | ------------------------------------------------- |
| ⏱️ **Time**  | O(n) — Single pass through the array              |
| 💾 **Space** | O(1) — In-place modification, no extra array used |

---

## 🧠 Key Takeaway

This problem builds on the “Remove Duplicates from Sorted Array” (LeetCode 26),  
but requires allowing **at most two occurrences** instead of one — a good test of mastering the **two-pointer pattern**.
