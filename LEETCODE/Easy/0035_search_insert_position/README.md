# 0035. Search Insert Position

## Problem Statement

Given a sorted array of **distinct** integers and a target value, return the index if the target is found.  
If not, return the index where it would be if it were inserted in order.

You **must** write an algorithm with **O(log n)** runtime complexity.

---

## Examples

### Example 1

Input: nums = [1,3,5,6], target = 5
Output: 2

### Example 2

Input: nums = [1,3,5,6], target = 2
Output: 1

### Example 3

Input: nums = [1,3,5,6], target = 7
Output: 4

---

## Constraints

- 1 <= nums.length <= 10⁴
- -10⁴ <= nums[i], target <= 10⁴
- All values in `nums` are distinct and sorted in ascending order.

---

## Approach

- Use a linear scan to compare each element with the target.
- If `target == nums[i]` return `i`.
- If `nums[i] < target` and next number is greater, return `i + 1`.
- If end is reached, insert at the end.

> This version is O(n). In production, you should use **binary search** to achieve the required O(log n).

---

## Time & Space Complexity

- **Time Complexity**: O(n)
- **Space Complexity**: O(1)

---

Solution by Justin Aroza
