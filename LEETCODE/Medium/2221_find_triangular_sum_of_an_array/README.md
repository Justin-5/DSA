# 2221. Find Triangular Sum of an Array

## Problem Statement

You are given a 0-indexed integer array `nums`, where each `nums[i]` is a digit between **0 and 9** (inclusive).

The **triangular sum** of `nums` is defined as the final single element left after repeatedly performing the following process:

1. If the array has length `n == 1`, stop.
2. Otherwise, create a new array `newNums` of length `n - 1`.
3. For each index `i` (`0 <= i < n - 1`), set:

```

newNums[i] = (nums[i] + nums[i+1]) % 10

```

4. Replace `nums` with `newNums` and repeat from step 1.

Return the **triangular sum** of the array.

---

## Examples

### Example 1

```

Input: nums = [1,2,3,4,5]
Output: 8
Explanation:
[1,2,3,4,5]
-> [(1+2)%10, (2+3)%10, (3+4)%10, (4+5)%10] = [3,5,7,9]
-> [(3+5)%10, (5+7)%10, (7+9)%10] = [8,2,6]
-> [(8+2)%10, (2+6)%10] = [0,8]
-> [(0+8)%10] = [8]
Final triangular sum = 8

```

### Example 2

```

Input: nums = [5]
Output: 5
Explanation: Since only one element exists, the sum is 5.

```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 9`

---

## Approach

### Key Idea

We repeatedly reduce the array until only one element remains:

- Each reduction step computes pairwise sums modulo `10`.
- Since the array size decreases by 1 each step, the process is guaranteed to terminate.

---

### Steps

1. Let `n = nums.length`.
2. While `n > 1`:
   - Create a new array of size `n - 1`.
   - Fill it with pairwise sums `(nums[i] + nums[i+1]) % 10`.
   - Replace `nums` with `newNums`.
   - Decrease `n`.
3. Return the only element left (`nums[0]`).

---

## Complexity

- **Time Complexity:** `O(n^2)`
  - At each step, we process about `n-1`, `n-2`, ..., `1` elements → total ≈ `n(n-1)/2`.
- **Space Complexity:** `O(n)`
  - We create a new array of smaller size each iteration.

---

## Follow-up

This problem can also be solved using **binomial coefficients mod 10**, but the direct simulation approach is simpler and works within constraints (`n <= 1000`).

```


```
