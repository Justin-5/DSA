# 1317. Convert Integer to the Sum of Two No-Zero Integers

## Problem Statement

A **No-Zero integer** is a positive integer that does not contain the digit `0` in its decimal representation.

Given an integer `n`, return a list of two integers `[a, b]` where:

- Both `a` and `b` are **No-Zero integers**.
- `a + b = n`.

It is guaranteed that at least one valid solution exists.  
If there are multiple valid solutions, return any of them.

---

## Examples

**Example 1**

```

Input: n = 2
Output: \[1, 1]
Explanation: Both 1 and 1 are No-Zero integers, and 1 + 1 = 2.

```

**Example 2**

```

Input: n = 11
Output: \[2, 9]
Explanation: 2 and 9 are valid since neither contain a '0'.
Other valid answers include \[8, 3].

```

---

## Constraints

- `2 <= n <= 10^4`

---

## Approach

1. Iterate through possible values of `a` from `1` to `n-1`.
2. Let `b = n - a`.
3. Check if both `a` and `b` are **No-Zero integers**:
   - A helper function `checkNonZero()` verifies that no digit of the number is `0`.
4. Return the first valid pair `[a, b]`.

---

## Complexity

- **Time Complexity:** `O(n * log(n))`
  - Worst case, check all values from `1` to `n`, and each check is `O(log n)` due to digit extraction.
- **Space Complexity:** `O(1)`
  - Only storing two integers.

---

## Example Walkthrough

Input: `n = 11`

- Try `a = 1, b = 10` → `b` is invalid (contains 0).
- Try `a = 2, b = 9` → both valid. ✅

Output: `[2, 9]`

```


```
