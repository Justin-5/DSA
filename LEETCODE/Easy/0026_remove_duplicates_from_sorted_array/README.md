# 0026. Remove Duplicates from Sorted Array

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order,  
remove the duplicates **in-place** such that each unique element appears only once.  
Return the number of unique elements `k`.

- The first `k` elements of `nums` should contain the unique elements.
- It does not matter what values are left beyond index `k`.

---

## Examples

### Example 1

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]

### Example 2

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,,,,,_]

---

## Constraints

- 1 <= nums.length <= 30,000
- -100 <= nums[i] <= 100
- `nums` is sorted in non-decreasing order

---

## Approach

- Use a **two-pointer** approach.
- Pointer `k` tracks the position to place the next unique number.
- Iterate through the array and compare each element with the previous unique one.
- If they are different, copy it to the `k`th position.

---

## Time and Space Complexity

- **Time Complexity**: O(n)
- **Space Complexity**: O(1) (in-place, no extra memory used)

Solution by Justin Aroza
