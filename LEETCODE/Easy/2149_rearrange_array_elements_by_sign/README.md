# 2149. Rearrange Array Elements by Sign 🔄

**Difficulty:** Medium  
**Topics:** Arrays, Two Pointers, Simulation  
**LeetCode Link:** [2149. Rearrange Array Elements by Sign](https://leetcode.com/problems/rearrange-array-elements-by-sign/)

---

## 🧩 Problem Statement

You are given an integer array `nums` of **even length**, containing an equal number of **positive and negative** integers.

You need to rearrange the array such that:

1. Every consecutive pair of integers have **opposite signs**.
2. For all integers with the **same sign**, their **relative order** in `nums` is preserved.
3. The rearranged array **begins with a positive integer**.

Return the modified array after rearranging the elements to satisfy all the conditions.

---

### 🔹 Example 1

**Input:**

```

nums = [3,1,-2,-5,2,-4]

```

**Output:**

```

[3,-2,1,-5,2,-4]

```

**Explanation:**

- Positive integers → `[3, 1, 2]`
- Negative integers → `[-2, -5, -4]`
- Interleave starting with positive → `[3, -2, 1, -5, 2, -4]`.

---

### 🔹 Example 2

**Input:**

```

nums = [-1,1]

```

**Output:**

```

[1,-1]`

```

**Explanation:**  
Only one positive (`1`) and one negative (`-1`) element.  
The rearranged array starts with the positive number.

---

## 💡 Approach

### 🔸 Step 1: Create a Result Array

- Create an array `res` of the same length as `nums`.

### 🔸 Step 2: Maintain Two Pointers

- Use `positive = 0` to fill positive numbers at even indices.
- Use `negative = 1` to fill negative numbers at odd indices.

### 🔸 Step 3: Iterate and Place Elements

- Traverse `nums`.
  - If `num > 0`, place it at `res[positive]` and increment `positive += 2`.
  - If `num < 0`, place it at `res[negative]` and increment `negative += 2`.

### 🔸 Step 4: Return `res`

This guarantees:

- Positives and negatives alternate.
- The original order is preserved.
- The sequence starts with a positive.

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                                 |
| ------------ | ------------------------------------------- |
| ⏱️ **Time**  | O(N) — Single pass through the array        |
| 💾 **Space** | O(N) — Separate array for rearranged result |

---

## 🧠 Key Insights

- Even indices → Positive numbers.
- Odd indices → Negative numbers.
- This is **not in-place**, but ensures correct order and alternation.
