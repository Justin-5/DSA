# 🏗️ LeetCode 84. Largest Rectangle in Histogram

### 📌 Problem

You are given an array of integers `heights` representing bar heights of a histogram (each bar has width = 1).  
Return the **area of the largest rectangle** in the histogram.

🔗 [Problem Link](https://leetcode.com/problems/largest-rectangle-in-histogram/)

---

### 💡 Example

**Input:**

```text
heights = [2,1,5,6,2,3]
Output:
10
Explanation:

The largest rectangle has height = 5 and width = 2 (bars at indices 2 & 3).

Area = 5 * 2 = 10.

⚙️ Approach (Monotonic Stack)
Use a stack to keep indices of increasing heights.

For each bar:

If the current bar is taller, push it on stack.

If the current bar is shorter, pop bars from the stack until valid.

For each popped bar, calculate rectangle area with it as the smallest height.

After finishing the array, process remaining bars in the stack.

Track the maximum area found.

🛠️ Complexity
Time: O(n) → Each bar is pushed and popped at most once.

Space: O(n) → Stack to store indices.

```
