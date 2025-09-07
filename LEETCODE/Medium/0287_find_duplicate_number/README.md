# 287. Find the Duplicate Number

## Problem Statement

You are given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return this repeated number.

You must solve the problem:

- Without modifying the array `nums`
- Using only constant extra space
- In linear runtime complexity

---

## Examples

**Example 1**

```

Input: nums = \[1,3,4,2,2]
Output: 2

```

**Example 2**

```

Input: nums = \[3,1,3,4,2]
Output: 3

```

**Example 3**

```

Input: nums = \[3,3,3,3,3]
Output: 3

```

---

## Constraints

- `1 <= n <= 10^5`
- `nums.length == n + 1`
- `1 <= nums[i] <= n`
- All numbers in `nums` appear only once except **one number**, which appears two or more times.

---

## Approach

We use **Floyd’s Tortoise and Hare (Cycle Detection)**:

1. Treat the array as a **linked list**:

   - Each index points to the value at `nums[i]`.
   - Since there are `n+1` elements but only `n` possible values, at least one duplicate exists (Pigeonhole Principle).
   - This creates a **cycle** in the "linked list".

2. **Phase 1: Detect cycle**

   - Use two pointers (`slow` and `fast`).
   - Move `slow = nums[slow]` and `fast = nums[nums[fast]]`.
   - They meet inside the cycle.

3. **Phase 2: Find cycle entry (duplicate number)**
   - Reset `slow` to `nums[0]`.
   - Move both pointers one step at a time.
   - The meeting point is the duplicate.

---

## Complexity

- **Time Complexity:** `O(n)` → Each pointer traverses at most `2n` steps.
- **Space Complexity:** `O(1)` → Only two pointers used.

---

## Example Walkthrough

Input: `nums = [3,1,3,4,2]`

- Index traversal:

```

0 → 3 → 4 → 2 → 3 ...

```

Cycle formed at `3`.

- Floyd’s Algorithm finds the cycle and returns `3`.

```

```
