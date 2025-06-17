# 0014. Longest Common Prefix

## Problem Statement

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

### Example 1

Input: strs = ["flower", "flow", "flight"]
Output: "fl"

### Example 2

Input: strs = ["dog", "racecar", "car"]
Output: ""
Explanation: There is no common prefix among the input strings.

---

## Constraints

- 1 <= strs.length <= 200
- 0 <= strs[i].length <= 200
- strs[i] consists of only lowercase English letters if it is non-empty

---

## Approach

1. If there's only one string, return it.
2. Sort the array of strings lexicographically.
3. The common prefix must lie between the **first and last strings** in the sorted array.
4. Compare the first and last strings character by character until characters differ.

---

## Time and Space Complexity

- **Time Complexity**: O(n \* log n + m), where `n` is the number of strings and `m` is the length of the smallest string. Sorting takes `O(n log n)`.
- **Space Complexity**: O(m) — for storing the prefix result.

---

Solution by Justin Aroza
