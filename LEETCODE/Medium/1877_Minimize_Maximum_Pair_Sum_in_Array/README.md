# 1877. Minimize Maximum Pair Sum in Array

## 🧠 Problem Description

You are given an integer array `nums` of **even length**.

The **pair sum** of a pair `(a, b)` is defined as `a + b`.  
The **maximum pair sum** is the largest sum among all formed pairs.

Your task is to pair up all elements of `nums` such that:

- Each element is used **exactly once**
- The **maximum pair sum** is minimized

Return the minimized maximum pair sum.

---

## 📌 Examples

### Example 1

```

Input: nums = [3,5,2,3]
Output: 7

```

Explanation:

- Optimal pairing: `(3,3)` and `(5,2)`
- Pair sums: `6` and `7`
- Maximum pair sum = `7`

---

### Example 2

```

Input: nums = [3,5,4,2,4,6]
Output: 8

```

Explanation:

- Optimal pairing: `(2,6)`, `(3,5)`, `(4,4)`
- All pair sums = `8`

---

## 📋 Constraints

- `n == nums.length`
- `2 <= n <= 10^5`
- `n` is even
- `1 <= nums[i] <= 10^5`

---

## 💡 Solution Approach (Greedy + Two Pointers)

### Key Insight

To minimize the **maximum** pair sum:

- Pair the **smallest** number with the **largest** number
- This balances large values and prevents any pair from becoming too large

This greedy strategy guarantees the optimal result.

---

## 🧩 Algorithm Steps

1. Sort the array `nums`
2. Initialize two pointers:
   - `i` at the beginning (smallest)
   - `j` at the end (largest)
3. Pair `nums[i]` with `nums[j]`
4. Track the maximum sum among all pairs
5. Move both pointers inward
6. Continue until all pairs are formed

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n log n)** due to sorting

### Space Complexity

- **O(1)** extra space (in-place sort)

---

## 🧪 Edge Cases Covered

- Minimum array size
- All equal elements
- Large values
- Already optimally paired arrays

---
