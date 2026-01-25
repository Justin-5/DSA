# 1984. Minimum Difference Between Highest and Lowest of K Scores

## 🧠 Problem Description

You are given:

- A 0-indexed integer array `nums`, where `nums[i]` represents the score of the `i`-th student
- An integer `k`

You must pick the scores of **any `k` students** such that the **difference between the highest and the lowest score** among the selected students is minimized.

Return the **minimum possible difference**.

---

## 📌 Examples

### Example 1

```

Input: nums = [90], k = 1
Output: 0

```

Explanation:

- Only one student is selected
- Difference = `90 - 90 = 0`

---

### Example 2

```

Input: nums = [9,4,1,7], k = 2
Output: 2

```

Explanation:

- Best selection is `[7,9]`
- Difference = `9 - 7 = 2`

---

## 📋 Constraints

- `1 <= k <= nums.length <= 1000`
- `0 <= nums[i] <= 10^5`

---

## 💡 Solution Approach (Sorting + Sliding Window)

### Key Insight

After sorting the array:

- Any optimal group of `k` students will appear as a **contiguous subarray**
- The difference for a window starting at index `i` is:

```

nums[i + k - 1] - nums[i]

```

So the problem reduces to finding the **minimum difference** among all such windows.

---

## 🧩 Algorithm Steps

1. Sort the array `nums`
2. Initialize a variable to track the minimum difference
3. Slide a window of size `k` across the array
4. For each window:

- Compute `nums[i + k - 1] - nums[i]`
- Update the minimum

5. Return the minimum difference found

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n log n)** due to sorting

### Space Complexity

- **O(1)** extra space (sorting in place)

---

## 🧪 Edge Cases Covered

- `k = 1` (difference always `0`)
- All scores equal
- Small and large arrays
- Unsorted input

---
