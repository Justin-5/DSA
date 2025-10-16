# 485. Max Consecutive Ones 🔢

**Difficulty:** Easy  
**Topics:** Array, Counting  
**LeetCode Link:** [485. Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

---

## 🧩 Problem Statement

Given a **binary array** `nums`, return the maximum number of **consecutive 1's** in the array.

---

### 🔹 Example 1

**Input:**

```

nums = [1,1,0,1,1,1]

```

**Output:**

```

3

```

**Explanation:**
The first two digits (`[1,1]`) and the last three digits (`[1,1,1]`) are consecutive 1's.  
The maximum number of consecutive 1's is **3**.

---

### 🔹 Example 2

**Input:**

```

nums = [1,0,1,1,0,1]

```

**Output:**

```

2

```

---

## ⚙️ Constraints

- `1 <= nums.length <= 10⁵`
- `nums[i]` is either `0` or `1`.

---

## 💡 Approach

### 🔸 Intuition

We scan the array once, counting consecutive 1’s:

- When we see a `1`, increment a counter `curMaxOnes`.
- When we see a `0`, compare and update `maxOnes` with `curMaxOnes`, then reset `curMaxOnes` to 0.
- At the end, ensure to update `maxOnes` again (to handle the case when the array ends with 1’s).

---

### 🔹 Steps

1. Initialize two variables:
   - `curMaxOnes` → counts current streak of 1’s.
   - `maxOnes` → tracks the maximum streak.
2. Traverse the array:
   - If `nums[i] == 1`, increment `curMaxOnes`.
   - If `nums[i] == 0`, update `maxOnes` and reset `curMaxOnes`.
3. After the loop, take `max(maxOnes, curMaxOnes)` for the final result.

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                       |
| ------------ | --------------------------------- |
| ⏱️ **Time**  | O(n) — one pass through the array |
| 💾 **Space** | O(1) — uses only a few variables  |

---

## 🧠 Example Walkthrough

**Input:**  
`nums = [1,1,0,1,1,1]`

| Step     | i   | nums[i] | curMaxOnes | maxOnes |
| -------- | --- | ------- | ---------- | ------- |
| 0        | 0   | 1       | 1          | 0       |
| 1        | 1   | 1       | 2          | 0       |
| 2        | 2   | 0       | 0          | 2       |
| 3        | 3   | 1       | 1          | 2       |
| 4        | 4   | 1       | 2          | 2       |
| 5        | 5   | 1       | 3          | 2       |
| ✅ Final | -   | -       | -          | **3**   |
