# 976. Largest Perimeter Triangle

## Problem Statement

You are given an integer array `nums`.  
Return the **largest perimeter** of a triangle with non-zero area that can be formed using three elements of `nums`.

If no such triangle can be formed, return `0`.

---

## Examples

### Example 1

```

Input: nums = \[2,1,2]
Output: 5

```

Explanation:  
Triangle sides = `(2,2,1)`.  
Perimeter = `2 + 2 + 1 = 5`.

---

### Example 2

```

Input: nums = \[1,2,1,10]
Output: 0

```

Explanation:  
No three sides satisfy the **triangle inequality** (sum of two smaller sides > largest side).

---

## Constraints

- `3 <= nums.length <= 10^4`
- `1 <= nums[i] <= 10^6`

---

## Approach

### Key Idea

For three sides `(a, b, c)` to form a valid triangle:
\[
a + b > c
\]

To maximize the perimeter:

1. **Sort** the array.
2. Start checking from the **largest elements** (descending order).
3. If the largest three sides satisfy the inequality, return their perimeter.
4. Otherwise, continue moving left.
5. If no valid triplet is found, return `0`.

---

## Complexity

- **Time Complexity:** `O(n log n)` due to sorting.
- **Space Complexity:** `O(1)` (in-place checks).

Efficient for input sizes up to `10^4`.
