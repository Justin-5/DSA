import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        // Step 1: Sort the array in ascending order
        Arrays.sort(nums);

        // Step 2: Traverse from largest to smallest
        for (int i = nums.length - 1; i > 1; i--) {
            // Check triangle inequality:
            // nums[i-2] + nums[i-1] > nums[i]
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                // Valid triangle found, return perimeter
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }

        // Step 3: No valid triangle
        return 0;
    }
}
