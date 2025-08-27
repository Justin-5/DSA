import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    /**
     * Next Greater Element I
     *
     * Given two arrays nums1 and nums2 where nums1 is a subset of nums2,
     * for each element in nums1 find the next greater element in nums2.
     * If it doesn't exist, return -1 for that element.
     *
     * Approach:
     * - Use a monotonic decreasing stack to precompute next greater elements for nums2.
     * - Store the result in a HashMap for O(1) lookups.
     * - Build the final answer for nums1 using the map.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>(); // map: num -> next greater
        Stack<Integer> stk = new Stack<>(); // stack to keep track of decreasing sequence
        int len = nums1.length;
        int[] ans = new int[len];

        // Process nums2 to find next greater for each element
        for (int num : nums2) {
            // Pop smaller elements and assign their next greater as current num
            while (!stk.isEmpty() && stk.peek() < num) {
                int top = stk.pop();
                nextGreater.put(top, num);
            }
            stk.push(num);
        }

        // Remaining elements have no next greater
        for (int s : stk) {
            nextGreater.put(s, -1);
        }

        // Build answer array for nums1
        for (int i = 0; i < len; i++) {
            ans[i] = nextGreater.get(nums1[i]);
        }
        return ans;
    }
}
