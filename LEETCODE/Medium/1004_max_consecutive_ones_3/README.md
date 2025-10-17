# 1004. Max Consecutive Ones III 🔢

**Difficulty:** Medium  
**Topics:** Sliding Window, Two Pointers  
**LeetCode Link:** [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)

---

## 🧩 Problem Statement

Given a **binary array** `nums` and an integer `k`, return the maximum number of consecutive 1's in the array if you can **flip at most `k` zeros**.

---

### 🔹 Example 1

**Input:**

```

nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2

```

**Output:**

```

6

```

**Explanation:**
After flipping at most 2 zeros, the subarray `[1,1,1,0,0,1,1,1,1,1,1]`  
contains 6 consecutive 1's.

---

### 🔹 Example 2

**Input:**

```

nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]
k = 3

```

**Output:**

```

10

```

**Explanation:**
By flipping at most 3 zeros, the longest subarray of 1's has length 10.

---

## ⚙️ Constraints

- `1 <= nums.length <= 10⁵`
- `nums[i]` is either `0` or `1`
- `0 <= k <= nums.length`

---

## 💡 Approach

### 🔸 Intuition

We need the **longest window (subarray)** that can contain at most `k` zeros.  
We use a **sliding window** technique:

- Expand the right end of the window.
- Keep track of how many zeros are inside.
- If the count of zeros exceeds `k`, move the left pointer to shrink the window until it becomes valid again.

---

### 🔹 Steps

1. Use two pointers: `i` (window start) and `j` (window end).
2. Increment `zeroes` whenever `nums[j] == 0`.
3. If `zeroes > k`, move `i` right until `zeroes <= k`.
4. Update `maxOnes` as the current valid window size `j - i + 1`.

---

### 🧮 Complexity Analysis

| Complexity   | Explanation                                  |
| ------------ | -------------------------------------------- |
| ⏱️ **Time**  | O(n) — each element is visited at most twice |
| 💾 **Space** | O(1) — only a few variables are used         |

---

## 🧠 Example Walkthrough

**Input:**  
`nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2`

| Step | j   | nums[j] | zeroes | i   | Window Size | maxOnes  |
| ---- | --- | ------- | ------ | --- | ----------- | -------- |
| 0    | 0   | 1       | 0      | 0   | 1           | 1        |
| 1    | 1   | 1       | 0      | 0   | 2           | 2        |
| 2    | 2   | 1       | 0      | 0   | 3           | 3        |
| 3    | 3   | 0       | 1      | 0   | 4           | 4        |
| 4    | 4   | 0       | 2      | 0   | 5           | 5        |
| 5    | 5   | 0       | 3      | 1   | 5           | 5        |
| 6    | 6   | 1       | 2      | 3   | 4           | 5        |
| 7    | 7   | 1       | 2      | 3   | 5           | 5        |
| 8    | 8   | 1       | 2      | 3   | 6           | ✅ **6** |
