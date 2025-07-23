# 0011. Container With Most Water

## Problem

You are given an integer array `height` of length `n`. There are `n` vertical lines such that the two endpoints of the `i-th` line are `(i, 0)` and `(i, height[i])`.

Find two lines that, together with the x-axis, form a container that holds the most water.

Return the **maximum amount of water** a container can store.

---

## Examples

### Example 1

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

shell
Copy
Edit

### Example 2

Input: height = [1,1]
Output: 1

yaml
Copy
Edit

---

## Constraints

- `n == height.length`
- `2 <= n <= 10^5`
- `0 <= height[i] <= 10^4`

---

## Approach

This solution uses the **two-pointer approach**:

- Start with two pointers, `i` at the beginning and `j` at the end.
- Calculate the area formed between the lines at `i` and `j`.
- Keep track of the maximum area seen so far.
- Move the pointer that has the shorter line toward the center, as only a taller line might improve the area.

This implementation avoids optimization and follows a straightforward conditional approach.

---

## Output

Maximum water the container can store: 49

Simple implementation by Justin Aroza
