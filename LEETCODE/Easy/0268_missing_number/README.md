# 268. Missing Number 🔢

**Difficulty:** Easy  
**Topics:** Array, Math, Bit Manipulation  
**LeetCode Link:** [268. Missing Number](https://leetcode.com/problems/missing-number/)

---

## 🧩 Problem Statement

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`,  
return the **only number** in the range that is missing from the array.

---

### 🔹 Example 1

**Input:**

```

nums = [3,0,1]

```

**Output:**

```

2

```

**Explanation:**  
n = 3 since there are 3 numbers, so all numbers are in the range [0,3].  
2 is missing since it does not appear in `nums`.

---

### 🔹 Example 2

**Input:**

```

nums = [0,1]

```

**Output:**

```

2

```

**Explanation:**  
n = 2 since there are 2 numbers, so all numbers are in the range [0,2].  
2 is missing since it does not appear in `nums`.

---

### 🔹 Example 3

**Input:**

```

nums = [9,6,4,2,3,5,7,0,1]

```

**Output:**

```

8

```

**Explanation:**  
All numbers from 0–9 should be present, but 8 is missing.

---

## ⚙️ Constraints

- `n == nums.length`
- `1 <= n <= 10⁴`
- `0 <= nums[i] <= n`
- All numbers in `nums` are **unique**

---

## 💡 Approach

### 🔸 Intuition

The sum of the first `n` natural numbers is given by:

\[
\text{sum} = \frac{n \times (n + 1)}{2}
\]

If we calculate the actual sum of the given array and subtract it from this expected sum,  
the difference gives the **missing number**.

---

### 🔹 Steps

1. Compute `n = nums.length`.
2. Find the **expected sum** using the formula `n * (n + 1) / 2`.
3. Compute the **actual sum** of all elements in `nums`.
4. Return the difference `expectedSum - actualSum`.

---

### 🧮 Complexity Analysis

| Complexity   | Explanation                          |
| ------------ | ------------------------------------ |
| ⏱️ **Time**  | O(n) — Single pass through the array |
| 💾 **Space** | O(1) — Constant extra space          |

---

## 🧠 Example Walkthrough

**Input:** `nums = [3, 0, 1]`

| Step           | Calculation     | Result |
| -------------- | --------------- | ------ |
| Expected sum   | 3 × (3 + 1) / 2 | 6      |
| Actual sum     | 3 + 0 + 1       | 4      |
| Missing number | 6 − 4           | ✅ 2   |
