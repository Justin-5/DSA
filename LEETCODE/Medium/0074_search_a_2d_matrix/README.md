# 🔍 LeetCode 74. Search a 2D Matrix

### 📌 Problem

You are given an `m x n` matrix with two properties:

1. Each row is sorted in non-decreasing order.
2. The first element of each row is greater than the last element of the previous row.

Return `true` if `target` exists in the matrix, otherwise return `false`.

🔗 [Problem Link](https://leetcode.com/problems/search-a-2d-matrix/)

---

### 💡 Examples

**Example 1**  
Input:

```text
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output:true
Example 2
Input:

matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output:false
⚙️ Approach
Treat the 2D matrix as a flattened sorted array.

Use binary search in two stages:

Binary search on rows to find the possible row.

Binary search inside that row to check if target exists.

🛠️ Complexity
Time: O(log(m) + log(n)) ≈ O(log(m * n))

Space: O(1)

```
