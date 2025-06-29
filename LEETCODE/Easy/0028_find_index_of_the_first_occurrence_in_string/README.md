# 0028. Find the Index of the First Occurrence in a String

## Problem Statement

Given two strings `haystack` and `needle`, return the index of the **first occurrence** of `needle` in `haystack`, or `-1` if `needle` is **not** part of `haystack`.

---

## Examples

### Example 1

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6. The first occurrence is at index 0.

### Example 2

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" does not occur in "leetcode".

---

## Constraints

- 1 <= haystack.length, needle.length <= 10⁴
- `haystack` and `needle` consist only of lowercase English letters.

---

## Approach

- Use a brute-force approach by checking every substring of `haystack` starting from index `i` to see if it matches `needle`.
- If a match is found, return index `i`.
- If the end of `haystack` is reached without a match, return `-1`.

---

## Time and Space Complexity

- **Time Complexity**: O(n \* m), where `n` is the length of `haystack` and `m` is the length of `needle`.
- **Space Complexity**: O(1)

---

Solution by Justin Aroza
