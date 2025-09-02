# 🪟 LeetCode 239. Sliding Window Maximum

### 📌 Problem

Given an array of integers `nums`, there is a sliding window of size `k` moving from the left to the right.  
Return the maximum element in each sliding window.

🔗 [Problem Link](https://leetcode.com/problems/sliding-window-maximum/)

---

### 💡 Examples

**Example 1**  
Input:

```text
nums = [1,3,-1,-3,5,3,6,7], k = 3
```

Output:

```text
[3,3,5,5,6,7]
```

**Example 2**
Input:

```text
nums = [1], k = 1
```

Output:

```text
[1]
```

---

### ⚙️ Approach (Monotonic Deque)

1. Use a **deque** to store indices of elements in the current window.

   - Maintain decreasing order of values in the deque.
   - Front of deque = index of max element.

2. For each element:

   - Remove indices that are out of the current window (`i - k`).
   - Remove elements from the back that are smaller than current `nums[i]`.
   - Add current index.

3. Starting from index `i = k - 1`, add `nums[dq.front()]` to result.

---

### 🛠️ Complexity

- **Time:** `O(n)` (each element added and removed at most once)
- **Space:** `O(k)` (deque stores at most `k` indices)

---

### 🧑‍💻 Code

See [SlidingWindowMaximum.java](./SlidingWindowMaximum.java) for the full implementation.

---

### 📊 Dry Run Example

For `nums = [1,3,-1,-3,5,3,6,7], k = 3`

| Step | Window     | Deque (indices) | Max |
| ---- | ---------- | --------------- | --- |
| 1    | \[1,3,-1]  | \[1] → (3)      | 3   |
| 2    | \[3,-1,-3] | \[1] → (3)      | 3   |
| 3    | \[-1,-3,5] | \[4] → (5)      | 5   |
| 4    | \[-3,5,3]  | \[4] → (5)      | 5   |
| 5    | \[5,3,6]   | \[6] → (6)      | 6   |
| 6    | \[3,6,7]   | \[7] → (7)      | 7   |

Result = `[3,3,5,5,6,7]`
