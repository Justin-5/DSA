# 0002. Palindrome Number

## Problem Statement

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

A palindrome number reads the same backward as forward.

---

### Example 1

Input: x = 121
Output: true
Explanation: 121 reads the same from left to right and right to left.

### Example 2

Input: x = -121
Output: false
Explanation: -121 becomes 121- when reversed, which is not the same.

### Example 3

Input: x = 10
Output: false
Explanation: 10 becomes 01 when reversed, which is not the same.

---

## Constraints

- -2³¹ ≤ x ≤ 2³¹ - 1

---

## Approach

We reverse the number and compare it with the original.

Steps:

1. Handle negative numbers — they are not palindromes.
2. Use a loop to reverse the digits of `x` (store in a new variable).
3. Compare the reversed number with the original.

---

## Time and Space Complexity

- **Time Complexity**: O(log₁₀ n)  
  (We process each digit once.)
- **Space Complexity**: O(1)  
  (No extra space used except for variables.)

---

Edge Case
Negative numbers are not palindromes, so you could add:

if (x < 0) return false;

Author
Solution by Justin Aroza
