# 0004. Median of Two Sorted Arrays

## Problem

Given two sorted arrays `nums1` and `nums2`, return the median of the combined sorted array.  
The goal is to achieve O(log(m+n)) complexity, but this solution uses a merge-based approach for simplicity.

---

## Examples

### Example 1

Input: nums1 = [1, 3], nums2 = [2]
Merged: [1, 2, 3]
Median: 2.00000

### Example 2

Input: nums1 = [1, 2], nums2 = [3, 4]
Merged: [1, 2, 3, 4]
Median: (2 + 3) / 2 = 2.50000

---

## Constraints

- 0 <= nums1.length, nums2.length <= 1000
- 1 <= nums1.length + nums2.length <= 2000
- Elements range from -10⁶ to 10⁶

---

## Approach

- Merge both sorted arrays into one sorted array.
- Use index logic to find the median based on even/odd total length.
- This version is not optimized and uses O(m+n) space and time.

---

## Output

Median: 2.00000

Simple implementation by Justin Aroza
