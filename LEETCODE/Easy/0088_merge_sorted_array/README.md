# 0088. Merge Sorted Array

## Problem

You are given two integer arrays `nums1` and `nums2`, sorted in **non-decreasing** order, and two integers `m` and `n`, representing the number of elements in `nums1` and `nums2` respectively.

Merge `nums2` into `nums1` as one sorted array. `nums1` has enough space to hold all elements (size `m + n`).

---

## Examples

### Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3,
nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

### Example 2:

Input: nums1 = [1], m = 1,
nums2 = [], n = 0
Output: [1]

### Example 3:

Input: nums1 = [0], m = 0,
nums2 = [1], n = 1
Output: [1]

---

## Constraints

- `nums1.length == m + n`
- `nums2.length == n`
- `0 <= m, n <= 200`
- `-10^9 <= nums1[i], nums2[i] <= 10^9`

---

## Optimal Solution: Two Pointers (from End)

- Start from the end of both `nums1` and `nums2`.
- Compare elements and insert the larger one at the end of `nums1`.
- This way, we avoid overwriting existing data in `nums1`.

### Time & Space Complexity

- **Time**: O(m + n)
- **Space**: O(1)

---

Solution by Justin Aroza
