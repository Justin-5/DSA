# 0022. Generate Parentheses

## Problem

Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

---

## Examples

### Example 1

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

### Example 2

Input: n = 1
Output: ["()"]

---

## Constraints

- `1 <= n <= 8`

---

## Approach

This is a basic **backtracking** approach using recursion. We build the parenthesis string character by character:

- If we can still add an opening bracket `(`, do so and recurse.
- If the number of closing brackets used so far is less than opening brackets used, we can add a `)` and recurse.

No optimization is applied; the solution uses simple recursion and stores intermediate strings in an over-allocated array.

---

## Output (for n = 3)

Generated parentheses for n = 3:
["((()))","(()())","(())()","()(())","()()()"]

Simple implementation by Justin Aroza
