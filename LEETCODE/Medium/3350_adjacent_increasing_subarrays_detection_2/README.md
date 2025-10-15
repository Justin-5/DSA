# 3350. Adjacent Increasing Subarrays Detection II 🔢

**Difficulty:** Medium  
**Topics:** Arrays, Sliding Window, Greedy  
**LeetCode Link:** [3350. Adjacent Increasing Subarrays Detection II](https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/)

---

## 🧩 Problem Statement

You are given an array `nums` of `n` integers.

Your task is to find the **maximum value of `k`** for which there exist **two adjacent subarrays** of **length `k`** each, such that **both subarrays are strictly increasing**.

Specifically, you need to find two subarrays of length `k` starting at indices `a` and `b` (`a < b`), where:

- Both `nums[a..a+k-1]` and `nums[b..b+k-1]` are strictly increasing.
- The subarrays are **adjacent**, meaning `b = a + k`.

Return the **maximum possible value of `k`**.

---

### 🔹 Example 1

**Input:**

```

nums = [2,5,7,8,9,2,3,4,3,1]

```

**Output:**

```

3

```

**Explanation:**

- The subarray starting at index `2` is `[7, 8, 9]` → strictly increasing.
- The subarray starting at index `5` is `[2, 3, 4]` → strictly increasing.  
  These two subarrays are adjacent, so `k = 3`.

---

### 🔹 Example 2

**Input:**

```

nums = [1,2,3,4,4,4,4,5,6,7]

```

**Output:**

```

2

```

**Explanation:**

- The subarray `[1, 2]` (indices 0–1) and `[3, 4]` (indices 2–3) are both strictly increasing and adjacent.
  Hence, `k = 2`.

---

## 💡 Approach

### 🔸 Idea

We need the **maximum `k`** such that there exist **two consecutive strictly increasing subarrays** of length `k`.  
We can solve this in **O(n)** using a single pass and two counters.

---

### 🔹 Steps:

1. Use two variables:

   - `suff`: length of the current increasing suffix (current increasing segment).
   - `prev`: length of the previous increasing segment (just before a break).

2. As you iterate through the array:

   - If `nums[i] > nums[i-1]`, extend the current increasing segment (`suff++`).
   - Else, mark the current segment as the new `prev`, and reset `suff = 1`.

3. After each step:

   - The best possible `k` so far is `max(k, max(suff/2, min(prev, suff)))`.
     - `min(prev, suff)` ensures both adjacent increasing subarrays exist.
     - `suff/2` handles overlapping or continuous segments.

4. Return `k` as the maximum value found.

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                          |
| ------------ | ------------------------------------ |
| ⏱️ **Time**  | O(N) — Single pass through the array |
| 💾 **Space** | O(1) — Constant extra space          |

---

## 🧠 Example Walkthrough

**Example:**  
`nums = [2,5,7,8,9,2,3,4,3,1]`

| i   | nums[i] | Relation | prev | suff | k        |
| --- | ------- | -------- | ---- | ---- | -------- |
| 1   | 5 > 2   | ↑        | 0    | 2    | 1        |
| 2   | 7 > 5   | ↑        | 0    | 3    | 1        |
| 3   | 8 > 7   | ↑        | 0    | 4    | 2        |
| 4   | 9 > 8   | ↑        | 0    | 5    | 2        |
| 5   | 2 < 9   | ↓        | 5    | 1    | 2        |
| 6   | 3 > 2   | ↑        | 5    | 2    | 2        |
| 7   | 4 > 3   | ↑        | 5    | 3    | **3** ✅ |

Final answer: **3**
