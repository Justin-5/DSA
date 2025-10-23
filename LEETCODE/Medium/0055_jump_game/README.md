# 55. Jump Game

**Difficulty:** Medium  
**Topics:** Greedy, Dynamic Programming, Array  
**LeetCode Link:** [55. Jump Game](https://leetcode.com/problems/jump-game/)

---

## 🧩 Problem Statement

You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your **maximum jump length** at that position.

Return `true` if you can reach the last index, or `false` otherwise.

---

## 🔹 Example 1

**Input:**

```

nums = [2,3,1,1,4]

```

**Output:**

```

true

```

**Explanation:**

```

Jump 1 step from index 0 to 1, then 3 steps to the last index.

```

---

## 🔹 Example 2

**Input:**

```

nums = [3,2,1,0,4]

```

**Output:**

```

false

```

**Explanation:**

```

You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

```

---

## ⚙️ Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^5`

---

## 💡 Approaches

### 🧠 1. Dynamic Programming (Bottom-Up)

- We start from the end and mark which indices can reach the end.
- For each index `i`, check if it can reach any `j` that is marked `true`.

#### Steps

1. Initialize a boolean array `dp` of size `n`.
2. Set `dp[n - 1] = true` (the last index can reach itself).
3. Iterate from right to left:
   - For each `i`, check if `i + nums[i]` can reach an index marked `true`.
4. Return `dp[0]`.

#### Example

```

nums = [2,3,1,1,4]
dp progression:
Index 4: true
Index 3: true (1 jump to 4)
Index 2: true (1 jump to 3)
Index 1: true (can reach 2/3/4)
Index 0: true (can reach 1 which is true)

```

✅ Can reach the end.

#### Time Complexity

- **O(n²)** — nested loop in the worst case.

#### Space Complexity

- **O(n)** — for the `dp` array.

---

### ⚡ 2. Greedy (Optimized)

You can solve it in **O(n)** using a greedy strategy:

- Track the **farthest index** reachable so far.
- Iterate through the array; if you ever find an index beyond your reach, return `false`.

Example Greedy Code:

```java
class Solution {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
```
