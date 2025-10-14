# 3349. Adjacent Increasing Subarrays Detection I 📈

**Difficulty:** Easy  
**Topics:** Arrays, Sliding Window, Brute Force  
**LeetCode Link:** [3349. Adjacent Increasing Subarrays Detection I](https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/)

---

## 🧩 Problem Statement

You are given an integer array `nums` and an integer `k`.

Determine whether there exist **two adjacent subarrays** of length `k` such that:

1. Both subarrays are **strictly increasing**.
2. The subarrays are **adjacent**, meaning the second starts immediately after the first (`b = a + k`).

Return `true` if such two subarrays exist, otherwise return `false`.

---

### 🔹 Example 1

**Input:**

```

nums = [2,5,7,8,9,2,3,4,3,1], k = 3

```

**Output:**

```

true

```

**Explanation:**

- Subarray `[7,8,9]` (starting at index 2) is strictly increasing.
- Subarray `[2,3,4]` (starting at index 5) is also strictly increasing.
- These subarrays are **adjacent**, so the answer is `true`.

---

### 🔹 Example 2

**Input:**

```

nums = [1,2,3,4,4,4,4,5,6,7], k = 5

```

**Output:**

```

false

```

**Explanation:**  
No two adjacent subarrays of length 5 are strictly increasing.

---

## 💡 Approach

We can solve this with a **brute-force sliding window** approach:

### 🔸 Step 1: Iterate Through All Possible Windows

- For each valid index `i`, check two subarrays:
  - `nums[i .. i + k - 1]`
  - `nums[i + k .. i + 2k - 1]`
- Stop when `i + 2k - 1 < nums.length`.

### 🔸 Step 2: Check If Each Subarray Is Strictly Increasing

- Traverse the subarray and ensure every element is smaller than the next.

### 🔸 Step 3: Return True If Found

- If both subarrays satisfy the increasing property, return `true`.
- If no such pair exists, return `false`.

---

## 🧮 Complexity Analysis

| Complexity   | Explanation                                              |
| ------------ | -------------------------------------------------------- |
| ⏱️ **Time**  | O(N × K) — For each window, we check up to `2k` elements |
| 💾 **Space** | O(1) — Only a few variables used                         |

---

## 🧠 Key Insights

- The constraint `2 * k <= nums.length` ensures both subarrays fit.
- Checking strict increase is O(k) and simple comparison suffices.
- Works efficiently since `nums.length ≤ 100`.
