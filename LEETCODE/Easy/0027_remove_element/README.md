# 0027. Remove Element

## Problem Statement

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` **in-place**.  
The order of elements may change. Then return the number of elements in `nums` which are **not equal** to `val`.

You must:

- Change the array in-place such that the first `k` elements are the ones not equal to `val`.
- Return `k` — the count of those elements.

---

## Examples

### Example 1

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,,]

### Example 2

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,,,_]

---

## Constraints

- 0 <= nums.length <= 100
- 0 <= nums[i] <= 50
- 0 <= val <= 100

---

## Approach

- Use the **two-pointer overwrite method**:
  - Iterate with one pointer `i` over the array.
  - Use another pointer `j` to track where to write elements not equal to `val`.
- For every element not equal to `val`, copy it to `nums[j]` and increment `j`.
- Return `j` as the new length of the array.

---

## Time and Space Complexity

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

---

Solution by Justin Aroza
