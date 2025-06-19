# 0020. Valid Parentheses

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is **valid**.

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every closing bracket has a corresponding opening bracket.

---

### Examples

#### Example 1

Input: s = "()"
Output: true

#### Example 2

Input: s = "()[]{}"
Output: true

#### Example 3

Input: s = "(]"
Output: false

#### Example 4

Input: s = "([])"
Output: true

---

## Constraints

- 1 <= s.length <= 10⁴
- `s` consists only of characters: `()[]{}`

---

## Approach

- Use a **stack** to keep track of opening brackets.
- When a closing bracket is encountered:
  - Check if the top of the stack contains the matching opening bracket.
  - If so, pop it.
  - Otherwise, return `false`.
- At the end, the stack should be empty.

---

## Time and Space Complexity

- **Time Complexity**: O(n), where n is the length of the string.
- **Space Complexity**: O(n), for the stack used to hold opening brackets.

---

Solution by Justin Aroza
