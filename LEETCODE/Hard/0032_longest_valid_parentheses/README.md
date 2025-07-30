# 0032. Longest Valid Parentheses

## Problem

Given a string containing only the characters `(` and `)`, find the length of the longest valid (well-formed) parentheses substring.

---

## Examples

### Example 1

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"

### Example 2

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

### Example 3

Input: ""
Output: 0

---

## Constraints

- 0 <= s.length <= 30,000
- s[i] is either '(' or ')'

---

## Approach

- Iterate from every index `i` to the end of the string.
- For every possible substring starting at `i`, keep a count of open and close parentheses.
- If `open == close`, we have a valid substring.
- Update `maxcount` with the maximum valid length found.
- If at any point `close > open`, break the inner loop as it's invalid.

---

## Note

This is a brute-force solution with **O(n²)** time complexity. It is intentionally **not optimized** as per instructions.

---

## Output

Input: "(()" → Output: 2
Input: ")()())" → Output: 4
Input: "" → Output: 0

Simple implementation by Justin Aroza
