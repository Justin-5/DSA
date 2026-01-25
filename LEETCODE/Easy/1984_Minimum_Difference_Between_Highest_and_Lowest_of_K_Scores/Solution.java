import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {

        // Sort the array to bring scores in order
        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;

        // Sliding window of size k
        for (int i = 0; i <= n - k; i++) {
            // Difference between highest and lowest in the window
            int diff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
