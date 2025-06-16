# 0001. Two Sum

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

### Example 1

Input: nums = [3,2,4], target = 6
Output: [1,2]

### Example 2

Input: nums = [2,7,11,15], target = 9
Output: [0,1]

### Example 3

Input: nums = [3,3], target = 6
Output: [0,1]

## Constraints

- 2 <= nums.length <= 10⁴
- -10⁹ <= nums[i] <= 10⁹
- -10⁹ <= target <= 10⁹
- Only one valid answer exists.

## Approach

This is a brute-force solution using two nested loops to try every pair of elements and check if their sum equals the target.

### Time Complexity

- **O(n²)** — We loop through all pairs.

### Space Complexity

- **O(1)** — No extra space used except for the result.

## Notes

- The function dynamically allocates memory for the result and assumes the caller will `free()` it.
- It stops execution as soon as a pair is found.

## Author

- Solution by Justin Aroza
