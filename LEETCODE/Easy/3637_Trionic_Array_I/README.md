# 3637. Trionic Array I

## 🧠 Problem Description

You are given an integer array `nums` of length `n`.

An array is called **trionic** if there exist indices `0 < p < q < n - 1` such that:

1. `nums[0...p]` is **strictly increasing**
2. `nums[p...q]` is **strictly decreasing**
3. `nums[q...n - 1]` is **strictly increasing**

Return `true` if the array is trionic, otherwise return `false`.

---

## 📌 Examples

### Example 1

```

Input: nums = [1,3,5,4,2,6]
Output: true

```

Explanation:

- Choose `p = 2`, `q = 4`
- `[1,3,5]` is strictly increasing
- `[5,4,2]` is strictly decreasing
- `[2,6]` is strictly increasing

---

### Example 2

```

Input: nums = [2,1,3]
Output: false

```

Explanation:

- No valid way to split the array into the required three segments

---

## 📋 Constraints

- `3 <= n <= 100`
- `-1000 <= nums[i] <= 1000`

---

## 💡 Solution Approach (Single Pass / Greedy)

### Key Insight

A trionic array must follow **three strict monotonic phases in order**:

1. Increasing
2. Decreasing
3. Increasing

We can validate this by scanning the array **once** and ensuring:

- Each phase has **at least one comparison**
- The transitions occur in the correct order

---

## 🧩 Algorithm Steps

1. Start from index `0`
2. Move forward while the array is **strictly increasing**
   - Mark the end as `p`
3. Continue while the array is **strictly decreasing**
   - Mark the end as `q`
4. Continue while the array is **strictly increasing**
5. Check that:
   - All three phases exist
   - The scan ends exactly at the last index

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n)** — single traversal of the array

### Space Complexity

- **O(1)** — constant extra space

---

## 🧪 Edge Cases Covered

- Array too short
- No increasing phase at the start
- No decreasing middle phase
- No increasing phase at the end
- Equal adjacent elements (invalid due to strictness)

---
