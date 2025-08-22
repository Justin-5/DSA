# 42. Trapping Rain Water

## Problem Statement

Given `n` non-negative integers representing an elevation map where the width of each bar is `1`, compute how much water it can trap after raining.

### Examples

#### Example 1:

Input:  
`height = [0,1,0,2,1,0,1,3,2,1,2,1]`  
Output:  
`6`

Explanation: The elevation map is represented by `[0,1,0,2,1,0,1,3,2,1,2,1]`.  
Here, 6 units of water can be trapped.

---

#### Example 2:

Input:  
`height = [4,2,0,3,2,5]`  
Output:  
`9`

---

## Constraints

- `n == height.length`
- `1 <= n <= 2 * 10^4`
- `0 <= height[i] <= 10^5`

---

## Approaches

### 1️⃣ Brute Force Approach (O(n²))

- For each element, find the **highest bar on the left** and **highest bar on the right**.
- Water trapped at position `i` = `min(maxLeft, maxRight) - height[i]`.
- Repeat for all indices.
- Inefficient because finding maxLeft and maxRight requires scanning again for each element.

---

### 2️⃣ Optimized Two-Pointer Approach (O(n))

- Use **two pointers** (`left`, `right`) and track:
  - `maxLeft`: maximum height from the left side so far.
  - `maxRight`: maximum height from the right side so far.
- Move the pointer pointing to the smaller height inward.
- At each step, calculate trapped water as:
  - `maxLeft - height[left]` (when left side is smaller).
  - `maxRight - height[right]` (when right side is smaller).
- This ensures each index is processed only once.

---

## Comparison

| Approach           | Time Complexity | Space Complexity |
| ------------------ | --------------- | ---------------- |
| Brute Force        | O(n²)           | O(1)             |
| Two-Pointer (Best) | O(n)            | O(1)             |

---

## Code

(See `Solution.java` for full implementation with comments)
