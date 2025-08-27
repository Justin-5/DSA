# 739. Daily Temperatures

## 📝 Problem Statement

Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that:

- `answer[i]` = number of days you have to wait after the i-th day to get a **warmer temperature**.
- If there is no future day for which this is possible, keep `answer[i] == 0`.

---

## ✅ Examples

**Example 1:**
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

**Example 2:**
Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

**Example 3:**
Input: temperatures = [30,60,90]
Output: [1,1,0]

---

## 🔒 Constraints

- `1 <= temperatures.length <= 10^5`
- `30 <= temperatures[i] <= 100`

---

## 💡 Approach

We use a **monotonic decreasing stack** to keep track of indices of temperatures that haven't yet found a warmer day.

### Logic:

1. Initialize an empty stack `nextWarm` (stores indices of unresolved temperatures).
2. Iterate through each day `i`:
   - While stack is not empty and `temperatures[i] > temperatures[stack.top()]`:
     - Pop the index `top` from the stack.
     - Calculate `answer[top] = i - top` (days waited for warmer temp).
   - Push current index `i` onto the stack.
3. Remaining indices in stack get `0` (default, as no warmer day exists).

This ensures each index is pushed and popped at most once.

---

## 🧩 Code (Java)

```java
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> nextWarm = new Stack<>();
        int len = temperatures.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            // Resolve all previous days that are colder than today
            while (!nextWarm.isEmpty() && temperatures[nextWarm.peek()] < temperatures[i]) {
                int top = nextWarm.pop();
                answer[top] = i - top;  // Days waited for a warmer day
            }
            // Store current day's index
            nextWarm.push(i);
        }
        return answer;
    }
}
🚀 Complexity Analysis
Time Complexity: O(n) → Each index pushed and popped at most once.

Space Complexity: O(n) → Stack may store up to n indices in the worst case (strictly decreasing temperatures).
```
