// 84. Largest Rectangle in Histogram
// Problem: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Hard difficulty
//
// Approach:
// 1. Use a monotonic increasing stack to keep indices of histogram bars.
// 2. For each bar, if it is taller than the bar on the top of the stack, push its index.
// 3. If it is shorter or equal, pop from the stack until the stack becomes valid again,
//    while computing the area for each popped bar as the smallest height.
// 4. After processing all bars, pop remaining bars from the stack and calculate area.
// 5. Track the maximum area found.
//
// Why it works:
// - The stack ensures we always maintain indices of bars with increasing heights.
// - When a shorter bar is encountered, it forces calculation of the maximum rectangle 
//   for taller bars that ended before this position.

import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>(); // stores indices of bars
        int maxArea = 0;

        // Step 1: Traverse all bars
        for (int i = 0; i < heights.length; i++) {
            // If current bar is smaller than stack's top bar, calculate area
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                int height = heights[stk.pop()]; // height of rectangle
                int right = i; // right boundary
                int left = stk.isEmpty() ? -1 : (int)stk.peek(); // left boundary
                int width = right - left - 1;
                int currArea = height * width;
                maxArea = Math.max(maxArea, currArea);
            }
            // Push current bar's index
            stk.push(i);
        }

        // Step 2: Clear out remaining bars in the stack
        while (!stk.isEmpty()) {
            int height = heights[stk.pop()];
            int right = heights.length;
            int left = stk.isEmpty() ? -1 : (int) stk.peek();
            int width = right - left - 1;
            int currArea = height * width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }
}
