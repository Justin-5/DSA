# 209. Minimum Size Subarray Sum

## 🧩 Problem Description

Given an array of positive integers `nums` and a positive integer `target`,  
return the **minimal length of a contiguous subarray** whose sum is greater than or equal to `target`.  
If there is no such subarray, return `0` instead.

---

## 🔍 Example 1

**Input**

```

target = 7
nums = [2,3,1,2,4,3]

```

**Output**

```

2

```

**Explanation**
The subarray `[4,3]` has a sum of 7 and is the shortest possible.

---

## 🔍 Example 2

**Input**

```

target = 4
nums = [1,4,4]

```

**Output**

```

1

```

**Explanation**
The subarray `[4]` already meets the target with length `1`.

---

## 🔍 Example 3

**Input**

```

target = 11
nums = [1,1,1,1,1,1,1,1]

```

**Output**

```

0

```

**Explanation**
No subarray can reach a sum of 11, so the result is 0.

---

## ⚙️ Constraints

- `1 <= target <= 10^9`
- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^4`

---

## 💡 Approach — Sliding Window (O(n))

We maintain a **sliding window** that dynamically expands and shrinks to find the smallest valid subarray.

### Steps:

1. Initialize two pointers:
   - `l` → left boundary of the window
   - `r` → right boundary (loop index)
2. Keep a running sum `curSum` of the window `[l..r]`.
3. For each `r`:
   - Add `nums[r]` to `curSum`.
   - While `curSum >= target`,
     - Update `minLen` as the smaller of its current value and the current window length.
     - Shrink the window by subtracting `nums[l]` and incrementing `l`.
4. Return `minLen` if found, else `0`.

This efficiently tracks the smallest valid subarray using a single pass.

---

## 🧮 Example Walkthrough

**Input**

```

target = 7
nums = [2,3,1,2,4,3]

```

| Step     | r   | nums[r] | curSum | l   | Window    | minLen |
| -------- | --- | ------- | ------ | --- | --------- | ------ |
| 0        | 0   | 2       | 2      | 0   | [2]       | ∞      |
| 1        | 1   | 3       | 5      | 0   | [2,3]     | ∞      |
| 2        | 2   | 1       | 6      | 0   | [2,3,1]   | ∞      |
| 3        | 3   | 2       | 8      | 0   | [2,3,1,2] | 4      |
| → shrink | -   | -       | 6      | 1   | [3,1,2]   | 4      |
| 4        | 4   | 4       | 10     | 1   | [3,1,2,4] | 4      |
| → shrink | -   | -       | 7      | 2   | [1,2,4]   | 3      |
| → shrink | -   | -       | 6      | 3   | [2,4]     | **2**  |
| 5        | 5   | 3       | 9      | 3   | [2,4,3]   | 2      |
| → shrink | -   | -       | 7      | 4   | [4,3]     | **2**  |

✅ Final Answer = 2

---

## ⏱️ Complexity Analysis

| Type      | Complexity | Explanation                                             |
| --------- | ---------- | ------------------------------------------------------- |
| **Time**  | `O(n)`     | Each element is visited at most twice (expand + shrink) |
| **Space** | `O(1)`     | Uses only constant extra variables                      |
