// 3349. Adjacent Increasing Subarrays Detection I
// Approach: Brute force with sliding window + helper to check strictly increasing subarrays

import java.util.*;

class Solution {

    // Helper function to check if subarray nums[start..end] is strictly increasing
    public boolean isIncreasing(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false; // not strictly increasing
            }
        }
        return true;
    }

    // Main function to detect adjacent increasing subarrays
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        // Traverse up to where two full subarrays of length k fit
        for (int i = 0; i <= nums.size() - 2 * k; i++) {
            // Check if both subarrays are strictly increasing
            if (isIncreasing(nums, i, i + k - 1) && isIncreasing(nums, i + k, i + 2 * k - 1)) {
                return true;
            }
        }
        return false; // no valid pair found
    }
}
