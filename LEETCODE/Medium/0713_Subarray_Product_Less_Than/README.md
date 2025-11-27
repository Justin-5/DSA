# 713. Subarray Product Less Than K

## 🔍 Problem Summary

Given an integer array `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements in the subarray is **strictly less than `k`**.

---

### 🧠 Examples

| Input                      | Output | Explanation                                                         |
| -------------------------- | ------ | ------------------------------------------------------------------- |
| nums = [10,5,2,6], k = 100 | 8      | Valid subarrays: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6] |
| nums = [1,2,3], k = 0      | 0      | No subarray has a product < 0                                       |

---

### ⏱️ Constraints

- `1 <= nums.length <= 3 * 10⁴`
- `1 <= nums[i] <= 1000`
- `0 <= k <= 10⁶`

---

## ✔️ Approach — Sliding Window

- Maintain a window `[i .. j]` such that the product of elements inside it is `< k`.
- Expand the window by moving `j` forward.
- If product becomes `>= k`, shrink from the left by moving `i`.
- At each `j`, number of valid subarrays is `j - i + 1`.

---

## 🧩 Time & Space Complexity

| Complexity | Value  |
| ---------- | ------ |
| Time       | `O(n)` |
| Space      | `O(1)` |

---

## 🏁 Result

This solution efficiently counts subarrays without generating them explicitly using a **two-pointer sliding window method**.

```

```
