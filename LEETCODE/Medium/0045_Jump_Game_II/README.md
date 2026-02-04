# 45. Jump Game II

## 🧠 Problem Description

You are given a **0-indexed** integer array `nums` of length `n`.

- You start at index `0`
- Each element `nums[i]` represents the **maximum jump length** from index `i`
- From index `i`, you can jump to any index `i + j` where:
  - `0 <= j <= nums[i]`
  - `i + j < n`

Your goal is to return the **minimum number of jumps** required to reach index `n - 1`.

It is guaranteed that you can always reach the last index.

---

## 📌 Examples

### Example 1

```

Input: nums = [2,3,1,1,4]
Output: 2

```

Explanation:

- Jump from index `0` → `1`
- Jump from index `1` → `4`
- Total jumps = `2`

---

### Example 2

```

Input: nums = [2,3,0,1,4]
Output: 2

```

---

## 📋 Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 1000`
- It is guaranteed that the last index is reachable

---

## 💡 Solution Approach (Greedy / Level-Based Traversal)

### Key Insight

This problem can be solved greedily by thinking of jumps as **levels** (similar to BFS):

- Each jump lets you reach a **range of indices**
- From that range, choose the farthest position you can reach with the next jump
- Increment the jump count **only when you finish exploring the current range**

---

## 🧩 Algorithm Explanation

We maintain three variables:

- `currentEnd` → the farthest index reachable with the current number of jumps
- `farthest` → the farthest index reachable from all positions explored so far
- `jumps` → number of jumps made

### Steps

1. Start at index `0`
2. Traverse the array:
   - Update `farthest = max(farthest, i + nums[i])`
3. When you reach `currentEnd`:
   - You must make a jump
   - Update `currentEnd = farthest`
   - Increment `jumps`
4. Stop once `currentEnd >= n - 1`

---

## ⏱️ Time and Space Complexity

### Time Complexity

- **O(n)** — single pass through the array

### Space Complexity

- **O(1)** — constant extra space

---

## 🧪 Edge Cases Covered

- Single element array (`n = 1`)
- Large jump values
- Zero values inside the array
- Guaranteed reachability

---
