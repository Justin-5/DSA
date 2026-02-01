# 3010. Divide an Array Into Subarrays With Minimum Cost I

## 🧠 Problem Description

You are given an integer array `nums` of length `n`.

The **cost of an array** is defined as the value of its **first element**.

You must divide `nums` into **exactly 3 disjoint contiguous subarrays**.

Your task is to return the **minimum possible sum of the costs** of these 3 subarrays.

---

## 📌 Examples

### Example 1

```

Input: nums = [1,2,3,12]
Output: 6

```

Explanation:

- Best partition: `[1]`, `[2]`, `[3,12]`
- Cost = `1 + 2 + 3 = 6`

---

### Example 2

```

Input: nums = [5,4,3]
Output: 12

```

Explanation:

- Only possible partition: `[5]`, `[4]`, `[3]`
- Cost = `5 + 4 + 3 = 12`

---

### Example 3

```

Input: nums = [10,3,1,1]
Output: 12

```

Explanation:

- Best partition: `[10,3]`, `[1]`, `[1]`
- Cost = `10 + 1 + 1 = 12`

---

## 📋 Constraints

- `3 <= n <= 50`
- `1 <= nums[i] <= 50`

---

## 💡 Key Insight

- The **first subarray must always start at index `0`**
- So its cost is always `nums[0]`
- For the remaining two subarrays:
  - Their costs are the **first elements** of those subarrays
  - To minimize total cost, we should choose the **two smallest values** from the remaining elements

⚠️ Note:

- Subarrays must be **contiguous**, but since we only care about the **first elements**, picking the two smallest values after index `0` always gives the minimum cost.

---

## 🧩 Algorithm Steps

1. Initialize total cost with `nums[0]`
2. Find the **two smallest values** in the range `nums[1..n-1]`
3. Add them to the total cost
4. Return the result

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n)** — single pass to find two minimum values

### Space Complexity

- **O(1)** — constant extra space

---

## 🧪 Edge Cases Covered

- Minimum array size (`n = 3`)
- Duplicate values
- Already optimal partitions
- Large values within constraints

---

## 🧑‍💻 Author Notes

This is a **greedy observation-based problem**:

- No need to try all partitions
- Directly minimizing the contributing costs gives the optimal solution
- Very efficient and interview-friendly

```

```
