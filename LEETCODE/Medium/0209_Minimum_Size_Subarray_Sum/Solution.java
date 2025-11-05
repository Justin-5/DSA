class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE; // stores minimal subarray length
        int curSum = 0;                 // current window sum
        int l = 0;                      // left pointer

        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r]; // expand the window

            // shrink window while it still satisfies the target
            while (curSum >= target && l <= r) {
                minLen = Math.min(minLen, r - l + 1);
                curSum -= nums[l];
                l++;
            }
        }

        // if no subarray found, return 0
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}
