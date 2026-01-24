import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {

        // Sort the array to enable optimal pairing
        Arrays.sort(nums);

        int max = 0;                    // Stores the maximum pair sum
        int i = 0;                      // Pointer to smallest element
        int j = nums.length - 1;        // Pointer to largest element

        // Pair smallest with largest
        while (i < j) {
            int pairSum = nums[i] + nums[j];

            // Update maximum pair sum
            max = pairSum > max ? pairSum : max;

            // Move pointers inward
            i++;
            j--;
        }

        return max;
    }
}
