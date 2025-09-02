// 239. Sliding Window Maximum
// Problem: https://leetcode.com/problems/sliding-window-maximum/
// Hard difficulty
//
// Approach: Monotonic Deque
// ----------------------------------
// 1. Use a deque to store indices of useful elements in the current window.
// 2. Maintain deque in decreasing order of values (nums[index]).
// 3. Steps:
//    - Remove indices that are out of the current window.
//    - Remove all indices from the back where nums[index] < nums[i],
//      because they can't be the maximum anymore.
//    - Add current index to deque.
//    - Once we reach at least k-1, record the maximum (front of deque).
//
// Time Complexity: O(n) → each element is pushed/popped at most once.
// Space Complexity: O(k) for the deque.
//
// Example: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]

import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove all smaller elements (they can't be max if nums[i] is bigger)
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Window has formed (i >= k-1)
            if (i >= k - 1) {
                res.add(nums[dq.peekFirst()]); // front is max
            }
        }
        //To convert list to array using stream
        // int[] result = res.stream().mapToInt(i -> i).toArray();
        
        // Convert result list to array
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
