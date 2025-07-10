# 0069. Sqrt(x)

## Problem Statement

Given a non-negative integer `x`, return the square root of `x` **rounded down** to the nearest integer. You must not use any built-in exponent function or operator like `pow()` or `sqrt()`.

---

## Examples

### Example 1

Input: x = 4
Output: 2
Explanation: √4 = 2. Return 2.

### Example 2

Input: x = 8
Output: 2
Explanation: √8 ≈ 2.828... Rounded down is 2.

---

## Constraints

- 0 <= x <= 2³¹ - 1

---

## Approach

- Use **binary search** to find the integer square root.
- Set search bounds as [1, x].
- Use `mid = low + (high - low) / 2` to prevent overflow.
- Compare `mid` with `x / mid` instead of `mid * mid` to avoid integer overflow.

---

## Time & Space Complexity

- **Time Complexity**: O(log x)
- **Space Complexity**: O(1)

---

Solution by Justin Aroza
