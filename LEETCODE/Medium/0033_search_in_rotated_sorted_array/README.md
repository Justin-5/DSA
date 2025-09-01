# 🔄 LeetCode 33. Search in Rotated Sorted Array

### 📌 Problem

An array of integers `nums` is sorted in ascending order and then **rotated** at an unknown pivot.  
You need to find the index of the given `target` in O(log n) time.  
If it does not exist, return `-1`.

🔗 [Problem Link](https://leetcode.com/problems/search-in-rotated-sorted-array/)

---

### 💡 Examples

**Example 1**  
Input:

```text
nums = [4,5,6,7,0,1,2], target = 0
Output:
4
Example 2
Input:
nums = [4,5,6,7,0,1,2], target = 3
Output:
-1
Example 3
Input:
nums = [1], target = 0
Output:
-1
⚙️ Approach
Use binary search with modification for rotation.

At each step, determine which half of the array is sorted:

If left half is sorted: check if the target lies within it.

Otherwise, the right half is sorted: check if the target lies within it.

Narrow down the search space accordingly until found or exhausted.

🛠️ Complexity
Time: O(log n)

Space: O(1)
```
