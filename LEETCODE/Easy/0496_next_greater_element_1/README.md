# 496. Next Greater Element I

## 📝 Problem Statement

The **next greater element** of some element `x` in an array is the first greater element to the **right** of `x` in the same array.

- You are given two **distinct** 0-indexed integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.
- For each element in `nums1`, find its **next greater element** in `nums2`.
- If no such element exists, return `-1`.

Return an array `ans` where `ans[i]` is the next greater element for `nums1[i]`.

---

## ✅ Examples

**Example 1:**
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:

4 → no next greater → -1

1 → next greater is 3

2 → no next greater → -1

**Example 2:**
Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation:

2 → next greater is 3

4 → no next greater → -1

---

## 🔒 Constraints

- `1 <= nums1.length <= nums2.length <= 1000`
- `0 <= nums1[i], nums2[i] <= 10^4`
- All integers in `nums1` and `nums2` are unique.
- All elements of `nums1` appear in `nums2`.

---

## 💡 Approach

We use a **monotonic decreasing stack** to efficiently precompute the next greater element for each element in `nums2`.

### Steps:

1. Traverse `nums2`.
2. Use a stack to maintain decreasing elements.
   - While current element is greater than stack top:
     - Pop the stack and record its next greater as the current element.
3. Store results in a HashMap (`num -> nextGreater`).
4. Build the final result for `nums1` using the map.

---

## 🧩 Code (Java)

```java
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int len = nums1.length;
        int[] ans = new int[len];

        for (int num : nums2) {
            while (!stk.isEmpty() && stk.peek() < num) {
                int top = stk.pop();
                nextGreater.put(top, num);
            }
            stk.push(num);
        }

        for (int s : stk) {
            nextGreater.put(s, -1);
        }

        for (int i = 0; i < len; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        return ans;
    }
}
🚀 Complexity Analysis
Time Complexity: O(n + m) →
where n = nums1.length and m = nums2.length. Each element pushed/popped at most once.

Space Complexity: O(m) → HashMap + Stack for nums2.
```
