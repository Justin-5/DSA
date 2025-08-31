# 🔎 LeetCode 704. Binary Search

### 📌 Problem

Given a sorted array `nums` (ascending order) and a `target` integer,  
return the **index of target** if it exists, otherwise return `-1`.

🔗 [Problem Link](https://leetcode.com/problems/binary-search/)

---

### 💡 Examples

**Example 1**  
Input:

```text
nums = [-1,0,3,5,9,12], target = 9
Output:4
Explanation: 9 exists at index 4.

Example 2
Input:

text
Copy code
nums = [-1,0,3,5,9,12], target = 2
Output:-1
Explanation: 2 is not in the array.

⚙️ Approach
Use Binary Search since the array is sorted.

Keep two pointers: l (left) and r (right).

Repeatedly check the middle:

If nums[mid] == target → return mid.

If nums[mid] < target → discard left half (l = mid + 1).

If nums[mid] > target → discard right half (r = mid - 1).

If not found, return -1.

🛠️ Complexity
Time: O(log n)

Space: O(1)
```
